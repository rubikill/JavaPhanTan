package co.hcmus.daos;

import java.util.List;

import co.hcmus.models.Comment;

public interface ICommentDAO {
	public void addComment(Comment comment);

	public void updateComment(Comment comment);

	public Comment getComment(String id);

	public void deleteComment(String id);

	public List<Comment> getComments();

	public List<Comment> getCommentByEmail(String email, String status);

	public List<Comment> getCommentByProductId(String productId, String status);

	public List<Comment> getCommentOfCommentRoot(String idCommentRoot,
			String status);

}
