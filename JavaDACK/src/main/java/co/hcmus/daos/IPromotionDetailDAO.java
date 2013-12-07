package co.hcmus.daos;

import java.util.List;
import co.hcmus.models.PromotionDetail;

public interface IPromotionDetailDAO {
	public void addPromotionDetail(PromotionDetail promotionDetail);
	public void updatePromotionDetail(PromotionDetail promotionDetail);
	public void getPromotionDetailByPromotionId(String id);
	public void deletePromotionDetail(String id);
	public List<PromotionDetail> getPromotions();
}
