package co.hcmus.daos.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import co.hcmus.daos.IPromotionDAO;
import co.hcmus.models.Promotion;

@Repository("promotionDAO")
public class PromotionDAOMongo implements IPromotionDAO {

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
		mongoTemplate.insert(promotion, COLLECTION_NAME);
	}

	@Override
	public void updatePromotion(Promotion promotion) {
		// update a document
		mongoTemplate.save(promotion, COLLECTION_NAME);
	}

	@Override
	public Promotion getPromotionById(String id) {
		// get promotion by id
		// create query with _id
		Query searchPromotionQuery = new Query(Criteria.where("_id").is(id));
		return mongoTemplate.findOne(searchPromotionQuery, Promotion.class,
				COLLECTION_NAME);
	}

	@Override
	public void deletePromotion(String id) {
		// delete propmotion by id
		Promotion promotion = getPromotionById(id);
		mongoTemplate.remove(promotion, COLLECTION_NAME);
	}

	@Override
	public List<Promotion> getPromotions() {
		// get all promotions
		return mongoTemplate.findAll(Promotion.class, COLLECTION_NAME);
	}

}
