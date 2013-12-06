package co.hcmus.daos.Imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.hcmus.daos.IPointLevelDAO;
import co.hcmus.models.PointLevel;

@Repository("pointLevelDAO")
public class PointLevelDAOMongo implements IPointLevelDAO {

	@Override
	public void addPointLevel(PointLevel PointLevel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePointLevel(PointLevel PointLevel) {
		// TODO Auto-generated method stub
		
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

	@Override
	public List<PointLevel> getPointLevels() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
