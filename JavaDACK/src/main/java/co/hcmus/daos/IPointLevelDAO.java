package co.hcmus.daos;

import java.util.List;

import co.hcmus.models.PointLevel;

/**
 * 
 * @author Thanh Toan
 * 
 */
public interface IPointLevelDAO {
	/**
	 * 
	 * @param PointLevel
	 */
	public void addPointLevel(PointLevel PointLevel);

	/**
	 * 
	 * @param PointLevel
	 */
	public void updatePointLevel(PointLevel PointLevel);

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
