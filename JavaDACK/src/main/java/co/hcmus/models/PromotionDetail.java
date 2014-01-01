package co.hcmus.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author WindyZBoy
 *
 */
@Document
public class PromotionDetail {

	@Id
	private String id; // promotion detail id
	private String promotionId; // promotion id
	private String productId; // product ID
	private String status; // status
	private int discount; // discount
	
	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * 
	 */
	public PromotionDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param promotionId
	 * @param productId
	 * @param status
	 * @param discount
	 */
	public PromotionDetail(String promotionId, String productId, String status,
			int discount) {
		super();
		this.promotionId = promotionId;
		this.productId = productId;
		this.status = status;
		this.discount = discount;
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
	 * @return the promotionId
	 */
	public String getPromotionId() {
		return promotionId;
	}

	/**
	 * @param promotionId
	 *            the promotionId to set
	 */
	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
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

	/**
	 * @return the discount
	 */
	public int getDiscount() {
		return discount;
	}

	/**
	 * @param discount
	 *            the discount to set
	 */
	public void setDiscount(int discount) {
		this.discount = discount;
	}
}
