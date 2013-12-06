package co.hcmus.daoImps;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.hcmus.daos.CommentDAO;
import co.hcmus.models.Comment;

@Repository("commentDAO")
public class CommentDAOImp implements CommentDAO {
	@Autowired
	SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addComment(Comment comment) {
		getCurrentSession().saveOrUpdate(comment);
	}

	public void updateComment(Comment comment) {
		getCurrentSession().update(comment);
	}

	public Comment getComment(int id) {
		Comment comment = new Comment();
		comment = (Comment) getCurrentSession().get(Comment.class, id);
		return comment;
	}

	public void deleteComment(int id) {
		Comment comment = getComment(id);
		if (comment != null) {
			getCurrentSession().delete(comment);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Comment> getComments() {
		return getCurrentSession().createQuery("from Comment").list();
	}

	@Override
	public Comment getComment(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteComment(String id) {
		// TODO Auto-generated method stub
		
	}

}
