package co.hcmus.daos.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import co.hcmus.daos.IProductDetailDAO;
import co.hcmus.models.ProductDetail;

@Repository("productDetailDAO")
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

	}

	@Override
	public List<ProductDetail> getProductDetails() {
		// get all docuemnt
		return mongoTemplate.findAll(ProductDetail.class, COLLECTION_NAME);
	}

}
