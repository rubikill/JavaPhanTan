package co.hcmus.daos;

import java.util.List;

import co.hcmus.models.Product;
import co.hcmus.models.Cart;

/**
 * 
 * @author Thanh Toan
 * 
 */
public interface IShopCartItemDAO {

	/**
	 * check item is exits in cart
	 * 
	 * @param listShopCartItem
	 * @param product
	 * @return
	 */
	public int checkItemIsExits(List<Cart> listShopCartItem, Product product);

	/**
	 * add item to cart, return true if item is exits , and false if not
	 * 
	 * @param listShopCartItem
	 * @param product
	 * @return
	 */
	public List<Cart> addItemToCart(List<Cart> listShopCartItem, Product product);

	/**
	 * delete item
	 * 
	 * @param listShopCartItem
	 * @param product
	 * @return
	 */
	public List<Cart> deleteItem(List<Cart> listShopCartItem, Product product);
}
