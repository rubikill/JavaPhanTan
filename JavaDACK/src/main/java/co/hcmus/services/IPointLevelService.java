package co.hcmus.services;

import java.util.List;

import co.hcmus.models.PointLevel;

/**
 * 
 * @author Thanh Toan
 * 
 */
public interface IPointLevelService {
	/**
	 * 
	 * @param pointLevel
	 */
	public void addPointLevel(PointLevel pointLevel);

	/**
	 * 
	 * @param pointLevel
	 */
	public void updatePointLevel(PointLevel pointLevel);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public PointLevel getPointLevel(String id);

	/**
	 * 
	 * @param id
	 */
	public void deletePointLevel(String id);

	/**
	 * 
	 * @return
	 */
	public List<PointLevel> getPointLevels();

}
