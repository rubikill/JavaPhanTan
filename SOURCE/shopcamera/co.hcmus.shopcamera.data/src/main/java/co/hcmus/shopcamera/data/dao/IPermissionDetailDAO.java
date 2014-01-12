package co.hcmus.shopcamera.data.dao;

import java.util.List;

import co.hcmus.shopcamera.data.model.PermissionDetail;

/**
 * 
 * @author Thanh Toan
 * 
 */
public interface IPermissionDetailDAO {
	/**
	 * 
	 * @param permissiondetail
	 */
	public void addPermissionDetail(PermissionDetail permissiondetail);

	/**
	 * 
	 * @param permissiondetail
	 */
	public void updatePermissionDetail(PermissionDetail permissiondetail);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public PermissionDetail getPermissionDetail(String id);

	/**
	 * 
	 * @param id
	 */
	public void deletePermissionDetail(String id);

	/**
	 * 
	 * @return
	 */
	public List<PermissionDetail> getPermissionDetails();

	/**
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	public List<PermissionDetail> getPermissionDetailByPermissionId(String id,
			String status);

	/**
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	public List<PermissionDetail> getPermissionDetailByAccountTypeId(String id,
			String status);

}
