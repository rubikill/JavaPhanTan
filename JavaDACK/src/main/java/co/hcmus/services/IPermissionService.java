package co.hcmus.services;
import java.util.List;

import co.hcmus.models.Permission;

/**
 * 
 * @author Thanh Toan
 *
 */
public interface IPermissionService {
	/**
	 * 
	 * @param permission
	 */
	public void addPermission(Permission permission);

	/**
	 * 
	 * @param permission
	 */
	public void updatePermission(Permission permission);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Permission getPermission(String id);

	/**
	 * 
	 * @param id
	 */
	public void deletePermission(String id);

	/**
	 * 
	 * @return
	 */
	public List<Permission> getPermissions();

}
