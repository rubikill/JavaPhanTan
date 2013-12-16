package co.hcmus.daos.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IProductStateDAO;
import co.hcmus.models.ProductState;
import co.hcmus.util.STATUS;

@Repository("productStateDAO")
@Transactional
public class ProductStateDAOMongo implements IProductStateDAO {

	@Autowired
	private MongoTemplate mongoTemplate;
	// Collection name save in MongoDB
	public static final String COLLECTION_NAME = "productState";

	@Override
	public void addProductState(ProductState productState) {
		mongoTemplate.insert(productState);

	}

	@Override
	public void updateProductState(ProductState productState) {
		mongoTemplate.save(productState, COLLECTION_NAME);

	}

	@Override
	public ProductState getProductStateById(String id, String status) {
		Query searchProductStateQuery = new Query(Criteria.where("_id").is(id)
				.and("status").is(status));
		return mongoTemplate.findOne(searchProductStateQuery,
				ProductState.class, COLLECTION_NAME);
	}

	@Override
	public void deleteProductState(String id) {
		// TODO Auto-generated method stub
		ProductState productState = getProductStateById(id, STATUS.ACTIVE.getStatusCode());
		productState.setStatus(STATUS.INACTIVE.getStatusCode());
		mongoTemplate.save(productState, COLLECTION_NAME);
	}

	@Override
	public List<ProductState> getProductStates() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(ProductState.class, COLLECTION_NAME);
	}

	@Override
	public ProductState getProductStateByName(String name, String status) {
		// TODO Auto-generated method stub
		Query searchProductStateQueryByname = new Query(Criteria.where("name").is(name)
				.and("status").is(status));
		return mongoTemplate.findOne(searchProductStateQueryByname,
				ProductState.class, COLLECTION_NAME);
	}
}
