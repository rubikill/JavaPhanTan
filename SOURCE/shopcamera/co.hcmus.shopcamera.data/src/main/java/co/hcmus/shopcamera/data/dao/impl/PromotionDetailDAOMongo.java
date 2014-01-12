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

import co.hcmus.shopcamera.data.dao.IPromotionDetailDAO;
import co.hcmus.shopcamera.data.model.PromotionDetail;
import co.hcmus.shopcamera.utility.STATUS;

@Repository("promotionDetailDAO")
@Transactional
public class PromotionDetailDAOMongo implements IPromotionDetailDAO {

	
	private static final Logger logger = LoggerFactory
			.getLogger(PromotionDetailDAOMongo.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;
	// Collection name save in MongoDB
	public static final String COLLECTION_NAME = "promotionDetail";

	
	/**
	 * Add new PromotionDetail
	 * @param promotionDetail 
	 */
	@Override
	public void addPromotionDetail(PromotionDetail promotionDetail) {
		if (!mongoTemplate.collectionExists(PromotionDetail.class)) {
			mongoTemplate.createCollection(PromotionDetail.class);
		}
		// insert a document
		logger.info("PromotionDetailDAOMongo add promotionDetail");
		mongoTemplate.insert(promotionDetail, COLLECTION_NAME);

	}

	/**
	 * Update promotion detail
	 * @param promotionDetail 
	 */
	@Override
	public void updatePromotionDetail(PromotionDetail promotionDetail) {
		// update a document
		logger.info("PromotionDetailDAOMongo update promotionDetail with Id : " + promotionDetail.getId());
		mongoTemplate.save(promotionDetail, COLLECTION_NAME);

	}

	/**
	 * Get a specific PromotionDetail 
	 */
	@Override
	public PromotionDetail getPromotionDetailByPromotionDetailId(String id) {
		Query searchPromotionDetailQuery = new Query(Criteria.where("_id").is(
				id));
		logger.info("PromotionDetailDAOMongo get promotionDetail with Id : " + id);
		return mongoTemplate.findOne(searchPromotionDetailQuery,
				PromotionDetail.class, COLLECTION_NAME);
	}

	@Override
	public void deletePromotionDetail(String id) {
		// delete propmotionDetail by id
		PromotionDetail promotionDetail = getPromotionDetailByPromotionDetailId(id);
		promotionDetail.setStatus(STATUS.INACTIVE.getStatusCode());
		logger.info("PromotionDetailDAOMongo delete promotionDetail with Id : " + id);
		mongoTemplate.save(promotionDetail, COLLECTION_NAME);

	}

	@Override
	public List<PromotionDetail> getPromotionDetails() {
		// get all promotionsDetail
		logger.info("PromotionDetailDAOMongo get all promotionDetail");
		return mongoTemplate.findAll(PromotionDetail.class, COLLECTION_NAME);
	}

	@Override
	public List<PromotionDetail> getPromotionDetailsByPromotionIdWithoutStatus(
			String promotionId) {
		Query searchPromotionDetailByPromotionId = new Query(Criteria.where(
				"promotionId").is(promotionId));
		return mongoTemplate.find(searchPromotionDetailByPromotionId,
				PromotionDetail.class, COLLECTION_NAME);
	}

	@Override
	public List<PromotionDetail> getPromotionDetailsByPromotionId(
			String promotionId, String status) {
		Query searchPromotionDetailByPromotionId = new Query(Criteria
				.where("promotionId").is(promotionId).and("status").is(status));
		logger.info("PromotionDetailDAOMongo get promotionDetail with PromotionId : " + promotionId);
		return mongoTemplate.find(searchPromotionDetailByPromotionId,
				PromotionDetail.class, COLLECTION_NAME);
	}

	@Override
	public List<PromotionDetail> getPromotionDetailsByProductId(
			String productId, String status) {
		// TODO Auto-generated method stub
		Query searchPromotionDetailByProductId = new Query(Criteria
				.where("productId").is(productId).and("status").is(status));
		logger.info("PromotionDetailDAOMongo get promotionDetail with ProductId : " + productId);
		return mongoTemplate.find(searchPromotionDetailByProductId,
				PromotionDetail.class, COLLECTION_NAME);
	}

	@Override
	public void activePromotionDetail(String id) {
		PromotionDetail promotionDetail = getPromotionDetailByPromotionDetailId(id);
		promotionDetail.setStatus(STATUS.ACTIVE.getStatusCode());
		logger.info("PromotionDetailDAOMongo active promotionDetail with Id : " + id);
		mongoTemplate.save(promotionDetail, COLLECTION_NAME);
		
	}

}
