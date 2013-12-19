package co.hcmus.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This model contain comment info
 * 
 * @author Thanh Toan
 * 
 */
@Document
public class Comment {

	@Id
	private String id; 				// Id
	private String email; 			// Commenter's email
	private String productId; 		// Id of product which is commented
	private String idCommentRoot; 	// If of root (parent) comment, if this
									// comment reply a comment , if it = -1 , it
									// root comment
	private String content; 		// Comment's content
	private String status;

	/**
	 * 
	 */
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param email
	 * @param productId
	 * @param idCommentRoot
	 * @param content
	 * @param status
	 */
	public Comment(String id, String email, String productId,
			String idCommentRoot, String content, String status) {
		super();
		this.id = id;
		this.email = email;
		this.productId = productId;
		this.idCommentRoot = idCommentRoot;
		this.content = content;
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
	 * @return the idCommentRoot
	 */
	public String getIdCommentRoot() {
		return idCommentRoot;
	}

	/**
	 * @param idCommentRoot
	 *            the idCommentRoot to set
	 */
	public void setIdCommentRoot(String idCommentRoot) {
		this.idCommentRoot = idCommentRoot;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
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
