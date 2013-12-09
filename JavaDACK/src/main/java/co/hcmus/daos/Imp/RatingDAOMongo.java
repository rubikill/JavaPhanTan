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

}
