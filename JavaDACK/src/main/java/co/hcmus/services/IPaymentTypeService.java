package co.hcmus.services;

import java.util.List;

import co.hcmus.models.PaymentType;

public interface IPaymentTypeService {
	public void addPaymentType(PaymentType paymentType);

	public void updatePaymentType(PaymentType paymentType);

	public PaymentType getPaymentTypeById(String id);

	public void deletePaymentType(String id);

	public List<PaymentType> getPaymentTypes();
}
