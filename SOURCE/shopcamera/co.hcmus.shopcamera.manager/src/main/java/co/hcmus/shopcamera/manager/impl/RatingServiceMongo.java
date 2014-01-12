package co.hcmus.shopcamera.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.shopcamera.data.dao.IRatingDAO;
import co.hcmus.shopcamera.data.model.Rating;
import co.hcmus.shopcamera.manager.IRatingService;

@Service("ratingService")
@Transactional
public class RatingServiceMongo implements IRatingService {
	
	private static final Logger logger = LoggerFactory
			.getLogger(RatingServiceMongo.class);
	
	@Autowired
	private IRatingDAO ratingDAO;

	@Override
	public void addRating(Rating rating) {
		// TODO Auto-generated method stub
		logger.info("RatingServiceMongo add rating");
		ratingDAO.addRating(rating);
	}

	@Override
	public void updateRating(Rating rating) {
		// TODO Auto-generated method stub
		logger.info("RatingServiceMongo update rating with Id :" + rating.getId());
		ratingDAO.updateRating(rating);
	}

	@Override
	public Rating getRatingById(String id) {
		// TODO Auto-generated method stub
		logger.info("RatingServiceMongo get rating by Id :" + id);
		return ratingDAO.getRatingById(id);
	}

	@Override
	public void deleteRating(String id) {
		logger.info("RatingServiceMongo delete rating by Id :" + id);
		ratingDAO.deleteRating(id);

	}

	@Override
	public List<Rating> getRatings() {
		// TODO Auto-generated method stub
		logger.info("RatingServiceMongo get all rating");
		return ratingDAO.getRatings();
	}

	@Override
	public List<Rating> getRatingsByProductId(String productId, String status) {
		// TODO Auto-generated method stub
		logger.info("RatingServiceMongo get  rating by ProductId : " + productId);
		return ratingDAO.getRatingsByProductId(productId,status);
	}

	@Override
	public double checkRaingByProductIdByEmail(String productId, String email , String status) {
		// TODO Auto-generated method stub
		logger.info("RatingServiceMongo check rating by productId : " + productId + " , Email : " + email);
		return ratingDAO.checkRaingByProductIdByEmail(productId, email, status);
	}

	@Override
	public Rating getRatingByEmail(String email, String status) {
		// TODO Auto-generated method stub
		logger.info("RatingServiceMongo get rating by Email : " + email);
		return ratingDAO.getRatingByEmail(email, status);
	}

}
