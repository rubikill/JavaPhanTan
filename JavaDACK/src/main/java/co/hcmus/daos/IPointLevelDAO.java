package co.hcmus.daos;

import java.util.List;

import co.hcmus.models.PointLevel;

public interface IPointLevelDAO {
	public void addPointLevel(PointLevel PointLevel);
	public void updatePointLevel(PointLevel PointLevel);
	public PointLevel getPointLevel(String id);
	public void deletePointLevel(String id);
	public List<PointLevel> getPointLevels();
	
}
