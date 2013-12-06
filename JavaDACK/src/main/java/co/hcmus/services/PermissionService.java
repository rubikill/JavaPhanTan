package co.hcmus.services;
import java.util.List;

import co.hcmus.models.Permission;

public interface PermissionService {
	public void addPermission(Permission permission);

	public void updatePermission(Permission permission);

	public Permission getPermission(int id);

	public void deletePermission(int id);

	public List<Permission> getPermissions();

}
