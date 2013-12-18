package co.hcmus.services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.ICommentDAO;
import co.hcmus.models.Comment;
import co.hcmus.services.ICommentService;

@Service("commentService")
@Transactional
public class CommentServiceMongo implements ICommentService {
	@Autowired
	private ICommentDAO CommentDAO;

	@Override
	public void addComment(Comment comment) {
		CommentDAO.addComment(comment);
	}

	public void updateComment(Comment comment) {
		CommentDAO.updateComment(comment);
	}

	public List<Comment> getComments() {
		return CommentDAO.getComments();
	}

	@Override
	public Comment getComment(String id) {
		return CommentDAO.getComment(id);
	}

	@Override
	public void deleteComment(String id) {
		CommentDAO.deleteComment(id);
	}

	@Override
	public List<Comment> getCommentByEmail(String email, String status) {
		// TODO Auto-generated method stub
		return CommentDAO.getCommentByEmail(email, status);
	}

	@Override
	public List<Comment> getCommentByProductId(String productId, String status) {
		// TODO Auto-generated method stub
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
		CommentDAO.activeComment(id);
		
	}
	
}
