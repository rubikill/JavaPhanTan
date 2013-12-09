package co.hcmus.models;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class History {					// Also known as billing
	@Id
	private String id;					// Id
	private String email;				// Account's email - History owner
	private int quantity;				// Number of products 
	private int status;					// Status (Paid/Unpaid)
	private Date orderDate;				// Order date
	private Date deliveryDate;			// Delivery date
	private Date paymentDate;			// Payment date
	private String paymentTyeId;		// Id of PaymentType, which referenced to collection PaymentType
	private String historyDetailId;		// DetailHistory's Id, referenced to collection HistoryDetail where
										// listed all products in this bill.

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public String getPaymentTyeId() {
		return paymentTyeId;
	}

	public void setPaymentTyeId(String paymentTyeId) {
		this.paymentTyeId = paymentTyeId;
	}

	public String getHistoryDetailId() {
		return historyDetailId;
	}

	public void setHistoryDetailId(String historyDetailId) {
		this.historyDetailId = historyDetailId;
	}

}
