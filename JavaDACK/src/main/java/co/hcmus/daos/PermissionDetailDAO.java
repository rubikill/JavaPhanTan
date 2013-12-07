package co.hcmus.daos;

import java.util.List;

import co.hcmus.models.PermissionDetail;

public interface PermissionDetailDAO {
	public void addPermissionDetail(PermissionDetail permissiondetail);
	public void updatePermissionDetail(PermissionDetail permissiondetail);
	public PermissionDetail getPermissionDetail(String id);
	public void deletePermissionDetail(String id);
	public List<PermissionDetail> getPermissionDetails();
	
}
