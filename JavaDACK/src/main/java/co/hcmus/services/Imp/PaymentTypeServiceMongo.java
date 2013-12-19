package co.hcmus.services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IPaymentTypeDAO;
import co.hcmus.models.PaymentType;
import co.hcmus.services.IPaymentTypeService;


@Service("paymentTypeService")
@Transactional
public class PaymentTypeServiceMongo implements IPaymentTypeService {

	@Autowired
	private IPaymentTypeDAO paymentTypeDAO;
	
	@Override
	public void addPaymentType(PaymentType paymentType) {
		paymentTypeDAO.addPaymentType(paymentType);
	}

	@Override
	public void updatePaymentType(PaymentType paymentType) {
		paymentTypeDAO.updatePaymentType(paymentType);
	}

	@Override
	public PaymentType getPaymentTypeById(String id) {
		return paymentTypeDAO.getPaymentTypeById(id);
	}

	@Override
	public void deletePaymentType(String id) {
		paymentTypeDAO.deletePaymentType(id);
		
	}

	@Override
	public List<PaymentType> getPaymentTypes() {
		return paymentTypeDAO.getPaymentTypes();
	}

}
