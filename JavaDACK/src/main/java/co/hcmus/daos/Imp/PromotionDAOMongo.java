package co.hcmus.daos.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import co.hcmus.daos.IPromotionDAO;
import co.hcmus.models.Promotion;

public class PromotionDAOMongo implements IPromotionDAO{

	@Autowired
	private MongoTemplate mongoTemplate;
	// Collection name save in MongoDB
	public static final String COLLECTION_NAME = "promotion";
	
	public PromotionDAOMongo()
	{
		if (!mongoTemplate.collectionExists(Promotion.class)) {
			mongoTemplate.createCollection(Promotion.class);
		}
	}
	
	@Override
	public void addPromotion(Promotion promotion) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(promotion, COLLECTION_NAME);
	}

	@Override
	public void updatePromotion(Promotion promotion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getPromotionById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePromotion(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Promotion> getPromotions() {
		// TODO Auto-generated method stub
		return null;
	}

}
