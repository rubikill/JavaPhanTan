package co.hcmus.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Permission {
	@Id
	private String id;
	private String accountTypeId;
	private String permissionId;

	public Permission(String id, String accountTypeId, String permissionId) {
		super();
		this.id = id;
		this.accountTypeId = accountTypeId;
		this.permissionId = permissionId;
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
}
