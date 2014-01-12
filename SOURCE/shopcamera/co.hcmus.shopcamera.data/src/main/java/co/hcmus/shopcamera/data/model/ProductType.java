package co.hcmus.shopcamera.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Product type
 * 
 * @author Thanh Toan
 * 
 */
@Document
public class ProductType {

	@Id
	private String id; // Id
	private String name; // ProductType's name
	private String status;

	/**
	 * 
	 */
	public ProductType() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param status
	 */
	public ProductType(String name, String status) {
		super();
		this.name = name;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
