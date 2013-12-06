package co.hcmus.services;

import java.util.List;

import co.hcmus.models.Comment;

public interface ICommentService {
	public void addComment(Comment comment);

	public void updateComment(Comment comment);

	public Comment getComment(int id);

	public void deleteComment(int id);

	public List<Comment> getComments();

}
