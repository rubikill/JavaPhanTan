package co.hcmus.daos.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import co.hcmus.daos.IHistoryDAO;
import co.hcmus.models.Account;
import co.hcmus.models.History;

@Repository("historyDAO")
public class HistoryDAOMongo implements IHistoryDAO {

	@Autowired
	private MongoTemplate mongoTemplate;
	// Collection name save in MongoDB
	public static final String COLLECTION_NAME = "history";

	// Add new History
	@Override
	public void addHistory(History history) {
		if (!mongoTemplate.collectionExists(Account.class)) {
			mongoTemplate.createCollection(Account.class);
		}
		mongoTemplate.insert(history, COLLECTION_NAME);

	}

	// Update
	@Override
	public void updateHistory(History history) {
		mongoTemplate.save(history, COLLECTION_NAME);

	}

	// Get specific History by id
	@Override
	public History getHistory(String id) {
		Query searchHistoryQuery = new Query(Criteria.where("id").is(id));
		return mongoTemplate.findOne(searchHistoryQuery, History.class,
				COLLECTION_NAME);
	}

	// Delete a specific History by id
	@Override
	public void deleteHistory(String id) {
		History history = getHistory(id);
		mongoTemplate.remove(history, COLLECTION_NAME);

	}

	// Get all Historys
	@Override
	public List<History> getHistorys() {
		return mongoTemplate.findAll(History.class, COLLECTION_NAME);
	}

}
