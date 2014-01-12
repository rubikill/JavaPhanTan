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

import co.hcmus.shopcamera.data.dao.IPaymentTypeDAO;
import co.hcmus.shopcamera.data.model.PaymentType;
import co.hcmus.shopcamera.utility.STATUS;

@Repository("paymentTypeDAO")
@Transactional
public class PaymentTypeDAOMongo implements IPaymentTypeDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(PaymentTypeDAOMongo.class);
	
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
		logger.info("PaymentTypeDAOMongo add paymenttype");
		mongoTemplate.insert(paymentType, COLLECTION_NAME);

	}

	@Override
	public void updatePaymentType(PaymentType paymentType) {
		// update a document
		logger.info("PaymentTypeDAOMongo update paymenttype with Id : " + paymentType.getId());
		mongoTemplate.save(paymentType, COLLECTION_NAME);

	}

	@Override
	public PaymentType getPaymentTypeById(String id) {
		Query searchPaymentType = new Query(Criteria.where("_id").is(id));
		logger.info("PaymentTypeDAOMongo get paymenttype with Id : " +  id);
		return mongoTemplate.findOne(searchPaymentType, PaymentType.class,
				COLLECTION_NAME);
	}

	@Override
	public void deletePaymentType(String id) {
		PaymentType paymentType = getPaymentTypeById(id);
		paymentType.setStatus(STATUS.INACTIVE.getStatusCode());
		logger.info("PaymentTypeDAOMongo delete paymenttype with Id : " +  id);
		mongoTemplate.save(paymentType, COLLECTION_NAME);
	}

	@Override
	public List<PaymentType> getPaymentTypes() {
		// get all docuemnt
		List<PaymentType> getPaymentTypes = mongoTemplate.findAll(
				PaymentType.class, COLLECTION_NAME);
		logger.info("PaymmentTypeDAOMongo get all PaymentTypes");
		if (getPaymentTypes == null) {
			logger.error("Error PaymentTypeDAOMongo get all PaymentTypes");
			System.out.println("Payment null");
		}
		return getPaymentTypes;
	}

}
