package co.hcmus.services;

import java.util.List;

import co.hcmus.models.PaymentType;

/**
 * 
 * @author Thanh Toan
 *
 */
public interface IPaymentTypeService {
	/**
	 * 
	 * @param paymentType
	 */
	public void addPaymentType(PaymentType paymentType);

	/**
	 * 
	 * @param paymentType
	 */
	public void updatePaymentType(PaymentType paymentType);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public PaymentType getPaymentTypeById(String id);

	/**
	 * 
	 * @param id
	 */
	public void deletePaymentType(String id);

	/**
	 * 
	 * @return
	 */
	public List<PaymentType> getPaymentTypes();
}
