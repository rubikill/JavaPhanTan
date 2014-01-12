package co.hcmus.shopcamera.data.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.shopcamera.data.dao.IHistoryDAO;
import co.hcmus.shopcamera.data.model.Account;
import co.hcmus.shopcamera.data.model.History;
import co.hcmus.shopcamera.utility.STATUS;

@Repository("historyDAO")
@Transactional
public class HistoryDAOMongo implements IHistoryDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(HistoryDAOMongo.class);
	
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
		logger.info("HistoryDAOMongo add History");
		mongoTemplate.insert(history, COLLECTION_NAME);

	}

	// Update
	@Override
	public void updateHistory(History history) {
		logger.info("HistoryDAOMongo update History with Id : " + history.getId());
		mongoTemplate.save(history, COLLECTION_NAME);

	}

	// Get specific History by id
	@Override
	public History getHistory(String id) {
		Query searchHistoryQuery = new Query(Criteria.where("_id").is(id));
		logger.info("HistoryDAOMongo get History with Id : " + id);
		return mongoTemplate.findOne(searchHistoryQuery, History.class,
				COLLECTION_NAME);
	}

	// Delete a specific History by id
	@Override
	public void deleteHistory(String id) {
		History history = getHistory(id);
		history.setStatus(STATUS.INACTIVE.getStatusCode());
		logger.info("HistoryDAOMongo delete History with Id : " + id);
		mongoTemplate.save(history, COLLECTION_NAME);

	}

	// Get all Historys
	@Override
	public List<History> getHistorys() {
		logger.info("HistoryDAOMongo get all History");
		return mongoTemplate.findAll(History.class, COLLECTION_NAME);
	}

	@Override
	public List<History> getHistorysByEmail(String email) {
		logger.info("HistoryDAOMongo get  History by email : " + email);
		return mongoTemplate.find(new Query(Criteria.where("email").is(email)), History.class);
	}

}
