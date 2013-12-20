package co.hcmus.daos.Imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IHistoryDetailDAO;
import co.hcmus.models.HistoryDetail;
import co.hcmus.util.STATUS;

@Repository("historyDetailDAO")
@Transactional
public class HistoryDetailDAOMongo implements IHistoryDetailDAO {
	
	private static final Logger logger = LoggerFactory
			.getLogger(HistoryDetailDAOMongo.class);
	@Autowired
	private MongoTemplate mongoTemplate;
	// Collection name save in MongoDB
	public static final String COLLECTION_NAME = "historyDetail";

	@Override
	public void addHistoryDetail(HistoryDetail historyDetail) {
		if (!mongoTemplate.collectionExists(HistoryDetail.class)) {
			mongoTemplate.createCollection(HistoryDetail.class);
		}
		// insert a document
		logger.info("HistoryDetailDAOMongo add historyDetailMongo");
		mongoTemplate.insert(historyDetail, COLLECTION_NAME);

	}

	@Override
	public void updateHistoryDetail(HistoryDetail historyDetail) {
		// update a document
		logger.info("HistoryDetailDAOMongo update historyDetailMongo with Id : " + historyDetail.getId());
		mongoTemplate.save(historyDetail, COLLECTION_NAME);

	}

	@Override
	public HistoryDetail getHistoryDetailById(String id) {
		Query searchHistoryDetailQuery = new Query(Criteria.where("_id").is(id));
		logger.info("HistoryDetailDAOMongo get historyDetailMongo with Id : " + id);
		return mongoTemplate.findOne(searchHistoryDetailQuery,
				HistoryDetail.class, COLLECTION_NAME);
	}

	@Override
	public void deleteHistoryDetail(String id) {
		// TODO Auto-generated method stub
		HistoryDetail historyDetail = getHistoryDetailById(id);
		historyDetail.setStatus(STATUS.INACTIVE.getStatusCode());
		logger.info("HistoryDetailDAOMongo delete historyDetailMongo with Id : " + id);
		mongoTemplate.save(historyDetail, COLLECTION_NAME);
	}

	@Override
	public List<HistoryDetail> getHistoryDetails() {
		// get all docuemnt
		logger.info("HistoryDetailDAOMongo get all historydetails");
		return mongoTemplate.findAll(HistoryDetail.class, COLLECTION_NAME);
	}

	@Override
	public List<HistoryDetail> getHistoryDetailByHistoryId(String historyId,
			String status) {
		// TODO Auto-generated method stub
		Query searchHistoryDetailByHistoryIdQuery = new Query(Criteria
				.where("historyId").is(historyId).and("status").is(status));
		logger.info("HistoryDetailDAOMongo get  historydetail with Id : " + historyId );
		return mongoTemplate.find(searchHistoryDetailByHistoryIdQuery,
				HistoryDetail.class, COLLECTION_NAME);
	}

	@Override
	public List<HistoryDetail> getHistoryDetailByProductId(String productId,
			String status) {
		// TODO Auto-generated method stub
		Query searchHistoryDetailByHistoryIdQuery = new Query(Criteria
				.where("productId").is(productId).and("status").is(status));
		logger.info("HistoryDetailDAOMongo get  historydetail with ProductId : " + productId );
		return mongoTemplate.find(searchHistoryDetailByHistoryIdQuery,
				HistoryDetail.class, COLLECTION_NAME);
	}

}
