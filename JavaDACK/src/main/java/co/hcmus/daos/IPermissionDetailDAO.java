package co.hcmus.daos;

import java.util.List;

import co.hcmus.models.PermissionDetail;

public interface IPermissionDetailDAO {
	public void addPermissionDetail(PermissionDetail permissiondetail);

	public void updatePermissionDetail(PermissionDetail permissiondetail);

	public PermissionDetail getPermissionDetail(String id);

	public void deletePermissionDetail(String id);

	public List<PermissionDetail> getPermissionDetails();
	
	public List<PermissionDetail> getPermissionDetailByPermissionId(String id, String status);
	
	public List<PermissionDetail> getPermissionDetailByAccountTypeId(String id, String status);

}
