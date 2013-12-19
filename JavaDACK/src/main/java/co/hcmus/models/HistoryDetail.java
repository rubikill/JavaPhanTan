package co.hcmus.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Detail of history
 * 
 * @author Thanh Toan
 * 
 */
@Document
public class HistoryDetail {

	@Id
	private String id; // id of history detail
	private String historyId; // history id
	private int amount; // amount
	private String productId; // id of product
	private String status; // status

	/**
	 * 
	 */
	public HistoryDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param historyId
	 * @param amount
	 * @param productId
	 * @param status
	 */
	public HistoryDetail(String historyId, int amount, String productId,
			String status) {
		super();
		this.historyId = historyId;
		this.amount = amount;
		this.productId = productId;
		this.status = status;
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
	 * @return the historyId
	 */
	public String getHistoryId() {
		return historyId;
	}

	/**
	 * @param historyId
	 *            the historyId to set
	 */
	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
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

}
