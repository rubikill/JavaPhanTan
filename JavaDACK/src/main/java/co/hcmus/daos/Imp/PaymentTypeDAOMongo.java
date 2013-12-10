package co.hcmus.daos.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import co.hcmus.daos.IPaymentTypeDAO;
import co.hcmus.models.PaymentType;

@Repository("paymentTypeDAO")
public class PaymentTypeDAOMongo implements IPaymentTypeDAO {

	@Autowired
	private MongoTemplate mongoTemplate;
	// Collection name save in MongoDB
	public static final String COLLECTION_NAME = "paymentType";

	@Override
	public void addPaymentType(PaymentType paymentType) {
		if (!mongoTemplate.collectionExists(PaymentType.class)) {
			mongoTemplate.createCollection(PaymentType.class);
		}
		// insert a document
		mongoTemplate.insert(paymentType, COLLECTION_NAME);

	}

	@Override
	public void updatePaymentType(PaymentType paymentType) {
		// update a document
		mongoTemplate.save(paymentType, COLLECTION_NAME);

	}

	@Override
	public PaymentType getPaymentTypeById(String id) {
		Query searchPaymentType = new Query(Criteria.where("_id").is(id));
		return mongoTemplate.findOne(searchPaymentType, PaymentType.class,
				COLLECTION_NAME);
	}

	@Override
	public void deletePaymentType(String id) {

	}

	@Override
	public List<PaymentType> getPaymentTypes() {
		// get all docuemnt
		return mongoTemplate.findAll(PaymentType.class, COLLECTION_NAME);
	}

}
