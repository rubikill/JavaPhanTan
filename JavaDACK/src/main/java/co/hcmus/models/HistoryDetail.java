package co.hcmus.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class HistoryDetail {

	@Id
	private String id;			// id of history detail
	private String historyId;	// history id 
	private int amount;			// amount 
	private String productId;	//id of product
	private String status;		//status
	public HistoryDetail(String historyId, int amount,
			String productId, String status) {
		super();
		this.historyId = historyId;
		this.amount = amount;
		this.productId = productId;
		this.status = status;
	}

	public HistoryDetail()
	{
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHistoryId() {
		return historyId;
	}

	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
