package co.hcmus.shopcamera.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Permission details
 * 
 * @author Thanh Toan
 * 
 */
@Document
public class PermissionDetail {
	@Id
	private String id;
	private String accountTypeId;
	private String permissionId;
	private String status;

	/**
	 * 
	 */
	public PermissionDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param accountTypeId
	 * @param permissionId
	 * @param status
	 */
	public PermissionDetail(String id, String accountTypeId,
			String permissionId, String status) {
		super();
		this.id = id;
		this.accountTypeId = accountTypeId;
		this.permissionId = permissionId;
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
	 * @return the accountTypeId
	 */
	public String getAccountTypeId() {
		return accountTypeId;
	}

	/**
	 * @param accountTypeId
	 *            the accountTypeId to set
	 */
	public void setAccountTypeId(String accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	/**
	 * @return the permissionId
	 */
	public String getPermissionId() {
		return permissionId;
	}

	/**
	 * @param permissionId
	 *            the permissionId to set
	 */
	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
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