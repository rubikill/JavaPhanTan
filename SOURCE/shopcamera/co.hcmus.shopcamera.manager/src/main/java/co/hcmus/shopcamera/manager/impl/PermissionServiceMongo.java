package co.hcmus.shopcamera.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.shopcamera.data.dao.IPermissionDAO;
import co.hcmus.shopcamera.data.model.Permission;
import co.hcmus.shopcamera.data.model.PermissionDetail;
import co.hcmus.shopcamera.manager.IPermissionDetailService;
import co.hcmus.shopcamera.manager.IPermissionService;
import co.hcmus.shopcamera.utility.STATUS;

@Service("permissionService")
@Transactional
public class PermissionServiceMongo implements IPermissionService {

	private static final Logger logger = LoggerFactory
			.getLogger(PermissionServiceMongo.class);
	
	@Autowired
	private IPermissionDAO permissionDAO;

	@Autowired
	private IPermissionDetailService permissionDetailService;

	@Override
	public void addPermission(Permission permission) {
		logger.info("PermissionServiceMongo add permission");
		permissionDAO.addPermission(permission);
	}

	public void updatePermission(Permission permission) {
		logger.info("PermissionServiceMongo update permission with Id : " + permission.getId());
		permissionDAO.updatePermission(permission);
	}

	public List<Permission> getPermissions() {
		logger.info("PermissionServiceMongo get all permissions");
		return permissionDAO.getPermissions();
	}

	@Override
	public Permission getPermission(String id) {
		logger.info("PermissionServiceMongo get permission with Id : " + id);
		return permissionDAO.getPermission(id);
	}

	@Override
	public void deletePermission(String id) {
		List<PermissionDetail> listPermissionDetail = permissionDetailService
				.getPermissionDetailByPermissionId(id,
						STATUS.ACTIVE.getStatusCode());
		for(PermissionDetail permissionDetail : listPermissionDetail)
			permissionDetailService.deletePermissionDetail(permissionDetail.getId());
		logger.info("PermissionServiceMongo delete permission with Id : " + id);
		permissionDAO.deletePermission(id);
	}

}
