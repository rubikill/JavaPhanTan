package co.hcmus.serviceImps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.HistoryDAO;
import co.hcmus.models.History;
import co.hcmus.services.HistoryService;

@Service("historyService")
@Transactional
public class HistoryServiceImp implements HistoryService {

	@Autowired
	private HistoryDAO historyDAO;

	@Override
	public void addHistory(History history) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateHistory(History history) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public History getHistory(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteHistory(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<History> getHistorys() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
