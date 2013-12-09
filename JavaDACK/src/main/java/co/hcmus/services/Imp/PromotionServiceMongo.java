package co.hcmus.services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IPromotionDAO;
import co.hcmus.models.Promotion;
import co.hcmus.services.IPromotionService;

@Service("promotionService")
@Transactional
public class PromotionServiceMongo implements IPromotionService {

	@Autowired
	private IPromotionDAO promotionDAO;

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
		// TODO Auto-generated method stub

	}

	@Override
	public List<Promotion> getPromotions() {
		// TODO Auto-generated method stub
		return promotionDAO.getPromotions();
	}

}
