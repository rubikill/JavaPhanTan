package co.hcmus.daos.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IProductDetailDAO;
import co.hcmus.models.ProductDetail;
import co.hcmus.util.STATUS;

@Repository("productDetailDAO")
@Transactional
public class ProductDetailDAOMongo implements IProductDetailDAO {

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
		mongoTemplate.insert(productDetail, COLLECTION_NAME);

	}

	@Override
	public void updateProductDetail(ProductDetail productDetail) {
		// update a document
		mongoTemplate.save(productDetail, COLLECTION_NAME);

	}

	@Override
	public ProductDetail getProductDetailById(String id) {
		Query searchProductDetailQuery = new Query(Criteria.where("_id").is(id));
		return mongoTemplate.findOne(searchProductDetailQuery,
				ProductDetail.class, COLLECTION_NAME);
	}

	@Override
	public void deleteProductDetail(String id) {
		// TODO Auto-generated method stub
		ProductDetail productDetail = getProductDetailById(id);
		productDetail.setStatus(STATUS.INACTIVE.getStatusCode());
		mongoTemplate.save(productDetail, COLLECTION_NAME);
	}

	@Override
	public List<ProductDetail> getProductDetails() {
		// get all docuemnt
		return mongoTemplate.findAll(ProductDetail.class, COLLECTION_NAME);
	}

	@Override
	public ProductDetail getProductDetailByProductId(String productId) {
		// TODO Auto-generated method stub
		Query searchProductDetailByProductIdQuery = new Query(Criteria.where("productId").is(productId));
		return mongoTemplate.findOne(searchProductDetailByProductIdQuery,
				ProductDetail.class, COLLECTION_NAME);
	}

}
