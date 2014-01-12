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

import co.hcmus.shopcamera.data.dao.IProductDetailDAO;
import co.hcmus.shopcamera.data.model.ProductDetail;
import co.hcmus.shopcamera.utility.STATUS;

@Repository("productDetailDAO")
@Transactional
public class ProductDetailDAOMongo implements IProductDetailDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(ProductDetailDAOMongo.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;
	// Collection name save in MongoDB
	public static final String COLLECTION_NAME = "productDetail";

	@Override
	public void addProductDetail(ProductDetail productDetail) {
		if (!mongoTemplate.collectionExists(ProductDetail.class)) {
			mongoTemplate.createCollection(ProductDetail.class);
		}
		// insert a document
		logger.info("ProductDetailDAOMongo add productDetail");
		mongoTemplate.insert(productDetail, COLLECTION_NAME);

	}

	@Override
	public void updateProductDetail(ProductDetail productDetail) {
		// update a document
		logger.info("ProductDetailDAOMongo update productDetail with Id : " + productDetail.getId());
		mongoTemplate.save(productDetail, COLLECTION_NAME);

	}

	@Override
	public ProductDetail getProductDetailById(String id) {
		Query searchProductDetailQuery = new Query(Criteria.where("_id").is(id));
		logger.info("ProductDetailDAOMongo get productDetail with Id : " + id);
		return mongoTemplate.findOne(searchProductDetailQuery,
				ProductDetail.class, COLLECTION_NAME);
	}

	@Override
	public void deleteProductDetail(String id) {
		// TODO Auto-generated method stub
		ProductDetail productDetail = getProductDetailById(id);
		productDetail.setStatus(STATUS.INACTIVE.getStatusCode());
		logger.info("ProductDetailDAOMongo delete productDetail with Id : " + id);
		mongoTemplate.save(productDetail, COLLECTION_NAME);
	}

	@Override
	public List<ProductDetail> getProductDetails() {
		// get all docuemnt
		logger.info("ProductDetailDAOMongo get all  productDetail ");
		return mongoTemplate.findAll(ProductDetail.class, COLLECTION_NAME);
	}

	@Override
	public ProductDetail getProductDetailByProductId(String productId) {
		// TODO Auto-generated method stub
		Query searchProductDetailByProductIdQuery = new Query(Criteria.where("productId").is(productId));
		logger.info("ProductDetailDAOMongo get productDetail by ProductId : " + productId);
		return mongoTemplate.findOne(searchProductDetailByProductIdQuery,
				ProductDetail.class, COLLECTION_NAME);
	}

	@Override
	public void activeProductDetail(String id) {
		ProductDetail productDetail = getProductDetailById(id);
		productDetail.setStatus(STATUS.ACTIVE.getStatusCode());
		logger.info("ProductDetailDAOMongo active productDetail with id : " + id);
		mongoTemplate.save(productDetail, COLLECTION_NAME);
		
	}

}
