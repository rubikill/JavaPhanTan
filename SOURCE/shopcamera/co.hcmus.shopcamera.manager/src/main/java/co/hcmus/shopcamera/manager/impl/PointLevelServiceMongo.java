package co.hcmus.shopcamera.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.shopcamera.data.dao.IPointLevelDAO;
import co.hcmus.shopcamera.data.model.PointLevel;
import co.hcmus.shopcamera.manager.IPointLevelService;

@Service("pointLevelService")
@Transactional
public class PointLevelServiceMongo implements IPointLevelService {

	private static final Logger logger = LoggerFactory
			.getLogger(PointLevelServiceMongo.class);
	
	@Autowired
	private IPointLevelDAO PointLevelDAO;

	@Override
	public void addPointLevel(PointLevel pointLevel) {
		logger.info("PointLevelServiceMongo add pointLevel");
		PointLevelDAO.addPointLevel(pointLevel);
	}

	public void updatePointLevel(PointLevel pointLevel) {
		logger.info("PointLevelServiceMongo update pointLevel");
		PointLevelDAO.updatePointLevel(pointLevel);
	}

	public List<PointLevel> getPointLevels() {
		logger.info("PointLevelServiceMongo get all pointLevels");
		return PointLevelDAO.getPointLevels();
	}

	@Override
	public PointLevel getPointLevel(String id) {
		logger.info("PointLevelServiceMongo get pointLevel with Id :" + id);
		return PointLevelDAO.getPointLevel(id);
	}

	@Override
	public void deletePointLevel(String id) {
		logger.info("PointLevelServiceMongo delete pointLevel with Id : " + id);
		PointLevelDAO.deletePointLevel(id);
	}
}
