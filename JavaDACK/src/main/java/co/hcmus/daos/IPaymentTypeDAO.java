package co.hcmus.daos;

import java.util.List;
import co.hcmus.models.PaymentType;

public interface IPaymentTypeDAO {
	public void addPaymentType(PaymentType paymentType);
	public void updatePaymentType(PaymentType paymentType);
	public PaymentType getPaymentTypeById(String id);
	public void deletePaymentType(String id);
	public List<PaymentType> getPaymentTypes();
}
