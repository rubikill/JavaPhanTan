package co.hcmus.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Rating {

	@Id
	private String id; // id of rating
	private String productId; // id of product to rating
	private String email; // email(_id) of account to rating
	private int star; // rate 1 2 3 4 5
	private String status;

	public Rating(String id, String productId, String email, int star,
			String status) {
		super();
		this.id = id;
		this.productId = productId;
		this.email = email;
		this.star = star;
		this.status = status;
	}

	public Rating() {

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
