package co.hcmus.daos;

import java.util.List;

import co.hcmus.models.PermissionDetail;

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
