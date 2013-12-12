package co.hcmus.services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IPermissionDAO;
import co.hcmus.models.Permission;
import co.hcmus.services.IPermissionService;

@Service("permissionService")
@Transactional
public class PermissionServiceMongo implements IPermissionService {

	@Autowired
	private IPermissionDAO permissionDAO;

	@Override
	public void addPermission(Permission permission) {
		permissionDAO.addPermission(permission);
	}

	public void updatePermission(Permission permission) {
		permissionDAO.updatePermission(permission);
	}

	public List<Permission> getPermissions() {
		return permissionDAO.getPermissions();
	}

	@Override
	public Permission getPermission(String id) {
		return permissionDAO.getPermission(id);
	}

	@Override
	public void deletePermission(String email) {
		permissionDAO.deletePermission(email);
	}

}
