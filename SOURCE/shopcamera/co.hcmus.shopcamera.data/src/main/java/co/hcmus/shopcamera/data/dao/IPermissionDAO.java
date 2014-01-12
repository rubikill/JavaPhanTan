package co.hcmus.shopcamera.data.dao;

import java.util.List;

import co.hcmus.shopcamera.data.model.Permission;

/**
 * 
 * @author Thanh Toan
 * 
 */
public interface IPermissionDAO {
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
