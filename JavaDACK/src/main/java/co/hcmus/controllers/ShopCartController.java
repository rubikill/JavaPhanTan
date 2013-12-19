package co.hcmus.controllers;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.hcmus.models.Cart;
import co.hcmus.models.Product;
import co.hcmus.services.IProductService;
import co.hcmus.services.IShopCartItemService;
import co.hcmus.util.Tools;

@Controller
@Scope("request")
public class ShopCartController {
	private static final Logger logger = LoggerFactory
			.getLogger(ShopCartController.class);
	@Autowired
	private IShopCartItemService shopCartItemService;

	@Autowired
	private IProductService productService;

	/**
	 * web service to add product to shopcart
	 * 
	 * @param id
	 *            id of product add to cart
	 * @param request
	 *            httpservlet request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/cart/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> addProductToCart(
			@PathVariable("id") String id, HttpSession session) {
		Product product = productService.getProductById(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		logger.info("Rest add product to cart");
		if (product == null) {
			logger.error("Error not found product");
			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
		} else {
			// get shop cart temp
			List<Cart> cartItems = (List<Cart>) session
					.getAttribute("ShopCart");

			if (cartItems == null) {
				cartItems = new ArrayList<Cart>();
			}

			// add product to shopcart
			cartItems = shopCartItemService.addItemToCart(cartItems, product);

			System.out.println("after add: " + cartItems.size());
			session.setAttribute("ShopCart", cartItems);
			logger.info("Add product to cart success with ProductId : " + product.getId());
			return new ResponseEntity<String>(Tools.toJsonArray(cartItems),
					headers, HttpStatus.OK);
		}
	}

	/**
	 * 
	 * web service to delete product from shop cart
	 * 
	 * @param id
	 *            id of product add to cart
	 * @param request
	 *            httpservlet request
	 * @return
	 */

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/cart/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<String> deleteFromCart(@PathVariable("id") String id,
			HttpSession session) {
		Product product = productService.getProductById(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		logger.info("Remove Product from cart");
		if (product == null) {
			logger.error("Error not found product");
			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
		} else {
			// List<Cart> listShopCartItem = new ArrayList<Cart>();
			List<Cart> cartItems = (List<Cart>) session
					.getAttribute("ShopCart");
			if (cartItems == null) {
				cartItems = new ArrayList<Cart>();
				return new ResponseEntity<String>(headers,
						HttpStatus.BAD_REQUEST);
			}
			cartItems = shopCartItemService.deleteItem(cartItems, product);
			session.setAttribute("ShopCart", cartItems);
			logger.info("Remove product from cart with ProductId : " + product.getId());
			return new ResponseEntity<String>(headers, HttpStatus.OK);
		}
	}

	/**
	 * 
	 * web service to show all product from shopcart
	 * 
	 * @param request
	 *            httpservlet request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getCarts(HttpServletRequest request) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		List<Cart> listTemp = (List<Cart>) request.getSession().getAttribute(
				"ShopCart");
		if (listTemp == null) {
			listTemp = new ArrayList<Cart>();
		}
		logger.info("Get cart");
		return new ResponseEntity<String>(Tools.toJsonArray(listTemp), headers,
				HttpStatus.OK);
	}

	/**
	 * web service to update cart
	 * 
	 * @param json
	 * @param session
	 * @return
	 */

	@RequestMapping(value = "/cart/updateCart", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<String> updateCart(@RequestBody String json,
			HttpSession session) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		
		// get cart from json
		try {
			List<Cart> listCartToUpdate = (List<Cart>) Tools.fromJsonToArray(json, Cart.class);
			
			System.out.println(listCartToUpdate.size());
			session.setAttribute("ShopCart", listCartToUpdate);
			logger.info("Update cart success");
			return new ResponseEntity<String>(headers, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error update cart unseccessfull");
		}
		return new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);
	}

}
