package co.hcmus.daos;

import java.util.List;

import co.hcmus.models.Promotion;

/**
 * 
 * @author Thanh Toan
 * 
 */
public interface IPromotionDAO {
	/**
	 * 
	 * @param promotion
	 */
	public void addPromotion(Promotion promotion);

	/**
	 * 
	 * @param promotion
	 */
	public void updatePromotion(Promotion promotion);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Promotion getPromotionById(String id);

	/**
	 * 
	 * @param id
	 */
	public void deletePromotion(String id);

	/**
	 * 
	 * @return
	 */
	public List<Promotion> getPromotions();
}
