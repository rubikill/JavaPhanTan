package co.hcmus.daos;

import java.util.List;

import co.hcmus.models.Comment;

public interface CommentDAO {
	public void addComment(Comment comment);
	public void updateComment(Comment comment);
	public Comment getComment(String id);
	public void deleteComment(String id);
	public List<Comment> getComments();
	
}
