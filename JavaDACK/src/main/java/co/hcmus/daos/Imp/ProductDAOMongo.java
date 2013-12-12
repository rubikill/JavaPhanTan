package co.hcmus.daos.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import co.hcmus.daos.IProductDAO;
import co.hcmus.models.Product;

@Repository("productDAO")
public class ProductDAOMongo implements IProductDAO {

	@Autowired
	private MongoTemplate mongoTemplate;
	// Collection name save in MongoDB
	public static final String COLLECTION_NAME = "product";

	@Override
	public void addProduct(Product product) {
		if (!mongoTemplate.collectionExists(Product.class)) {
			mongoTemplate.createCollection(Product.class);
		}
		mongoTemplate.insert(product, COLLECTION_NAME);

	}

	@Override
	public void updateProduct(Product product) {
		// update a document
		mongoTemplate.save(product, COLLECTION_NAME);

	}

	@Override
	public Product getProductById(String id) {
		Query searchProductQuery = new Query(Criteria.where("_id").is(id));
		return mongoTemplate.findOne(searchProductQuery, Product.class,
				COLLECTION_NAME);
	}

	@Override
	public void deleteProduct(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> getProducts() {
		// get all docuemnt
		return mongoTemplate.findAll(Product.class, COLLECTION_NAME);
	}

	@Override
	public List<Product> getProductsByTypeId(String id) {
		// TODO Auto-generated method stub
		Query searchProductQueryByType = new Query(Criteria.where(
				"productTypeId").is(id));
		return mongoTemplate.find(searchProductQueryByType, Product.class,
				COLLECTION_NAME);
	}

	@Override
	public List<Product> getProductsByManufacturerId(String id) {
		// TODO Auto-generated method stub
		Query searchProductQueryByManufacturer = new Query(Criteria.where(
				"manufacturerId").is(id));
		return mongoTemplate.find(searchProductQueryByManufacturer,
				Product.class, COLLECTION_NAME);
	}


}
