package co.hcmus.services.Imp;

import java.util.List;

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

	@Autowired
	private IShopCartItemDAO shopCartItemDAO;
	@Override
	public int checkItemIsExits(List<Cart> listShopCartItem,
			Product product) {
		// TODO Auto-generated method stub
		return shopCartItemDAO.checkItemIsExits(listShopCartItem, product);
	}

	@Override
	public List<Cart> addItemToCart(
			List<Cart> listShopCartItem, Product product) {
		// TODO Auto-generated method stub
		return shopCartItemDAO.addItemToCart(listShopCartItem, product);
	}

	@Override
	public List<Cart> deleteItem(List<Cart> listShopCartItem,
			Product product) {
		// TODO Auto-generated method stub
		return shopCartItemDAO.deleteItem(listShopCartItem, product);
	}

}