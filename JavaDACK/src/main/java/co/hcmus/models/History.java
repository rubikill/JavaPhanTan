package co.hcmus.models;

import java.util.Date;

public class History {
	private String id;
	private String email;
	private int quantity;
	private int status;
	private Date orderDate;
	private Date deliveryDate;
	private Date paymentDate;
	private String paymentTyeId;
	private String historyDetailId;
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
