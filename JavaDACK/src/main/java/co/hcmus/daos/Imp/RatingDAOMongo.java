package co.hcmus.daos.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import co.hcmus.daos.IRatingDAO;
import co.hcmus.models.Rating;

@Repository("ratingDAO")
public class RatingDAOMongo implements IRatingDAO {

	@Autowired
	private MongoTemplate mongoTemplate;
	// Collection name save in MongoDB
	public static final String COLLECTION_NAME = "rating";

	@Override
	public void addRating(Rating rating) {
		if (!mongoTemplate.collectionExists(Rating.class)) {
			mongoTemplate.createCollection(Rating.class);
		}
		// insert a document
		mongoTemplate.insert(rating, COLLECTION_NAME);
	}

	@Override
	public void updateRating(Rating rating) {
		// update a document
		mongoTemplate.save(rating, COLLECTION_NAME);

	}

	@Override
	public Rating getRatingById(String id) {
		Query searchRatingQuery = new Query(Criteria.where("_id").is(id));
		return mongoTemplate.findOne(searchRatingQuery, Rating.class,
				COLLECTION_NAME);
	}

	@Override
	public void deleteRating(String id) {
		// delete document by id
		Rating rating = getRatingById(id);
		mongoTemplate.remove(rating, COLLECTION_NAME);
	}

	@Override
	public List<Rating> getRatings() {
		// get all docuemnt
		return mongoTemplate.findAll(Rating.class, COLLECTION_NAME);
	}

	@Override
	public List<Rating> getRatingsByProductId(String productId) {
		// TODO Auto-generated method stub
		Query searchRatingByProductIdQuery = new Query(Criteria.where(
				"productId").is(productId));
		return mongoTemplate.find(searchRatingByProductIdQuery, Rating.class,
				COLLECTION_NAME);
	}

	@Override
	public Rating checkRaingByProductIdByEmail(String productId, String email) {
		// TODO Auto-generated method stub
		List<Rating> listRatingByProductId = getRatingsByProductId(productId);
		int sumRating = 0;
		Rating resultRating = null;
		if (listRatingByProductId.size() == 0) {
			return resultRating;
		}
		for (Rating r : listRatingByProductId) {
			sumRating = sumRating + r.getStar();
		}
		int average = sumRating / listRatingByProductId.size();
		for (Rating r : listRatingByProductId) {
			if (r.getEmail().equals(email)) {
				resultRating = new Rating();
				resultRating.setEmail(email);
				resultRating.setProductId(productId);
				resultRating.setStar(average);
			}
		}

		return resultRating;
	}

}
