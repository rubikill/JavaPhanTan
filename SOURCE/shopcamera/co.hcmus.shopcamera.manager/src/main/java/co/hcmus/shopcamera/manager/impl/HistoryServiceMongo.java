package co.hcmus.shopcamera.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.shopcamera.data.dao.IHistoryDAO;
import co.hcmus.shopcamera.data.dao.IPaymentTypeDAO;
import co.hcmus.shopcamera.data.model.History;
import co.hcmus.shopcamera.data.model.HistoryDetail;
import co.hcmus.shopcamera.manager.IHistoryDetailService;
import co.hcmus.shopcamera.manager.IHistoryService;
import co.hcmus.shopcamera.utility.STATUS;

/**
 * 
 * @author WindyZBoy
 *
 */
@Service("historyService")
@Transactional
public class HistoryServiceMongo implements IHistoryService {

	private static final Logger logger = LoggerFactory
			.getLogger(HistoryServiceMongo.class);
	
	@Autowired
	private IHistoryDAO HistoryDAO;
	@Autowired
	private IPaymentTypeDAO paymentTypeDAO;
	@Autowired
	private IHistoryDetailService historyDetailService;

	@Override
	public void addHistory(History History) {
		logger.info("HistoryServiceMongo add History");
		HistoryDAO.addHistory(History);
	}

	public void updateHistory(History History) {
		logger.info("HistoryServiceMongo update History with Id : " + History.getId());
		HistoryDAO.updateHistory(History);
	}

	public List<History> getHistorys() {
		List<History> listHistory = HistoryDAO.getHistorys();
		for (int i = 0; i < listHistory.size(); i++) {
			listHistory.get(i).setPaymentType(
					paymentTypeDAO.getPaymentTypeById(listHistory.get(i)
							.getPaymentTypeId()));
		}
		logger.info("HistoryServiceMongo get all  History");
		return listHistory;
	}

	@Override
	public History getHistory(String id) {
		logger.info("HistoryServiceMongo get History with Id : " + id);
		return HistoryDAO.getHistory(id);
	}

	@Override
	public void deleteHistory(String id) {
		List<HistoryDetail> listHistoryDetail = historyDetailService
				.getHistoryDetailByHistoryId(id, STATUS.ACTIVE.getStatusCode());
		for (HistoryDetail historyDetail : listHistoryDetail)
			historyDetailService.deleteHistoryDetail(historyDetail.getId());
		logger.info("HistoryServiceMongo delete History with Id  :" + id);
		HistoryDAO.deleteHistory(id);
	}

	@Override
	public List<History> getHistorysByEmail(String email) {
		logger.info("HistoryServiceMongo get History By Email : " + email);
		return HistoryDAO.getHistorysByEmail(email);
	}

}
