package co.hcmus.models;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Also known as billing
 * 
 * @author Thanh Toan
 * 
 */
@Document
public class History {
	@Id
	private String id; // Id
	private String email; // Account's email - History owner
	private int quantity; // Number of products
	private String status; // Status (Active/Inactive)
	private String paymentStatus; // Payment status (Paid/Unpaid)
	private Date orderDate; // Order date
	private Date deliveryDate; // Delivery date
	private Date paymentDate; // Payment date
	private String paymentTypeId; // Id of PaymentType, which referenced to
									// collection PaymentType
									// private String historyDetailId;
									// DetailHistory's Id, referenced to
									// collection HistoryDetail where
									// listed all products in this bill.

	private PaymentType paymentType;

	public History() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param email
	 * @param quantity
	 * @param status
	 * @param paymentStatus
	 * @param orderDate
	 * @param deliveryDate
	 * @param paymentDate
	 * @param paymentTyeId
	 */
	public History(String email, int quantity, String status,
			String paymentStatus, Date orderDate, Date deliveryDate,
			Date paymentDate, String paymentTypeId) {
		super();
		this.email = email;
		this.quantity = quantity;
		this.status = status;
		this.paymentStatus = paymentStatus;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.paymentDate = paymentDate;
		this.paymentTypeId = paymentTypeId;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the paymentStatus
	 */
	public String getPaymentStatus() {
		return paymentStatus;
	}

	/**
	 * @param paymentStatus
	 *            the paymentStatus to set
	 */
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate
	 *            the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the deliveryDate
	 */
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	/**
	 * @param deliveryDate
	 *            the deliveryDate to set
	 */
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/**
	 * @return the paymentDate
	 */
	public Date getPaymentDate() {
		return paymentDate;
	}

	/**
	 * @param paymentDate
	 *            the paymentDate to set
	 */
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	/**
	 * @return the paymentTyeId
	 */
	public String getPaymentTypeId() {
		return paymentTypeId;
	}

	/**
	 * @param paymentTyeId
	 *            the paymentTyeId to set
	 */
	public void setPaymentTypeId(String paymentTyeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

}
