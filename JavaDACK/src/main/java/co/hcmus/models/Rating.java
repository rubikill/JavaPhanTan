package co.hcmus.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Rating
 * @author Thanh Toan
 *
 */
@Document
public class Rating {

	@Id
	private String id; // id of rating
	private String productId; // id of product to rating
	private String email; // email(_id) of account to rating
	private int star; // rate 1 2 3 4 5
	private String status;

	/**
	 * @param productId
	 * @param email
	 * @param star
	 * @param status
	 */
	public Rating(String productId, String email, int star, String status) {
		super();
		this.productId = productId;
		this.email = email;
		this.star = star;
		this.status = status;
	}

	/**
	 * 
	 */
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the star
	 */
	public int getStar() {
		return star;
	}

	/**
	 * @param star
	 *            the star to set
	 */
	public void setStar(int star) {
		this.star = star;
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
