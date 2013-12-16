package co.hcmus.daos.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IPromotionDetailDAO;
import co.hcmus.models.PromotionDetail;
import co.hcmus.util.STATUS;

@Repository("promotionDetailDAO")
@Transactional
public class PromotionDetailDAOMongo implements IPromotionDetailDAO {

	@Autowired
	private MongoTemplate mongoTemplate;
	// Collection name save in MongoDB
	public static final String COLLECTION_NAME = "promotionDetail";

	@Override
	public void addPromotionDetail(PromotionDetail promotionDetail) {
		if (!mongoTemplate.collectionExists(PromotionDetail.class)) {
			mongoTemplate.createCollection(PromotionDetail.class);
		}
		// insert a document
		mongoTemplate.insert(promotionDetail, COLLECTION_NAME);

	}

	@Override
	public void updatePromotionDetail(PromotionDetail promotionDetail) {
		// update a document
		mongoTemplate.save(promotionDetail, COLLECTION_NAME);

	}

	@Override
	public PromotionDetail getPromotionDetailByPromotionId(String id) {
		Query searchPromotionDetailQuery = new Query(Criteria.where("_id").is(
				id));
		return mongoTemplate.findOne(searchPromotionDetailQuery,
				PromotionDetail.class, COLLECTION_NAME);
	}

	@Override
	public void deletePromotionDetail(String id) {
		// delete propmotionDetail by id
		PromotionDetail promotionDetail = getPromotionDetailByPromotionId(id);
		promotionDetail.setStatus(STATUS.INACTIVE.getStatusCode());
		mongoTemplate.save(promotionDetail, COLLECTION_NAME);

	}

	@Override
	public List<PromotionDetail> getPromotionDetails() {
		// get all promotionsDetail
		return mongoTemplate.findAll(PromotionDetail.class, COLLECTION_NAME);
	}

	@Override
	public List<PromotionDetail> getPromotionDetailsByPromotionId(
			String promotionId, String status) {
		// TODO Auto-generated method stub
		Query searchPromotionDetailByPromotionId = new Query(Criteria
				.where("promotionId").is(promotionId).and("status").is(status));
		return mongoTemplate.find(searchPromotionDetailByPromotionId,
				PromotionDetail.class, COLLECTION_NAME);
	}

	@Override
	public List<PromotionDetail> getPromotionDetailsByProductId(
			String productId, String status) {
		// TODO Auto-generated method stub
		Query searchPromotionDetailByProductId = new Query(Criteria
				.where("productId").is(productId).and("status").is(status));
		return mongoTemplate.find(searchPromotionDetailByProductId,
				PromotionDetail.class, COLLECTION_NAME);
	}

}
