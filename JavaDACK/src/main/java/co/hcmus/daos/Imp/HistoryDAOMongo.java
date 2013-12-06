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
	public static final String COLLECTION_NAME = "history";

	@Override
	public void addHistory(History history) {
		if (!mongoTemplate.collectionExists(Account.class)) {
			mongoTemplate.createCollection(Account.class);
		}
		mongoTemplate.insert(history, COLLECTION_NAME);

	}

	@Override
	public void updateHistory(History history) {
		mongoTemplate.insert(history, COLLECTION_NAME);

	}

	@Override
	public History getHistory(String id) {
		Query searchHistoryQuery = new Query(Criteria.where("id").is(id));
		return mongoTemplate.findOne(searchHistoryQuery, History.class,
				COLLECTION_NAME);
	}

	@Override
	public void deleteHistory(String id) {
		History history = getHistory(id);
		mongoTemplate.remove(history, COLLECTION_NAME);

	}

	@Override
	public List<History> getHistorys() {
		return mongoTemplate.findAll(History.class, COLLECTION_NAME);
	}
	
}
