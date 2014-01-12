package co.hcmus.daos;

import java.util.List;
import co.hcmus.models.PromotionDetail;

/**
 * 
 * @author Thanh Toan
 * 
 */
public interface IPromotionDetailDAO {
	/**
	 * 
	 * @param promotionDetail
	 */
	public void addPromotionDetail(PromotionDetail promotionDetail);

	/**
	 * 
	 * @param promotionDetail
	 */
	public void updatePromotionDetail(PromotionDetail promotionDetail);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public PromotionDetail getPromotionDetailByPromotionDetailId(String id);

	/**
	 * 
	 * @param id
	 */
	public void deletePromotionDetail(String id);

	/**
	 * 
	 * @return
	 */
	public List<PromotionDetail> getPromotionDetails();

	/**
	 * 
	 * @param promotionId
	 * @param status
	 * @return
	 */
	public List<PromotionDetail> getPromotionDetailsByPromotionId(
			String promotionId, String status);

	/**
	 * 
	 * @param productId
	 * @param status
	 * @return
	 */
	public List<PromotionDetail> getPromotionDetailsByProductId(
			String productId, String status);

	public void activePromotionDetail(String id);


	public List<PromotionDetail> getPromotionDetailsByPromotionIdWithoutStatus(
			String promotionId);
}
