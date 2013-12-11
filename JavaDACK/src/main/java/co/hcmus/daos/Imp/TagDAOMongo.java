package co.hcmus.daos.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import co.hcmus.daos.ITagDAO;
import co.hcmus.models.Tag;

@Repository("tagDAO")
public class TagDAOMongo implements ITagDAO {

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
		mongoTemplate.insert(tag, COLLECTION_NAME);

	}

	@Override
	public void updateTag(Tag tag) {
		// update a document
		mongoTemplate.save(tag, COLLECTION_NAME);

	}

	@Override
	public Tag getTagById(String id) {
		Query searchTagQuery = new Query(Criteria.where("_id").is(id));
		return mongoTemplate
				.findOne(searchTagQuery, Tag.class, COLLECTION_NAME);
	}

	@Override
	public void deleteTag(String id) {
		// delete tag by id
		Tag tag = getTagById(id);
		mongoTemplate.remove(tag, COLLECTION_NAME);

	}

	@Override
	public List<Tag> getTags() {
		// get all tag
		return mongoTemplate.findAll(Tag.class, COLLECTION_NAME);
	}

}
