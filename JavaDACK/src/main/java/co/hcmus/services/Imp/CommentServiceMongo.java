package co.hcmus.services.Imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.ICommentDAO;
import co.hcmus.models.Comment;
import co.hcmus.services.ICommentService;

@Service("commentService")
@Transactional
public class CommentServiceMongo implements ICommentService {
	
	private static final Logger logger = LoggerFactory
			.getLogger(CommentServiceMongo.class);
	
	@Autowired
	private ICommentDAO CommentDAO;

	@Override
	public void addComment(Comment comment) {
		logger.info("CommentServiceMongo add comment");
		CommentDAO.addComment(comment);
	}

	public void updateComment(Comment comment) {
		logger.info("CommentServiceMongo update comment with Id : " + comment.getId());
		CommentDAO.updateComment(comment);
	}

	public List<Comment> getComments() {
		logger.info("CommentServiceMongo get all comments");
		return CommentDAO.getComments();
	}

	@Override
	public Comment getComment(String id) {
		logger.info("CommentServiceMongo get comment with Id : " + id);
		return CommentDAO.getComment(id);
	}

	@Override
	public void deleteComment(String id) {
		logger.info("CommentServiceMongo delete comment with Id :" + id);
		CommentDAO.deleteComment(id);
	}

	@Override
	public List<Comment> getCommentByEmail(String email, String status) {
		// TODO Auto-generated method stub
		logger.info("CommentServiceMongo get comment by Email :" + email);
		return CommentDAO.getCommentByEmail(email, status);
	}

	@Override
	public List<Comment> getCommentByProductId(String productId, String status) {
		// TODO Auto-generated method stub
		logger.info("CommentServiceMongo get comment by ProductId :" + productId);
		return CommentDAO.getCommentByProductId(productId, status);
	}

	@Override
	public List<Comment> getCommentOfCommentRoot(String idCommentRoot,
			String status) {
		// TODO Auto-generated method stub
		return CommentDAO.getCommentOfCommentRoot(idCommentRoot, status);
	}

	@Override
	public void activeComment(String id) {
		logger.info("CommentServiceMongo active comment with Id : " + id);
		CommentDAO.activeComment(id);
		
	}
	
}
