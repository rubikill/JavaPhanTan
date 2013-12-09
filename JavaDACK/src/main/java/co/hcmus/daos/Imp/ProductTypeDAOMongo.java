package co.hcmus.daos.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import co.hcmus.daos.IProductTypeDAO;
import co.hcmus.models.ProductType;

@Repository("productTypeDAO")
public class ProductTypeDAOMongo implements IProductTypeDAO {

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
		mongoTemplate.insert(productType, COLLECTION_NAME);

	}

	// Update ProductType
	@Override
	public void updateProductType(ProductType productType) {
		mongoTemplate.save(productType, COLLECTION_NAME);

	}

	// Get a specific ProductType by id
	@Override
	public ProductType getProductType(String id) {
		Query searchProductTypeQuery = new Query(Criteria.where("id").is(id));
		return mongoTemplate.findOne(searchProductTypeQuery, ProductType.class,
				COLLECTION_NAME);
	}

	// Delete a ProductType
	@Override
	public void deleteProductType(String id) {
		ProductType producttype = getProductType(id);
		mongoTemplate.remove(producttype, COLLECTION_NAME);

	}

	// Get all ProductTypes
	@Override
	public List<ProductType> getProductTypes() {
		return mongoTemplate.findAll(ProductType.class, COLLECTION_NAME);
	}

}
