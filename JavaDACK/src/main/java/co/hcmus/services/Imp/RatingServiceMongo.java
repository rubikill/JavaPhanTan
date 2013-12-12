package co.hcmus.services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IRatingDAO;
import co.hcmus.models.Rating;
import co.hcmus.services.IRatingService;

@Service("ratingService")
@Transactional
public class RatingServiceMongo implements IRatingService {
	@Autowired
	private IRatingDAO ratingDAO;

	@Override
	public void addRating(Rating rating) {
		// TODO Auto-generated method stub
		ratingDAO.addRating(rating);
	}

	@Override
	public void updateRating(Rating rating) {
		// TODO Auto-generated method stub
		ratingDAO.updateRating(rating);
	}

	@Override
	public Rating getRatingById(String id) {
		// TODO Auto-generated method stub
		return ratingDAO.getRatingById(id);
	}

	@Override
	public void deleteRating(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Rating> getRatings() {
		// TODO Auto-generated method stub
		return ratingDAO.getRatings();
	}

}