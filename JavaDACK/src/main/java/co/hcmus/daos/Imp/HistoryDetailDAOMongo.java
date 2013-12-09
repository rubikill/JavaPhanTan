package co.hcmus.daos.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import co.hcmus.daos.IHistoryDetailDAO;
import co.hcmus.models.HistoryDetail;

@Repository("historyDetailDAO")
public class HistoryDetailDAOMongo implements IHistoryDetailDAO {
	@Autowired
	private MongoTemplate mongoTemplate;
	// Collection name save in MongoDB
	public static final String COLLECTION_NAME = "historydetail";

	@Override
	public void addHistoryDetail(HistoryDetail historyDetail) {
		if (!mongoTemplate.collectionExists(HistoryDetail.class)) {
			mongoTemplate.createCollection(HistoryDetail.class);
		}
		// insert a document	
		mongoTemplate.insert(historyDetail, COLLECTION_NAME);

	}

	@Override
	public void updateHistoryDetail(HistoryDetail historyDetail) {
		// update a document
		mongoTemplate.save(historyDetail, COLLECTION_NAME);

	}

	@Override
	public HistoryDetail getHistoryDetailById(String id) {
		Query searchHistoryDetailQuery = new Query(Criteria.where("_id").is(id));
		return mongoTemplate.findOne(searchHistoryDetailQuery,
				HistoryDetail.class, COLLECTION_NAME);
	}

	@Override
	public void deleteHistoryDetail(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<HistoryDetail> getHistoryDetails() {
		// get all docuemnt
		return mongoTemplate.findAll(HistoryDetail.class, COLLECTION_NAME);
	}

}
