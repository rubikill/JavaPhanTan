package co.hcmus.daoImps;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.hcmus.daos.HistoryDAO;
import co.hcmus.models.History;

@Repository("historyDAO")
public class HistoryDAOImp implements HistoryDAO {
	@Autowired
	SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addHistory(History history) {
		getCurrentSession().saveOrUpdate(history);
	}

	public void updateHistory(History history) {
		getCurrentSession().update(history);
	}

	public History getHistory(int id) {
		History history = new History();
		history = (History) getCurrentSession().get(History.class, id);
		return history;
	}

	public void deleteHistory(int id) {
		History history = getHistory(id);
		if (history != null) {
			getCurrentSession().delete(history);
		}
	}

	@SuppressWarnings("unchecked")
	public List<History> getHistorys() {
		return getCurrentSession().createQuery("from History").list();
	}

	@Override
	public History getHistory(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteHistory(String id) {
		// TODO Auto-generated method stub
		
	}

}
