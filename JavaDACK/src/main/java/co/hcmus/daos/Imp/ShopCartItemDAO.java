package co.hcmus.daos.Imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import co.hcmus.daos.IShopCartItemDAO;
import co.hcmus.models.Product;
import co.hcmus.models.Cart;

@Repository("shopCartItemDAO")
public class ShopCartItemDAO implements IShopCartItemDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(ShopCartItemDAO.class);
	
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
