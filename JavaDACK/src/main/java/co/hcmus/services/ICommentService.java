package co.hcmus.services;

import java.util.List;

import co.hcmus.models.Comment;

public interface ICommentService {
	public void addComment(Comment comment);

	public void updateComment(Comment comment);

	public Comment getComment(String id);

	public void deleteComment(String id);

	public List<Comment> getComments();

	public List<Comment> getCommentByEmail(String email, String status);

	public List<Comment> getCommentByProductId(String productId, String status);

	public List<Comment> getCommentOfCommentRoot(String idCommentRoot,
			String status);

	public void activeComment(String id);
}
