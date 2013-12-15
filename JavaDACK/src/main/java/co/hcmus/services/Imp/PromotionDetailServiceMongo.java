package co.hcmus.services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IPromotionDetailDAO;
import co.hcmus.models.PromotionDetail;
import co.hcmus.services.IPromotionDetailService;

@Service("promotionDetailService")
@Transactional
public class PromotionDetailServiceMongo implements IPromotionDetailService {
	@Autowired
	private IPromotionDetailDAO promotionDetailDAO;

	@Override
	public void addPromotionDetail(PromotionDetail promotionDetail) {
		// TODO Auto-generated method stub
		promotionDetailDAO.addPromotionDetail(promotionDetail);
	}

	@Override
	public void updatePromotionDetail(PromotionDetail promotionDetail) {
		// TODO Auto-generated method stub
		promotionDetailDAO.updatePromotionDetail(promotionDetail);
	}

	@Override
	public PromotionDetail getPromotionDetailByPromotionId(String id) {
		// TODO Auto-generated method stub
		return promotionDetailDAO.getPromotionDetailByPromotionId(id);
	}

	@Override
	public void deletePromotionDetail(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PromotionDetail> getPromotionDetails() {
		// TODO Auto-generated method stub
		return promotionDetailDAO.getPromotionDetails();
	}

	@Override
	public List<PromotionDetail> getPromotionDetailsByPromotionId(
			String promotionId, String status) {
		// TODO Auto-generated method stub
		return promotionDetailDAO.getPromotionDetailsByPromotionId(promotionId,
				status);
	}

}
