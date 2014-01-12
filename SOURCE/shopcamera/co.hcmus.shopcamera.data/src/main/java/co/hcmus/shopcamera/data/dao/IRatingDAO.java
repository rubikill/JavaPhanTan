package co.hcmus.shopcamera.data.dao;

import java.util.List;

import co.hcmus.shopcamera.data.model.Rating;

/**
 * 
 * @author Thanh Toan
 *
 */
public interface IRatingDAO {
	/**
	 * 
	 * @param rating
	 */
	public void addRating(Rating rating);

	/**
	 * 
	 * @param rating
	 */
	public void updateRating(Rating rating);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Rating getRatingById(String id);

	/**
	 * 
	 * @param id
	 */
	public void deleteRating(String id);

	/**
	 * 
	 * @return
	 */
	public List<Rating> getRatings();
	
	/**
	 * 
	 * @param productId
	 * @param status
	 * @return
	 */
	public List<Rating> getRatingsByProductId(String productId, String status);
	
	/**
	 * 
	 * @param productId
	 * @param email
	 * @param status
	 * @return
	 */
	public double checkRaingByProductIdByEmail(String productId, String email ,String status);
	
	/**
	 * 
	 * @param email
	 * @param status
	 * @return
	 */
	public Rating getRatingByEmail(String email, String status);
}
