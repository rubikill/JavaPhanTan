package co.hcmus.services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IPermissionDetailDAO;
import co.hcmus.models.PermissionDetail;
import co.hcmus.services.IPermissionDetailService;

@Service("permissionDetailService")
@Transactional
public class PermissionDetailServiceMongo implements IPermissionDetailService {

	@Autowired
	private IPermissionDetailDAO permissionDetailDAO;

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
