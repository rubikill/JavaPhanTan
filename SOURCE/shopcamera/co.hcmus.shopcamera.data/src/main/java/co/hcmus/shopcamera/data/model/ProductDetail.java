package co.hcmus.shopcamera.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Product details
 * 
 * @author Thanh Toan
 * 
 */
@Document
public class ProductDetail {
	@Id
	private String id; // id of product detail
	private String productId; // product id of detail
	private int warranty; // bao hanh, month ,12 month, 24 month
	private double height;
	private double weight;
	private String status; // status

	/**
	 * 
	 */
	public ProductDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param productId
	 * @param warranty
	 * @param height
	 * @param weight
	 * @param status
	 */
	public ProductDetail(String productId, int warranty, double height,
			double weight, String status) {
		super();
		this.productId = productId;
		this.warranty = warranty;
		this.height = height;
		this.weight = weight;
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
	 * @return the warranty
	 */
	public int getWarranty() {
		return warranty;
	}

	/**
	 * @param warranty
	 *            the warranty to set
	 */
	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
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
