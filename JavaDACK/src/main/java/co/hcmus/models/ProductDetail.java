package co.hcmus.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ProductDetail {
	@Id
	private String id;			 	// id of product detail
	private String productId; 		// product id of detail
	private int warranty; 			// bao hanh, month ,12 month, 24 month
	private double height;		
	private double weight;

	public ProductDetail(String id, String productId, int warranty,
			double height, double weight) {
		super();
		this.id = id;
		this.productId = productId;
		this.warranty = warranty;
		this.height = height;
		this.weight = weight;
	}

	public ProductDetail() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
