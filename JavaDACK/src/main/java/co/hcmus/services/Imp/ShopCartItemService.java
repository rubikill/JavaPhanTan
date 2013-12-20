package co.hcmus.services.Imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IShopCartItemDAO;
import co.hcmus.models.Product;
import co.hcmus.models.Cart;
import co.hcmus.services.IShopCartItemService;



@Service("shopCartItemService")
@Transactional
public class ShopCartItemService implements IShopCartItemService {

	private static final Logger logger = LoggerFactory
			.getLogger(ShopCartItemService.class);

	
	@Autowired
	private IShopCartItemDAO shopCartItemDAO;
	@Override
	public int checkItemIsExits(List<Cart> listShopCartItem,
			Product product) {
		// TODO Auto-generated method stub
		logger.info("ShopCartItemService check product is Exist in Cart with productId : " + product.getId());
		return shopCartItemDAO.checkItemIsExits(listShopCartItem, product);
	}

	@Override
	public List<Cart> addItemToCart(
			List<Cart> listShopCartItem, Product product) {
		// TODO Auto-generated method stub
		logger.info("ShopCartItemService add product to Cart with productId : " + product.getId());
		return shopCartItemDAO.addItemToCart(listShopCartItem, product);
	}

	@Override
	public List<Cart> deleteItem(List<Cart> listShopCartItem,
			Product product) {
		// TODO Auto-generated method stub
		logger.info("ShopCartItemService delete product from Cart with productId : " + product.getId());
		return shopCartItemDAO.deleteItem(listShopCartItem, product);
	}

}
