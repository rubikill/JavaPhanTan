package co.hcmus.daos.Imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import co.hcmus.daos.ITagDAO;
import co.hcmus.models.Tag;
import co.hcmus.util.STATUS;

@Repository("tagDAO")
public class TagDAOMongo implements ITagDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(TagDAOMongo.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;
	// Collection name save in MongoDB
	public static final String COLLECTION_NAME = "tag";

	@Override
	public void addTag(Tag tag) {
		if (!mongoTemplate.collectionExists(Tag.class)) {
			mongoTemplate.createCollection(Tag.class);
		}

		// insert a document
		logger.info("TagDAOMongo add tag with name : " + tag.getName());
		mongoTemplate.insert(tag, COLLECTION_NAME);

	}

	@Override
	public void updateTag(Tag tag) {
		// update a document
		logger.info("TagDAOMongo update tag with Id : " + tag.getId());
		mongoTemplate.save(tag, COLLECTION_NAME);

	}

	@Override
	public Tag getTagById(String id) {
		Query searchTagQuery = new Query(Criteria.where("_id").is(id));
		logger.info("TagDAOMongo get tag with Id : " + id);
		return mongoTemplate
				.findOne(searchTagQuery, Tag.class, COLLECTION_NAME);
	}

	@Override
	public void deleteTag(String id) {
		// delete tag by id
		Tag tag = getTagById(id);
		tag.setStatus(STATUS.INACTIVE.getStatusCode());
		logger.info("TagDAOMongo delete tag with Id : " + id);
		mongoTemplate.save(tag, COLLECTION_NAME);

	}

	@Override
	public List<Tag> getTags() {
		// get all tag
		logger.info("TagDAOMongo get all tags ");
		return mongoTemplate.findAll(Tag.class, COLLECTION_NAME);
	}

}
