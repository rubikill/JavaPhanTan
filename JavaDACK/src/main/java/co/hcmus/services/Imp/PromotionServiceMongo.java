package co.hcmus.services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IPromotionDAO;
import co.hcmus.models.Promotion;
import co.hcmus.models.PromotionDetail;
import co.hcmus.services.IPromotionDetailService;
import co.hcmus.services.IPromotionService;
import co.hcmus.util.STATUS;

@Service("promotionService")
@Transactional
public class PromotionServiceMongo implements IPromotionService {

	@Autowired
	private IPromotionDAO promotionDAO;
	@Autowired
	private IPromotionDetailService promotionDetailService;

	@Override
	public void addPromotion(Promotion promotion) {
		// TODO Auto-generated method stub
		promotionDAO.addPromotion(promotion);
	}

	@Override
	public void updatePromotion(Promotion promotion) {
		// TODO Auto-generated method stub
		promotionDAO.updatePromotion(promotion);
	}

	@Override
	public Promotion getPromotionById(String id) {
		// TODO Auto-generated method stub
		return promotionDAO.getPromotionById(id);
	}

	@Override
	public void deletePromotion(String id) {

		List<PromotionDetail> listPromotionDetail = promotionDetailService
				.getPromotionDetailsByPromotionId(id,
						STATUS.ACTIVE.getStatusCode());
		for (PromotionDetail promotionDetail : listPromotionDetail)
			promotionDetailService.deletePromotionDetail(promotionDetail
					.getId());
		promotionDAO.deletePromotion(id);

	}

	@Override
	public List<Promotion> getPromotions() {
		// TODO Auto-generated method stub
		return promotionDAO.getPromotions();
	}

}
