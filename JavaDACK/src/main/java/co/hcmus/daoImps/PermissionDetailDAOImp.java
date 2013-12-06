package co.hcmus.daoImps;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.hcmus.daos.PermissionDetailDAO;
import co.hcmus.models.PermissionDetail;

@Repository("permissionDetailDAO")
public class PermissionDetailDAOImp implements PermissionDetailDAO {
	@Autowired
	SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addPermissionDetail(PermissionDetail permissionDetail) {
		getCurrentSession().saveOrUpdate(permissionDetail);
	}

	public void updatePermissionDetail(PermissionDetail permissionDetail) {
		getCurrentSession().update(permissionDetail);
	}

	public PermissionDetail getPermissionDetail(int id) {
		PermissionDetail permissionDetail = new PermissionDetail();
		permissionDetail = (PermissionDetail) getCurrentSession().get(PermissionDetail.class, id);
		return permissionDetail;
	}

	public void deletePermissionDetail(int id) {
		PermissionDetail permissionDetail = getPermissionDetail(id);
		if (permissionDetail != null) {
			getCurrentSession().delete(permissionDetail);
		}
	}

	@SuppressWarnings("unchecked")
	public List<PermissionDetail> getPermissionDetails() {
		return getCurrentSession().createQuery("from PermissionDetail").list();
	}

	@Override
	public PermissionDetail getPermissionDetail(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePermissionDetail(String id) {
		// TODO Auto-generated method stub
		
	}

}
