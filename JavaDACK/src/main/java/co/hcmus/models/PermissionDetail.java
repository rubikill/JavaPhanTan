package co.hcmus.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PermissionDetail {
	@Id
	private String id;
	private String accountTypeId;
	private String permissionId;
	private String status;

	public PermissionDetail(String id, String accountTypeId, String permissionId,String status) {
		super();
		this.id = id;
		this.accountTypeId = accountTypeId;
		this.permissionId = permissionId;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(String accounttypeid) {
		this.accountTypeId = accounttypeid;
	}

	public String getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}