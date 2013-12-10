package co.hcmus.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.hcmus.models.Product;
import co.hcmus.models.ShopCartItem;
import co.hcmus.services.IProductService;
import co.hcmus.services.IShopCartItemService;
import co.hcmus.util.Tools;

@Controller
public class ShopCartController {

	@Autowired
	private IShopCartItemService shopCartItemService;
	@Autowired
	private IProductService productService;

	@RequestMapping(value = "/cart/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> addProductToCart(
			@PathVariable("id") String id, HttpServletRequest request) {
		Product product = productService.getProductById(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		if (product == null) {
			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
		} else {
			List<ShopCartItem> listShopCartItem = new ArrayList<ShopCartItem>();
			List<ShopCartItem> listTemp = (List<ShopCartItem>) request
					.getSession().getAttribute("ShopCart");
			if (listTemp == null) {
				listTemp = new ArrayList<ShopCartItem>();
			}
			listShopCartItem = shopCartItemService.addItemToCart(listTemp,
					product);
			request.getSession().setAttribute("ShopCart", listShopCartItem);
			return new ResponseEntity<String>(headers, HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/cart/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<String> deleteFromCart(@PathVariable("id") String id,
			HttpServletRequest request) {
		Product product = productService.getProductById(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		if (product == null) {
			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
		} else {
			List<ShopCartItem> listShopCartItem = new ArrayList<ShopCartItem>();
			List<ShopCartItem> listTemp = (List<ShopCartItem>) request
					.getSession().getAttribute("ShopCart");
			if (listTemp == null) {
				listTemp = new ArrayList<ShopCartItem>();
			}
			listShopCartItem = shopCartItemService
					.deleteItem(listTemp, product);
			request.getSession().setAttribute("ShopCart", listShopCartItem);
			return new ResponseEntity<String>(headers, HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getCarts(HttpServletRequest request) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		List<ShopCartItem> listTemp = (List<ShopCartItem>) request.getSession()
				.getAttribute("ShopCart");
		if (listTemp == null) {
			listTemp = new ArrayList<ShopCartItem>();
		}
		return new ResponseEntity<String>(Tools.toJsonArray(listTemp), headers,
				HttpStatus.OK);
	}

}
