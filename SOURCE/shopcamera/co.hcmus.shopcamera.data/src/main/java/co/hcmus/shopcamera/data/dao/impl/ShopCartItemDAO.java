package co.hcmus.shopcamera.data.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import co.hcmus.shopcamera.data.dao.IShopCartItemDAO;
import co.hcmus.shopcamera.data.model.Cart;
import co.hcmus.shopcamera.data.model.Product;
import co.hcmus.shopcamera.data.model.PromotionDetail;
import co.hcmus.shopcamera.utility.STATUS;

@Repository("shopCartItemDAO")
public class ShopCartItemDAO implements IShopCartItemDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(ShopCartItemDAO.class);
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public int checkItemIsExits(List<Cart> listShopCartItem,
			Product product) {
		logger.info("ShopCartItemDAO checkItem with ProductId : " + product.getId());
		// TODO Auto-generated method stub
		for (int i = 0; i < listShopCartItem.size(); i++) {
			if (listShopCartItem.get(i).getId().equals(product.getId()))
			{
				logger.info("ShopCartItemDAO checkItem  : Item in cart");
				return i;
			}
		}
		logger.info("ShopCartItemDAO checkItem  : Item not in cart");
		return -1;
	}

	@Override
	public List<Cart> addItemToCart(
			List<Cart> listShopCartItem, Product product) {
		// TODO Auto-generated method stub
		logger.info("ShopCartItemDAO add item to cart with ProductId : " + product.getId());
		int index = checkItemIsExits(listShopCartItem, product);
		if (index == -1) {
			Cart item = new Cart(product);
			Query searchPromotionDetailByProductId = new Query(Criteria
					.where("productId").is(product.getId()).and("status").is(STATUS.ACTIVE.getStatusCode()));
			List<PromotionDetail> getPromotionDetailsByProductId = mongoTemplate.find(searchPromotionDetailByProductId,
					PromotionDetail.class, "promotionDetail");
			int max = 0;
			
			if (getPromotionDetailsByProductId.size() ==0 )
				System.out.println("NULLLLLLLLLLL");
			for (int i = 0; i < getPromotionDetailsByProductId.size(); i++){
				if (getPromotionDetailsByProductId.get(i).getDiscount() > max)
					max = getPromotionDetailsByProductId.get(i).getDiscount();
			}
			item.setDiscount(max);
			listShopCartItem.add(item);
		} else {
			int tempCount = listShopCartItem.get(index).getCount();
			tempCount++;
			listShopCartItem.get(index).setCount(tempCount);
		}
		return listShopCartItem;
	}

	@Override
	public List<Cart> deleteItem(List<Cart> listShopCartItem,
			Product product) {
		logger.info("ShopCartItemDAO delete item from cart with ProductId : " + product.getId());
		// TODO Auto-generated method stub
		int index = checkItemIsExits(listShopCartItem, product);
		if (index == -1) {
		} else {
		
			listShopCartItem.remove(index);
		}
		return listShopCartItem;
	}

}
