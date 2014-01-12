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

import co.hcmus.shopcamera.data.dao.IProductTypeDAO;
import co.hcmus.shopcamera.data.model.ProductType;
import co.hcmus.shopcamera.utility.STATUS;

@Repository("productTypeDAO")
@Transactional
public class ProductTypeDAOMongo implements IProductTypeDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(ProductTypeDAOMongo.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;
	// Collection name save in MongoDB
	public static final String COLLECTION_NAME = "productType";

	// Add new ProductType
	@Override
	public void addProductType(ProductType productType) {
		if (!mongoTemplate.collectionExists(ProductType.class)) {
			mongoTemplate.createCollection(ProductType.class);
		}
		logger.info("ProductTypeDAOMongo add productType with name : " + productType.getName());
		mongoTemplate.insert(productType, COLLECTION_NAME);

	}

	// Update ProductType
	@Override
	public void updateProductType(ProductType productType) {
		logger.info("ProductTypeDAOMongo update productType with id : " + productType.getId());
		mongoTemplate.save(productType, COLLECTION_NAME);

	}

	// Get a specific ProductType by id
	@Override
	public ProductType getProductType(String id) {
		Query searchProductTypeQuery = new Query(Criteria.where("_id").is(id));
		logger.info("ProductTypeDAOMongo get productType with id : " + id);
		return mongoTemplate.findOne(searchProductTypeQuery, ProductType.class,
				COLLECTION_NAME);
	}

	// Delete a ProductType
	@Override
	public void deleteProductType(String id) {
		ProductType productType = getProductType(id);
		productType.setStatus(STATUS.INACTIVE.getStatusCode());
		logger.info("ProductTypeDAOMongo delete productType with id : " + id);
		mongoTemplate.save(productType, COLLECTION_NAME);

	}

	// Get all ProductTypes
	@Override
	public List<ProductType> getProductTypes() {
		logger.info("ProductTypeDAOMongo get all producttype");
		return mongoTemplate.findAll(ProductType.class, COLLECTION_NAME);
	}

}
