package co.hcmus.services;

import java.util.List;

import co.hcmus.models.Product;
import co.hcmus.models.ShopCartItem;

public interface IShopCartItemService {
	// check item is exits in cart
	public int checkItemIsExits(List<ShopCartItem> listShopCartItem,
			Product product);

	// add item to cart, return true if item is exits , and false if not
	public List<ShopCartItem> addItemToCart(
			List<ShopCartItem> listShopCartItem, Product product);
	//delete item 
	public List<ShopCartItem> deleteItem(List<ShopCartItem> listShopCartItem,
			Product product);
}
