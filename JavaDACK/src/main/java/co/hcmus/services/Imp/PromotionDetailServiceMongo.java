package co.hcmus.services.Imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IProductDAO;
import co.hcmus.daos.IPromotionDetailDAO;
import co.hcmus.models.PromotionDetail;
import co.hcmus.services.IPromotionDetailService;

@Service("promotionDetailService")
@Transactional
public class PromotionDetailServiceMongo implements IPromotionDetailService {
	

	private static final Logger logger = LoggerFactory
			.getLogger(PromotionDetailServiceMongo.class);
	
	@Autowired
	private IPromotionDetailDAO promotionDetailDAO;
	
	@Autowired
	private IProductDAO productDAO;

	@Override
	public void addPromotionDetail(PromotionDetail promotionDetail) {
		// TODO Auto-generated method stub
		logger.info("PromotionDetailServiceMongo add promotionDetail");
		promotionDetailDAO.addPromotionDetail(promotionDetail);
	}

	@Override
	public void updatePromotionDetail(PromotionDetail promotionDetail) {
		// TODO Auto-generated method stub
		logger.info("PromotionDetailServiceMongo update promotionDetail with Id : " + promotionDetail.getId());
		promotionDetailDAO.updatePromotionDetail(promotionDetail);
	}

	@Override
	public PromotionDetail getPromotionDetailByPromotionId(String id) {
		// TODO Auto-generated method stub
		logger.info("PromotionDetailServiceMongo get promotionDetail with Id : " + id);
		PromotionDetail pd =  promotionDetailDAO.getPromotionDetailByPromotionId(id);
		pd.setProduct(productDAO.getProductById(pd.getProductId()));
		return pd;
	}

	@Override
	public void deletePromotionDetail(String id) {
		logger.info("PromotionDetailServiceMongo delete promotionDetail with Id :" + id);
		promotionDetailDAO.deletePromotionDetail(id);

	}

	@Override
	public List<PromotionDetail> getPromotionDetails() {
		// TODO Auto-generated method stub
		logger.info("PromotionDetailServiceMongo get all promotionDetail");
		return promotionDetailDAO.getPromotionDetails();
	}

	@Override
	public List<PromotionDetail> getPromotionDetailsByPromotionIdWithoutStatus(
			String promotionId) {
		// TODO Auto-generated method stub
		return promotionDetailDAO.getPromotionDetailsByPromotionIdWithoutStatus(promotionId);
	}

	@Override
	public List<PromotionDetail> getPromotionDetailsByPromotionId(
			String promotionId, String status) {
		List<PromotionDetail> lpd =  promotionDetailDAO.getPromotionDetailsByPromotionId(promotionId, status);
		for (int i = 0; i < lpd.size(); i++){
			System.out.println("product ID:"  + lpd.get(i).getProductId());
			System.out.println("name: "  + productDAO.getProductById(lpd.get(i).getProductId()).getName());
			lpd.get(i).setProduct(productDAO.getProductById(lpd.get(i).getProductId()));
		}
		return lpd;
	}

	
	@Override
	public List<PromotionDetail> getPromotionDetailsByProductId(
			String productId, String status) {
		// TODO Auto-generated method stub
		return promotionDetailDAO.getPromotionDetailsByProductId(productId, status);
	}

	@Override
	public void activePromotionDetail(String id) {
		promotionDetailDAO.activePromotionDetail(id);
		
	}

}
