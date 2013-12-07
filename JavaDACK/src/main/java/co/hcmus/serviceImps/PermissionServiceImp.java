package co.hcmus.serviceImps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.PermissionDAO;
import co.hcmus.models.Permission;
import co.hcmus.services.PermissionService;

@Service("permissionService")
@Transactional
public class PermissionServiceImp implements PermissionService {

	@Autowired
	private PermissionDAO permissionDAO;

	@Override
	public void addPermission(Permission permission) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePermission(Permission permission) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Permission getPermission(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePermission(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Permission> getPermissions() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
