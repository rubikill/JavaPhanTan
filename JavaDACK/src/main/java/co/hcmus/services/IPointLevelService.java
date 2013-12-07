package co.hcmus.services;
import java.util.List;

import co.hcmus.models.PointLevel;

public interface IPointLevelService {
	public void addPointLevel(PointLevel pointLevel);

	public void updatePointLevel(PointLevel pointLevel);

	public PointLevel getPointLevel(String id);

	public void deletePointLevel(String id);

	public List<PointLevel> getPointLevels();

}
