package co.hcmus.models;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class History { // Also known as billing
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
									// private String historyDetailId; //
									// DetailHistory's Id, referenced to
									// collection HistoryDetail where
									// listed all products in this bill.

	private PaymentType paymentType;

	public History() {

	}

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(String paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

}
