package co.hcmus.services;

import java.util.List;

import co.hcmus.models.PermissionDetail;

public interface IPermissionDetailService {
	public void addPermissionDetail(PermissionDetail permissiondetail);

	public void updatePermissionDetail(PermissionDetail permissiondetail);

	public PermissionDetail getPermissionDetail(String id);

	public void deletePermissionDetail(String id);

	public List<PermissionDetail> getPermissionDetails();

}
