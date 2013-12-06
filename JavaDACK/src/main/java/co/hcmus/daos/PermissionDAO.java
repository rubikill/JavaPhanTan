package co.hcmus.daos;

import java.util.List;

import co.hcmus.models.Permission;

public interface PermissionDAO {
	public void addPermission(Permission permission);
	public void updatePermission(Permission permission);
	public Permission getPermission(String id);
	public void deletePermission(String id);
	public List<Permission> getPermissions();
	
}
