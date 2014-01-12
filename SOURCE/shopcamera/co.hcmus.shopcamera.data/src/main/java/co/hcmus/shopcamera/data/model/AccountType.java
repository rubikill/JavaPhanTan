package co.hcmus.shopcamera.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This model contain Account type (Normal, vip, admin)
 * 
 * @author Thanh Toan
 * 
 */
@Document
public class AccountType {

	@Id
	private String id; // Id
	private String name; // Name of AccountType (Normal, VIP, Admin)
	private String status; //

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

	
	/**
	 * 
	 */
	public AccountType() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param status
	 */
	public AccountType(String id, String name, String status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}
}
