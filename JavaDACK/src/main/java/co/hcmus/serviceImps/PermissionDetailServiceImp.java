package co.hcmus.serviceImps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.PermissionDetailDAO;
import co.hcmus.models.PermissionDetail;
import co.hcmus.services.PermissionDetailService;

@Service("permissionDetailService")
@Transactional
public class PermissionDetailServiceImp implements PermissionDetailService {

	@Autowired
	private PermissionDetailDAO permissionDetailDAO;

	@Override
	public void addPermissionDetail(PermissionDetail permissiondetail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePermissionDetail(PermissionDetail permissiondetail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PermissionDetail getPermissionDetail(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePermissionDetail(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PermissionDetail> getPermissionDetails() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
