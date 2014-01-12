package co.hcmus.shopcamera.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.shopcamera.data.dao.IPermissionDetailDAO;
import co.hcmus.shopcamera.data.model.PermissionDetail;
import co.hcmus.shopcamera.manager.IPermissionDetailService;

@Service("permissionDetailService")
@Transactional
public class PermissionDetailServiceMongo implements IPermissionDetailService {
	
	private static final Logger logger = LoggerFactory
			.getLogger(PermissionDetailServiceMongo.class);

	@Autowired
	private IPermissionDetailDAO PermissionDetailDAO;

	@Override
	public void addPermissionDetail(PermissionDetail permissionDetail) {
		logger.info("PermissionDetailServiceMongo add permissionDetail");
		PermissionDetailDAO.addPermissionDetail(permissionDetail);
	}

	public void updatePermissionDetail(PermissionDetail permissionDetail) {
		logger.info("PermissionDetailServiceMongo update permissionDetail with Id :" + permissionDetail.getId());
		PermissionDetailDAO.updatePermissionDetail(permissionDetail);
	}

	public List<PermissionDetail> getPermissionDetails() {
		logger.info("PermissionDetailServiceMongo get all permissionDetail");
		return PermissionDetailDAO.getPermissionDetails();
	}

	@Override
	public PermissionDetail getPermissionDetail(String id) {
		logger.info("PermissionDetailServiceMongo get permissionDetail with Id : " + id);
		return PermissionDetailDAO.getPermissionDetail(id);
	}

	@Override
	public void deletePermissionDetail(String id) {
		logger.info("PermissionDetailServiceMongo delete permissionDetail with Id : " + id);
		PermissionDetailDAO.deletePermissionDetail(id);
	}

	@Override
	public List<PermissionDetail> getPermissionDetailByPermissionId(String id,
			String status) {
		// TODO Auto-generated method stub
		logger.info("PermissionDetailServiceMongo get permissionDetail by PermissionId :" + id);
		return PermissionDetailDAO.getPermissionDetailByPermissionId(id, status);
	}

	@Override
	public List<PermissionDetail> getPermissionDetailByAccountTypeId(String id,
			String status) {
		// TODO Auto-generated method stub
		logger.info("PermissionDetailServiceMongo get permissionDetail by AccountTypeId : " + id);
		return PermissionDetailDAO.getPermissionDetailByAccountTypeId(id, status);
	}
	
	
}
