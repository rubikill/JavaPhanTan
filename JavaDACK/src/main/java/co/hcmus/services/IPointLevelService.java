package co.hcmus.services;
import java.util.List;

import co.hcmus.models.PointLevel;

public interface IPointLevelService {
	public void addPointlevel(PointLevel pointlevel);

	public void updatePointlevel(PointLevel pointlevel);

	public PointLevel getPointlevel(int id);

	public void deletePointlevel(int id);

	public List<PointLevel> getPointlevels();

}
