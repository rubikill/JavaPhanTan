package co.hcmus.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PromotionDetail {

	@Id
	private String id; // promotion detail id
	private String promotionId; // promotion id
	private String productId; // product ID
	private String status; // status

	public PromotionDetail(String id, String promotionId, String productId,
			String status) {
		super();
		this.id = id;
		this.promotionId = promotionId;
		this.productId = productId;
		this.status = status;

	}

	public PromotionDetail() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
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
