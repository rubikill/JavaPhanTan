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

import co.hcmus.shopcamera.data.dao.ICommentDAO;
import co.hcmus.shopcamera.data.model.Account;
import co.hcmus.shopcamera.data.model.Comment;
import co.hcmus.shopcamera.utility.STATUS;

@Repository("commentDAO")
@Transactional
public class CommentDAOMongo implements ICommentDAO {
	
	private static final Logger logger = LoggerFactory
			.getLogger(CommentDAOMongo.class);
	
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
		logger.info("CommentDAOMongo add comment");
		mongoTemplate.insert(comment, COLLECTION_NAME);

	}

	// Update a Comment
	@Override
	public void updateComment(Comment comment) {
		logger.info("CommentDAOMongo update comment with Id :" + comment.getId());
		mongoTemplate.save(comment, COLLECTION_NAME);

	}

	// Get a specific Comment by id
	@Override
	public Comment getComment(String id) {
		Query searchCommentQuery = new Query(Criteria.where("_id").is(id));
		logger.info("CommentDAOMongo get comment with Id :" + id);
		return mongoTemplate.findOne(searchCommentQuery, Comment.class,
				COLLECTION_NAME);
	}

	// Delete a specific Comment by id
	@Override
	public void deleteComment(String id) {
		Comment comment = getComment(id);
		comment.setStatus(STATUS.INACTIVE.getStatusCode());

		List<Comment> listComment = getCommentOfCommentRoot(comment.getId(),
				STATUS.ACTIVE.getStatusCode());
		for (Comment commentTemp : listComment)
			deleteComment(commentTemp.getId());
		logger.info("CommentDAOMongo delete comment with Id :" + id);
		mongoTemplate.save(comment, COLLECTION_NAME);

	}

	// Get all Comment
	@Override
	public List<Comment> getComments() {
		logger.info("CommentDAOMongo get all comments");
		return mongoTemplate.findAll(Comment.class, COLLECTION_NAME);
	}

	@Override
	public List<Comment> getCommentByEmail(String email, String status) {
		Query searchCommentByEmailQuery = new Query(Criteria.where("email")
				.is(email).and("status").is(status));
		logger.info("CommentDAOMongo get comment with Email :" + email);
		return mongoTemplate.find(searchCommentByEmailQuery, Comment.class,
				COLLECTION_NAME);
	}

	@Override
	public List<Comment> getCommentByProductId(String productId, String status) {
		Query searchCommentByEmailQuery = new Query(Criteria.where("productId")
				.is(productId).and("status").is(status));
		logger.info("CommentDAOMongo get comment with productId :" + productId);
		return mongoTemplate.find(searchCommentByEmailQuery, Comment.class,
				COLLECTION_NAME);
	}

	@Override
	public List<Comment> getCommentOfCommentRoot(String idCommentRoot,
			String status) {
		Query searchCommentByEmailQuery = new Query(Criteria
				.where("idCommentRoot").is(idCommentRoot).and("status")
				.is(status));
		return mongoTemplate.find(searchCommentByEmailQuery, Comment.class,
				COLLECTION_NAME);
	}

	@Override
	public void activeComment(String id) {
		Comment comment = getComment(id);
		comment.setStatus(STATUS.ACTIVE.getStatusCode());

		List<Comment> listComment = getCommentOfCommentRoot(comment.getId(),
				STATUS.INACTIVE.getStatusCode());
		for (Comment commentTemp : listComment)
			activeComment(commentTemp.getId());
		logger.info("CommentDAOMongo active comment with id :" +  id);
		mongoTemplate.save(comment, COLLECTION_NAME);
		
	}

}
