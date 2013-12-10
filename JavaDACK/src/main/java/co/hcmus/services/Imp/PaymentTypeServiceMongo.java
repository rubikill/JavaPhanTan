package co.hcmus.services.Imp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IPaymentTypeDAO;
import co.hcmus.models.PaymentType;
import co.hcmus.services.IPaymentTypeService;


@Service("paymentTypeService")
@Transactional
public class PaymentTypeServiceMongo implements IPaymentTypeService {

	private IPaymentTypeDAO paymentTypeDAO;
	
	@Override
	public void addPaymentType(PaymentType paymentType) {
		// TODO Auto-generated method stub
		paymentTypeDAO.addPaymentType(paymentType);
	}

	@Override
	public void updatePaymentType(PaymentType paymentType) {
		// TODO Auto-generated method stub
		paymentTypeDAO.updatePaymentType(paymentType);
	}

	@Override
	public PaymentType getPaymentTypeById(String id) {
		// TODO Auto-generated method stub
		return paymentTypeDAO.getPaymentTypeById(id);
	}

	@Override
	public void deletePaymentType(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PaymentType> getPaymentTypes() {
		// TODO Auto-generated method stub
		return paymentTypeDAO.getPaymentTypes();
	}

}
