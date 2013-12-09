package co.hcmus.daos.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import co.hcmus.daos.IPointLevelDAO;
import co.hcmus.models.Account;
import co.hcmus.models.PointLevel;

@Repository("PointLevelDAO")
public class PointLevelDAOMongo implements IPointLevelDAO {

	@Autowired
	private MongoTemplate mongoTemplate;
	// Collection name save in MongoDB
	public static final String COLLECTION_NAME = "point_level";

	// Add new PointLevel
	@Override
	public void addPointLevel(PointLevel pointLevel) {
		if (!mongoTemplate.collectionExists(Account.class)) {
			mongoTemplate.createCollection(Account.class);
		}
		mongoTemplate.insert(pointLevel, COLLECTION_NAME);

	}

	// Update PointLevel
	@Override
	public void updatePointLevel(PointLevel pointLevel) {
		mongoTemplate.save(pointLevel, COLLECTION_NAME);

	}

	// Get a specific PointLevel by id
	@Override
	public PointLevel getPointLevel(String id) {
		Query searchPointLevelQuery = new Query(Criteria.where("id").is(id));
		return mongoTemplate.findOne(searchPointLevelQuery, PointLevel.class,
				COLLECTION_NAME);
	}

	//Delete a PointLevel
	@Override
	public void deletePointLevel(String id) {
		PointLevel PointLevel = getPointLevel(id);
		mongoTemplate.remove(PointLevel, COLLECTION_NAME);

	}

	//Get all PointLevels
	@Override
	public List<PointLevel> getPointLevels() {
		return mongoTemplate.findAll(PointLevel.class, COLLECTION_NAME);
	}

}
