package co.hcmus.services;

import java.util.List;

import co.hcmus.models.PermissionDetail;

public interface PermissionDetailService {
	public void addPermissionDetail(PermissionDetail permissiondetail);

	public void updatePermissionDetail(PermissionDetail permissiondetail);

	public PermissionDetail getPermissionDetail(int id);

	public void deletePermissionDetail(int id);

	public List<PermissionDetail> getPermissionDetails();

}
