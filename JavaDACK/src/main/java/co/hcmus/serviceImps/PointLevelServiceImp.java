package co.hcmus.serviceImps;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.PointLevelDAO;
import co.hcmus.models.PointLevel;
import co.hcmus.services.PointLevelService;

@Service("pointLevelService")
@Transactional
public class PointLevelServiceImp implements PointLevelService {

	@Autowired
	private PointLevelDAO pointLevelDAO;

	@Override
	public void addPointlevel(PointLevel pointlevel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePointlevel(PointLevel pointlevel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PointLevel getPointlevel(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePointlevel(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PointLevel> getPointlevels() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
