package co.hcmus.shopcamera.data.dao;

import java.util.List;

import co.hcmus.shopcamera.data.model.Comment;

/**
 * Interface of comment DAO
 * @author Thanh Toan
 *
 */
public interface ICommentDAO {
	
	/**
	 * Create
	 * @param comment
	 */
	public void addComment(Comment comment);

	/**
	 * Update
	 * @param comment
	 */
	public void updateComment(Comment comment);

	/**
	 * Get
	 * @param id
	 * @return
	 */
	public Comment getComment(String id);

	/**
	 * Dekete
	 * @param id
	 */
	public void deleteComment(String id);

	/**
	 * Get all
	 * @return
	 */
	public List<Comment> getComments();

	/**
	 * Get by email
	 * @param email
	 * @param status
	 * @return
	 */
	public List<Comment> getCommentByEmail(String email, String status);

	/**
	 * Get by product id
	 * @param productId
	 * @param status
	 * @return
	 */
	public List<Comment> getCommentByProductId(String productId, String status);

	/**
	 * Get by comment root
	 * @param idCommentRoot
	 * @param status
	 * @return
	 */
	public List<Comment> getCommentOfCommentRoot(String idCommentRoot,
			String status);
	
	public void activeComment(String id);

}
