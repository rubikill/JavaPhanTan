package co.hcmus.shopcamera.data.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.shopcamera.data.dao.IRatingDAO;
import co.hcmus.shopcamera.data.model.Rating;
import co.hcmus.shopcamera.utility.STATUS;

@Repository("ratingDAO")
@Transactional
public class RatingDAOMongo implements IRatingDAO {
	
	private static final Logger logger = LoggerFactory
			.getLogger(RatingDAOMongo.class);

	@Autowired
	private MongoTemplate mongoTemplate;
	// Collection name save in MongoDB
	public static final String COLLECTION_NAME = "rating";

	@Override
	public void addRating(Rating rating) {
		if (!mongoTemplate.collectionExists(Rating.class)) {
			mongoTemplate.createCollection(Rating.class);
		}
		logger.info("RatingDAOMongo add rating");
		// insert a document
		mongoTemplate.insert(rating, COLLECTION_NAME);
	}

	@Override
	public void updateRating(Rating rating) {
		// update a document
		logger.info("RatingDAOMongo update rating with Id : " + rating.getId());
		mongoTemplate.save(rating, COLLECTION_NAME);

	}

	@Override
	public Rating getRatingById(String id) {
		Query searchRatingQuery = new Query(Criteria.where("_id").is(id));
		logger.info("RatingDAOMongo get rating with Id : " + id);
		return mongoTemplate.findOne(searchRatingQuery, Rating.class,
				COLLECTION_NAME);
	}

	@Override
	public void deleteRating(String id) {
		// delete document by id
		Rating rating = getRatingById(id);
		rating.setStatus(STATUS.INACTIVE.getStatusCode());
		logger.info("RatingDAOMongo delete rating with Id : " + id);
		mongoTemplate.save(rating, COLLECTION_NAME);
	}

	@Override
	public List<Rating> getRatings() {
		// get all docuemnt
		logger.info("RatingDAOMongo get all rating");
		return mongoTemplate.findAll(Rating.class, COLLECTION_NAME);
	}

	@Override
	public List<Rating> getRatingsByProductId(String productId, String status) {
		// TODO Auto-generated method stub
		Query searchRatingByProductIdQuery = new Query(Criteria
				.where("productId").is(productId).and("status").is(status));
		logger.info("RatingDAOMongo get rating with productId : " + productId);
		return mongoTemplate.find(searchRatingByProductIdQuery, Rating.class,
				COLLECTION_NAME);
	}

	@Override
	public double checkRaingByProductIdByEmail(String productId, String email,
			String status) {
		// TODO Auto-generated method stub
		List<Rating> listRatingByProductId = getRatingsByProductId(productId,
				status);
		logger.info("RatingDAOMongo check Rating with ProductId : " + productId + " with Email : " + email);
		int sumRating = 0;
		double average = -1;
		if (listRatingByProductId.size() == 0) {
			return average;
		}
		for (Rating r : listRatingByProductId) {
			sumRating = sumRating + r.getStar();
		}
		double tempAverage = (double) sumRating / (double) listRatingByProductId.size();
		for (Rating r : listRatingByProductId) {
			if (r.getEmail().equals(email)) {
				average = tempAverage;
			}
		}

		return average;
	}

	@Override
	public Rating getRatingByEmail(String email, String status) {
		// TODO Auto-generated method stub
		Query searchRatingQueryByEmail = new Query(Criteria.where("email")
				.is(email).and("status").is(status));
		logger.info("RatingDAOMongo get rating with email : " + email);
		return mongoTemplate.findOne(searchRatingQueryByEmail, Rating.class,
				COLLECTION_NAME);
	}

}
