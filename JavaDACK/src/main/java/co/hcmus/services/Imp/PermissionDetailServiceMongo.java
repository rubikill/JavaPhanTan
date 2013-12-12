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
	private IPermissionDetailDAO PermissionDetailDAO;

	@Override
	public void addPermissionDetail(PermissionDetail permissionDetail) {
		PermissionDetailDAO.addPermissionDetail(permissionDetail);
	}

	public void updatePermissionDetail(PermissionDetail permissionDetail) {
		PermissionDetailDAO.updatePermissionDetail(permissionDetail);
	}

	public List<PermissionDetail> getPermissionDetails() {
		return PermissionDetailDAO.getPermissionDetails();
	}

	@Override
	public PermissionDetail getPermissionDetail(String id) {
		return PermissionDetailDAO.getPermissionDetail(id);
	}

	@Override
	public void deletePermissionDetail(String email) {
		PermissionDetailDAO.deletePermissionDetail(email);
	}
	
	
}