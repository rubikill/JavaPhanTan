package co.hcmus.daos.Imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.hcmus.daos.IShopCartItemDAO;
import co.hcmus.models.Product;
import co.hcmus.models.ShopCartItem;

@Repository("shopCartItemDAO")
public class ShopCartItemDAO implements IShopCartItemDAO {

	@Override
	public int checkItemIsExits(List<ShopCartItem> listShopCartItem,
			Product product) {
		// TODO Auto-generated method stub
		for (int i = 0; i < listShopCartItem.size(); i++) {
			if (listShopCartItem.get(i).getId().equals(product.getId()))
				return i;
		}
		return -1;
	}

	@Override
	public List<ShopCartItem> addItemToCart(
			List<ShopCartItem> listShopCartItem, Product product) {
		// TODO Auto-generated method stub
		int index = checkItemIsExits(listShopCartItem, product);
		if (index == -1) {
			ShopCartItem item = new ShopCartItem(product);
			listShopCartItem.add(item);
		} else {
			int tempCount = listShopCartItem.get(index).getCount();
			tempCount++;
			listShopCartItem.get(index).setCount(tempCount);
		}
		return listShopCartItem;
	}

	@Override
	public List<ShopCartItem> deleteItem(List<ShopCartItem> listShopCartItem,
			Product product) {
		// TODO Auto-generated method stub
		int index = checkItemIsExits(listShopCartItem, product);
		if (index == -1) {
		} else {
		
			listShopCartItem.remove(index);
		}
		return listShopCartItem;
	}

}
