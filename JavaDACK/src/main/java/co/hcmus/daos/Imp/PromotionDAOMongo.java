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

import co.hcmus.daos.IPromotionDAO;
import co.hcmus.models.Promotion;
import co.hcmus.util.STATUS;

@Repository("promotionDAO")
@Transactional
public class PromotionDAOMongo implements IPromotionDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(PromotionDAOMongo.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;
	// Collection name save in MongoDB
	public static final String COLLECTION_NAME = "promotion";

	@Override
	public void addPromotion(Promotion promotion) {
		if (!mongoTemplate.collectionExists(Promotion.class)) {
			mongoTemplate.createCollection(Promotion.class);
		}
		// insert a document
		logger.info("PromotionDAOMongo add promotion");
		mongoTemplate.insert(promotion, COLLECTION_NAME);
	}

	@Override
	public void updatePromotion(Promotion promotion) {
		// update a document
		logger.info("PromotionDAOMongo update promotion with id : " + promotion.getId() );
		mongoTemplate.save(promotion, COLLECTION_NAME);
	}

	@Override
	public Promotion getPromotionById(String id) {
		// get promotion by id
		// create query with _id
		Query searchPromotionQuery = new Query(Criteria.where("_id").is(id));
		logger.info("PromotionDAOMongo get promotion with id : " + id );
		return mongoTemplate.findOne(searchPromotionQuery, Promotion.class,
				COLLECTION_NAME);
	}

	@Override
	public void deletePromotion(String id) {
		// delete propmotion by id
		Promotion promotion = getPromotionById(id);
		promotion.setStatus(STATUS.INACTIVE.getStatusCode());
		logger.info("PromotionDAOMongo delete promotion with id : " + id );
		mongoTemplate.save(promotion, COLLECTION_NAME);
	}

	@Override
	public List<Promotion> getPromotions() {
		// get all promotions
		logger.info("PromotionDAOMongo get all promotions ");
		return mongoTemplate.findAll(Promotion.class, COLLECTION_NAME);
	}

}
