package co.hcmus.shopcamera.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.shopcamera.data.dao.IPromotionDAO;
import co.hcmus.shopcamera.data.model.Promotion;
import co.hcmus.shopcamera.data.model.PromotionDetail;
import co.hcmus.shopcamera.manager.IPromotionDetailService;
import co.hcmus.shopcamera.manager.IPromotionService;
import co.hcmus.shopcamera.utility.STATUS;

@Service("promotionService")
@Transactional
public class PromotionServiceMongo implements IPromotionService {
	
	private static final Logger logger = LoggerFactory
			.getLogger(PromotionServiceMongo.class);

	@Autowired
	private IPromotionDAO promotionDAO;
	@Autowired
	private IPromotionDetailService promotionDetailService;

	@Override
	public void addPromotion(Promotion promotion) {
		// TODO Auto-generated method stub
		logger.info("PromotionServiceMongo add promotion with name :" + promotion.getName());
		promotionDAO.addPromotion(promotion);
	}

	@Override
	public void updatePromotion(Promotion promotion) {
		// TODO Auto-generated method stub
		logger.info("PromotionServiceMongo update promotion with Id :" + promotion.getId());
		promotionDAO.updatePromotion(promotion);
	}

	@Override
	public Promotion getPromotionById(String id) {
		// TODO Auto-generated method stub
		logger.info("PromotionServiceMongo get promotion By id  :" + id);
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
		logger.info("PromotionServiceMongo delete promotion with id :" + id);
		promotionDAO.deletePromotion(id);

	}

	@Override
	public List<Promotion> getPromotions() {
		// TODO Auto-generated method stub
		logger.info("PromotionServiceMongo get all promotion");
		return promotionDAO.getPromotions();
	}

}
