package co.hcmus.shopcamera.data.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import co.hcmus.shopcamera.data.model.Account;
import co.hcmus.shopcamera.data.model.AccountType;
import co.hcmus.shopcamera.data.model.Comment;
import co.hcmus.shopcamera.data.model.History;
import co.hcmus.shopcamera.data.model.HistoryDetail;
import co.hcmus.shopcamera.data.model.Manufacturer;
import co.hcmus.shopcamera.data.model.PaymentType;
import co.hcmus.shopcamera.data.model.Permission;
import co.hcmus.shopcamera.data.model.PermissionDetail;
import co.hcmus.shopcamera.data.model.PointLevel;
import co.hcmus.shopcamera.data.model.Product;
import co.hcmus.shopcamera.data.model.ProductDetail;
import co.hcmus.shopcamera.data.model.ProductType;
import co.hcmus.shopcamera.data.model.Promotion;
import co.hcmus.shopcamera.data.model.PromotionDetail;
import co.hcmus.shopcamera.data.model.Rating;
import co.hcmus.shopcamera.data.model.Tag;

/**
 * This class use for initializing database
 * 
 * @author Thanh Toan
 *
 */
public class Initialization implements InitializingBean {

	private static final Logger logger = LoggerFactory.getLogger(Initialization.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("----------------------------------------------");
		logger.info("----------------------------------------------");
		logger.info("----------------INITIALIZATION----------------");
		logger.info("----------------------------------------------");

		// create collection Account if not exits
		if (!mongoTemplate.collectionExists(Account.class)) {
			mongoTemplate.createCollection(Account.class);
		}

		// create collection AccountType if not exits
		if (!mongoTemplate.collectionExists(AccountType.class)) {
			mongoTemplate.createCollection(AccountType.class);
		}
		// create collection Comment if not exits
		if (!mongoTemplate.collectionExists(Comment.class)) {
			mongoTemplate.createCollection(Comment.class);
		}
		// create collection History if not exits
		if (!mongoTemplate.collectionExists(History.class)) {
			mongoTemplate.createCollection(History.class);
		}
		// create collection HistoryDetail if not exits
		if (!mongoTemplate.collectionExists(HistoryDetail.class)) {
			mongoTemplate.createCollection(HistoryDetail.class);
		}
		// create collection Manufacturer if not exits
		if (!mongoTemplate.collectionExists(Manufacturer.class)) {
			mongoTemplate.createCollection(Manufacturer.class);
		}
		// create collection PaymentType if not exits
		if (!mongoTemplate.collectionExists(PaymentType.class)) {
			mongoTemplate.createCollection(PaymentType.class);
		}
		// create collection Permission if not exits
		if (!mongoTemplate.collectionExists(Permission.class)) {
			mongoTemplate.createCollection(Permission.class);
		}
		// create collection PermissionDetail if not exits
		if (!mongoTemplate.collectionExists(PermissionDetail.class)) {
			mongoTemplate.createCollection(PermissionDetail.class);
		}
		// create collection PointLevel if not exits
		if (!mongoTemplate.collectionExists(PointLevel.class)) {
			mongoTemplate.createCollection(PointLevel.class);
		}
		// create collection Product if not exits
		if (!mongoTemplate.collectionExists(Product.class)) {
			mongoTemplate.createCollection(Product.class);
		}
		// create collection ProductDetail if not exits
		if (!mongoTemplate.collectionExists(ProductDetail.class)) {
			mongoTemplate.createCollection(ProductDetail.class);
		}
		// create collection ProductType if not exits
		if (!mongoTemplate.collectionExists(ProductType.class)) {
			mongoTemplate.createCollection(ProductType.class);
		}
		// create collection Promotion if not exits
		if (!mongoTemplate.collectionExists(Promotion.class)) {
			mongoTemplate.createCollection(Promotion.class);
		}
		// create collection PromotionDetail if not exits
		if (!mongoTemplate.collectionExists(PromotionDetail.class)) {
			mongoTemplate.createCollection(PromotionDetail.class);
		}
		// create collection Rating if not exits
		if (!mongoTemplate.collectionExists(Rating.class)) {
			mongoTemplate.createCollection(Rating.class);
		}
		// create collection Tag if not exits
		if (!mongoTemplate.collectionExists(Tag.class)) {
			mongoTemplate.createCollection(Tag.class);
		}
	}
}
