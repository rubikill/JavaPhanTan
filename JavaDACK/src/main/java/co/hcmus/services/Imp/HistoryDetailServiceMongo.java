package co.hcmus.services.Imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IHistoryDetailDAO;
import co.hcmus.models.HistoryDetail;
import co.hcmus.services.IHistoryDetailService;

@Service("historyDetailService")
@Transactional
public class HistoryDetailServiceMongo implements IHistoryDetailService {
	
	private static final Logger logger = LoggerFactory
			.getLogger(HistoryDetailServiceMongo.class);
	
	@Autowired
	private IHistoryDetailDAO historyDetailDAO;

	@Override
	public void addHistoryDetail(HistoryDetail historyDetail) {
		// TODO Auto-generated method stub
		logger.info("HistoryDetailServiceMongo add HistoryDetal");
		historyDetailDAO.addHistoryDetail(historyDetail);
	}

	@Override
	public void updateHistoryDetail(HistoryDetail historyDetail) {
		// TODO Auto-generated method stub
		logger.info("HistoryDetailServiceMongo update HistoryDetal with Id : " + historyDetail.getId());
		historyDetailDAO.updateHistoryDetail(historyDetail);
	}

	@Override
	public HistoryDetail getHistoryDetailById(String id) {
		// TODO Auto-generated method stub
		logger.info("HistoryDetailServiceMongo get HistoryDetal with Id :" + id);
		return historyDetailDAO.getHistoryDetailById(id);
	}

	@Override
	public void deleteHistoryDetail(String id) {
		logger.info("HistoryDetailServiceMongo delete HistoryDetal with Id : " + id);
		historyDetailDAO.deleteHistoryDetail(id);

	}

	@Override
	public List<HistoryDetail> getHistoryDetails() {
		// TODO Auto-generated method stub
		logger.info("HistoryDetailServiceMongo get all HistoryDetal");
		return historyDetailDAO.getHistoryDetails();
	}

	@Override
	public List<HistoryDetail> getHistoryDetailByHistoryId(String historyId,
			String status) {
		logger.info("HistoryDetailServiceMongo get HistoryDetal by HistoryId : " + historyId);
		// TODO Auto-generated method stub
		return historyDetailDAO.getHistoryDetailByHistoryId(historyId, status);
	}

	@Override
	public List<HistoryDetail> getHistoryDetailByProductId(String productId,
			String status) {
		// TODO Auto-generated method stub
		logger.info("HistoryDetailServiceMongo get HistoryDetal by ProductId : " + productId);
		return historyDetailDAO.getHistoryDetailByProductId(productId, status);
	}

}
