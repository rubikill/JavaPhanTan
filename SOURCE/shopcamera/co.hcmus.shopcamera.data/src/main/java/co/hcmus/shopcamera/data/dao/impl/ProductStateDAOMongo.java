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

import co.hcmus.shopcamera.data.dao.IProductStateDAO;
import co.hcmus.shopcamera.data.model.ProductState;
import co.hcmus.shopcamera.utility.STATUS;

@Repository("productStateDAO")
@Transactional
public class ProductStateDAOMongo implements IProductStateDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(ProductStateDAOMongo.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;
	// Collection name save in MongoDB
	public static final String COLLECTION_NAME = "productState";

	@Override
	public void addProductState(ProductState productState) {
		logger.info("ProductStateDAOMongo add productState with name : " + productState.getName());
		mongoTemplate.insert(productState);

	}

	@Override
	public void updateProductState(ProductState productState) {
		logger.info("ProductStateDAOMongo update productState with Id : " + productState.getId());
		mongoTemplate.save(productState, COLLECTION_NAME);

	}

	@Override
	public ProductState getProductStateById(String id, String status) {
		Query searchProductStateQuery = new Query(Criteria.where("_id").is(id)
				.and("status").is(status));
		logger.info("ProductStateDAOMongo get productState with Id : " + id);
		return mongoTemplate.findOne(searchProductStateQuery,
				ProductState.class, COLLECTION_NAME);
	}

	@Override
	public void deleteProductState(String id) {
		// TODO Auto-generated method stub
		ProductState productState = getProductStateById(id, STATUS.ACTIVE.getStatusCode());
		productState.setStatus(STATUS.INACTIVE.getStatusCode());
		logger.info("ProductStateDAOMongo delete productState with Id : " + id);
		mongoTemplate.save(productState, COLLECTION_NAME);
	}

	@Override
	public List<ProductState> getProductStates() {
		// TODO Auto-generated method stub
		logger.info("ProductStateDAOMongo get all productState");
		return mongoTemplate.findAll(ProductState.class, COLLECTION_NAME);
	}

	@Override
	public ProductState getProductStateByName(String name, String status) {
		// TODO Auto-generated method stub
		Query searchProductStateQueryByname = new Query(Criteria.where("name").is(name)
				.and("status").is(status));
		logger.info("ProductStateDAOMongo get productstate by name : " + name);
		return mongoTemplate.findOne(searchProductStateQueryByname,
				ProductState.class, COLLECTION_NAME);
	}
}
