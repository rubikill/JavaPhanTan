package co.hcmus.shopcamera.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.shopcamera.data.dao.IPaymentTypeDAO;
import co.hcmus.shopcamera.data.model.PaymentType;
import co.hcmus.shopcamera.manager.IPaymentTypeService;


@Service("paymentTypeService")
@Transactional
public class PaymentTypeServiceMongo implements IPaymentTypeService {

	
	private static final Logger logger = LoggerFactory
			.getLogger(PaymentTypeServiceMongo.class);
	
	@Autowired
	private IPaymentTypeDAO paymentTypeDAO;
	
	@Override
	public void addPaymentType(PaymentType paymentType) {
		logger.info("PaymentTypeServiceMongo add paymentType");
		paymentTypeDAO.addPaymentType(paymentType);
	}

	@Override
	public void updatePaymentType(PaymentType paymentType) {
		logger.info("PaymentTypeServiceMongo update paymentType with Id  :" + paymentType.getId());
		paymentTypeDAO.updatePaymentType(paymentType);
	}

	@Override
	public PaymentType getPaymentTypeById(String id) {
		logger.info("PaymentTypeServiceMongo get paymentType by Id :" + id);
		return paymentTypeDAO.getPaymentTypeById(id);
	}

	@Override
	public void deletePaymentType(String id) {
		logger.info("PaymentTypeServiceMongo delete paymentType with Id :" + id);
		paymentTypeDAO.deletePaymentType(id);
		
	}

	@Override
	public List<PaymentType> getPaymentTypes() {
		logger.info("PaymentTypeServiceMongo get all paymentType");
		return paymentTypeDAO.getPaymentTypes();
	}

}
