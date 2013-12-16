package co.hcmus.services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IHistoryDAO;
import co.hcmus.models.History;
import co.hcmus.models.HistoryDetail;
import co.hcmus.services.IHistoryDetailService;
import co.hcmus.services.IHistoryService;
import co.hcmus.util.STATUS;

@Service("historyService")
@Transactional
public class HistoryServiceMongo implements IHistoryService {

	@Autowired
	private IHistoryDAO HistoryDAO;

	@Autowired
	private IHistoryDetailService historyDetailService;

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
	public void deleteHistory(String id) {
		List<HistoryDetail> listHistoryDetail = historyDetailService
				.getHistoryDetailByHistoryId(id,
						STATUS.ACTIVE.getStatusCode());
		for(HistoryDetail historyDetail : listHistoryDetail)
			historyDetailService.deleteHistoryDetail(historyDetail.getId());
		HistoryDAO.deleteHistory(id);
	}

	@Override
	public List<History> getHistorysByEmail(String email) {
		return HistoryDAO.getHistorysByEmail(email);
	}

}
