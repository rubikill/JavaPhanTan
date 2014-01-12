package co.hcmus.shopcamera.data.dao;

import java.util.List;

import co.hcmus.shopcamera.data.model.PaymentType;

/**
 * Interface of Payment type DAO
 * @author Thanh Toan
 * 
 */
public interface IPaymentTypeDAO {
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
