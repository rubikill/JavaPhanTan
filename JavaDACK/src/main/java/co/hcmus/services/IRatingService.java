package co.hcmus.services;

import java.util.List;

import co.hcmus.models.Rating;

public interface IRatingService {
	public void addRating(Rating rating);

	public void updateRating(Rating rating);

	public Rating getRatingById(String id);

	public void deleteRating(String id);

	public List<Rating> getRatings();
}
