package co.hcmus.services;

import java.util.List;

import co.hcmus.models.Promotion;

public interface IPromotionService {
	public void addPromotion(Promotion promotion);

	public void updatePromotion(Promotion promotion);

	public Promotion getPromotionById(String id);

	public void deletePromotion(String id);

	public List<Promotion> getPromotions();
}
