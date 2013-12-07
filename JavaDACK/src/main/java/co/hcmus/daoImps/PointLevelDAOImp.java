package co.hcmus.daoImps;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.hcmus.daos.PointLevelDAO;
import co.hcmus.models.PointLevel;

@Repository("pointLevelDAO")
public class PointLevelDAOImp implements PointLevelDAO {
	@Autowired
	SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addPointLevel(PointLevel pointLevel) {
		getCurrentSession().saveOrUpdate(pointLevel);
	}

	public void updatePointLevel(PointLevel pointLevel) {
		getCurrentSession().update(pointLevel);
	}

	public PointLevel getPointLevel(int id) {
		PointLevel pointLevel = new PointLevel();
		pointLevel = (PointLevel) getCurrentSession().get(PointLevel.class, id);
		return pointLevel;
	}

	public void deletePointLevel(int id) {
		PointLevel pointLevel = getPointLevel(id);
		if (pointLevel != null) {
			getCurrentSession().delete(pointLevel);
		}
	}

	@SuppressWarnings("unchecked")
	public List<PointLevel> getPointLevels() {
		return getCurrentSession().createQuery("from PointLevel").list();
	}

	@Override
	public PointLevel getPointLevel(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePointLevel(String id) {
		// TODO Auto-generated method stub
		
	}

}
