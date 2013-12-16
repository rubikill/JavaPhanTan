package co.hcmus.services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IPointLevelDAO;
import co.hcmus.models.PointLevel;
import co.hcmus.services.IPointLevelService;

@Service("pointLevelService")
@Transactional
public class PointLevelServiceMongo implements IPointLevelService {

	@Autowired
	private IPointLevelDAO PointLevelDAO;

	@Override
	public void addPointLevel(PointLevel pointLevel) {
		PointLevelDAO.addPointLevel(pointLevel);
	}

	public void updatePointLevel(PointLevel pointLevel) {
		PointLevelDAO.updatePointLevel(pointLevel);
	}

	public List<PointLevel> getPointLevels() {
		return PointLevelDAO.getPointLevels();
	}

	@Override
	public PointLevel getPointLevel(String id) {
		return PointLevelDAO.getPointLevel(id);
	}

	@Override
	public void deletePointLevel(String id) {
		PointLevelDAO.deletePointLevel(id);
	}
}
