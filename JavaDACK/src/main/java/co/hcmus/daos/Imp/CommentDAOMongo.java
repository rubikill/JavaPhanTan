package co.hcmus.daos.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import co.hcmus.daos.ICommentDAO;
import co.hcmus.models.Account;
import co.hcmus.models.Comment;

@Repository("commentDAO")
public class CommentDAOMongo implements ICommentDAO {
	@Autowired
	private MongoTemplate mongoTemplate;
	// Collection name save in MongoDB
	public static final String COLLECTION_NAME = "comment";

	// Add new Comment
	@Override
	public void addComment(Comment comment) {
		if (!mongoTemplate.collectionExists(Account.class)) {
			mongoTemplate.createCollection(Account.class);
		}
		mongoTemplate.insert(comment, COLLECTION_NAME);

	}

	// Update a Comment
	@Override
	public void updateComment(Comment comment) {
		mongoTemplate.save(comment, COLLECTION_NAME);

	}

	// Get a specific Comment by id
	@Override
	public Comment getComment(String id) {
		Query searchCommentQuery = new Query(Criteria.where("id").is(id));
		return mongoTemplate.findOne(searchCommentQuery, Comment.class,
				COLLECTION_NAME);
	}

	// Delete a specific Comment by id
	@Override
	public void deleteComment(String id) {
		Comment comment = getComment(id);
		mongoTemplate.remove(comment, COLLECTION_NAME);

	}

	// Get all Comment
	@Override
	public List<Comment> getComments() {
		return mongoTemplate.findAll(Comment.class, COLLECTION_NAME);
	}

}
