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
	private ICommentDAO commentDAO;

	@Override
	public void addComment(Comment comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateComment(Comment comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Comment getComment(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteComment(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Comment> getComments() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
}
