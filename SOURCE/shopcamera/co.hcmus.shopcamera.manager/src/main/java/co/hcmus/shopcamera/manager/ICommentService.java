package co.hcmus.shopcamera.manager;

import java.util.List;

import co.hcmus.shopcamera.data.model.Comment;

/**
 * 
 * @author Thanh Toan
 * 
 */
public interface ICommentService {
	/**
	 * 
	 * @param comment
	 */
	public void addComment(Comment comment);

	/**
	 * 
	 * @param comment
	 */
	public void updateComment(Comment comment);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Comment getComment(String id);

	/**
	 * 
	 * @param id
	 */
	public void deleteComment(String id);

	/**
	 * 
	 * @return
	 */
	public List<Comment> getComments();

	/**
	 * 
	 * @param email
	 * @param status
	 * @return
	 */
	public List<Comment> getCommentByEmail(String email, String status);

	/**
	 * 
	 * @param productId
	 * @param status
	 * @return
	 */
	public List<Comment> getCommentByProductId(String productId, String status);

	/**
	 * 
	 * @param idCommentRoot
	 * @param status
	 * @return
	 */
	public List<Comment> getCommentOfCommentRoot(String idCommentRoot,
			String status);

	public void activeComment(String id);
}
