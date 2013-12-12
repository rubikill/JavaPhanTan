package co.hcmus.daos;

import java.util.List;

import co.hcmus.models.Rating;

public interface IRatingDAO {
	public void addRating(Rating rating);

	public void updateRating(Rating rating);

	public Rating getRatingById(String id);

	public void deleteRating(String id);

	public List<Rating> getRatings();
	
	public List<Rating> getRatingsByProductId(String productId, String status);
	
	public Rating checkRaingByProductIdByEmail(String productId, String email ,String status);
	
	public Rating getRatingByEmail(String email, String status);
}
