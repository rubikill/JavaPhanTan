package co.hcmus.daoImps;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.hcmus.daos.PermissionDAO;
import co.hcmus.models.Permission;

@Repository("permissionDAO")
public class PermissionDAOImp implements PermissionDAO {
	@Autowired
	SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addPermission(Permission permission) {
		getCurrentSession().saveOrUpdate(permission);
	}

	public void updatePermission(Permission permission) {
		getCurrentSession().update(permission);
	}

	public Permission getPermission(int id) {
		Permission permission = new Permission();
		permission = (Permission) getCurrentSession().get(Permission.class, id);
		return permission;
	}

	public void deletePermission(int id) {
		Permission permission = getPermission(id);
		if (permission != null) {
			getCurrentSession().delete(permission);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Permission> getPermissions() {
		return getCurrentSession().createQuery("from Permission").list();
	}

	@Override
	public Permission getPermission(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePermission(String id) {
		// TODO Auto-generated method stub
		
	}

}
