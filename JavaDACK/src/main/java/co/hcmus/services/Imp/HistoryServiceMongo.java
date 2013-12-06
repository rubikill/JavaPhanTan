package co.hcmus.services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IHistoryDAO;
import co.hcmus.models.History;
import co.hcmus.services.IHistoryService;

@Service("historyService")
@Transactional
public class HistoryServiceMongo implements IHistoryService {

	@Autowired
	private IHistoryDAO HistoryDAO;

	@Override
	public void addHistory(History History) {
		HistoryDAO.addHistory(History);
	}

	public void updateHistory(History History) {
		HistoryDAO.updateHistory(History);
	}

	public List<History> getHistorys() {
		return HistoryDAO.getHistorys();
	}

	@Override
	public History getHistory(String id) {
		return HistoryDAO.getHistory(id);
	}

	@Override
	public void deleteHistory(String email) {
		HistoryDAO.deleteHistory(email);
	}
	
}
