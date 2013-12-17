package co.hcmus.daos;

import java.util.List;
import co.hcmus.models.PromotionDetail;

public interface IPromotionDetailDAO {
	public void addPromotionDetail(PromotionDetail promotionDetail);

	public void updatePromotionDetail(PromotionDetail promotionDetail);

	public PromotionDetail getPromotionDetailByPromotionId(String id);

	public void deletePromotionDetail(String id);

	public List<PromotionDetail> getPromotionDetails();

	public List<PromotionDetail> getPromotionDetailsByPromotionIdWithoutStatus(
			String promotionId);

	public List<PromotionDetail> getPromotionDetailsByPromotionId(
			String promotionId, String status);

	public List<PromotionDetail> getPromotionDetailsByProductId(
			String productId, String status);
}
