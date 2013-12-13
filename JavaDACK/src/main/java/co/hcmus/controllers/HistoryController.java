package co.hcmus.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.hcmus.models.Cart;
import co.hcmus.models.History;
import co.hcmus.services.IHistoryService;
import co.hcmus.util.Tools;

@Controller
@Scope("request")
public class HistoryController {
	@Autowired
	private IHistoryService historyService;
	
//	@SuppressWarnings("unchecked")
//	@RequestMapping(value = "/history/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
//	public ResponseEntity<String> addNewHistory(
//			@PathVariable("id") String id, HttpSession session) {
//		Product product = productService.getProductById(id);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Type", "application/json; charset=utf-8");
//		if (product == null) {
//			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
//		} else {
//			// get shop cart temp
//			List<Cart> cartItems = (List<Cart>) session
//					.getAttribute("ShopCart");
//
//			if (cartItems == null) {
//				cartItems = new ArrayList<Cart>();
//			}
//
//			// add product to shopcart
//			cartItems = shopCartItemService.addItemToCart(cartItems, product);
//
//			System.out.println("after add: " + cartItems.size());
//			session.setAttribute("ShopCart", cartItems);
//			return new ResponseEntity<String>(Tools.toJsonArray(cartItems), headers, HttpStatus.OK);
//		}
//	}
//
//	/**
//	 * 
//	 * web service to delete product from shop cart
//	 * 
//	 * @param id
//	 *            id of product add to cart
//	 * @param request
//	 *            httpservlet request
//	 * @return
//	 */
//
//	@SuppressWarnings("unchecked")
//	@RequestMapping(value = "/cart/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
//	public ResponseEntity<String> deleteFromHistory(@PathVariable("id") String id,
//			HttpSession session) {
//		Product product = productService.getProductById(id);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Type", "application/json; charset=utf-8");
//		if (product == null) {
//			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
//		} else {
//			// List<Cart> listShopCartItem = new ArrayList<Cart>();
//			List<Cart> cartItems = (List<Cart>) session
//					.getAttribute("ShopCart");
//			if (cartItems == null) {
//				cartItems = new ArrayList<Cart>();
//				return new ResponseEntity<String>("Cart is emty", headers,
//						HttpStatus.BAD_REQUEST);
//			}
//			cartItems = shopCartItemService.deleteItem(cartItems, product);
//			session.setAttribute("ShopCart", cartItems);
//			return new ResponseEntity<String>(Tools.toJsonArray(cartItems), headers, HttpStatus.OK);
//		}
//	}

	/**
	 * 
	 * Web service to show all history of a specific customer who has logun
	 * 
	 * @param request
	 *            httpservlet request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/history", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getHistorys(HttpServletRequest request) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		
		//TODO NEED TO CONFIRM THAT CUSTOMER HAS LOGON
		
		String email = (String) request.getSession().getAttribute("email");
		List<History> listTemp = historyService.getHistorysByEmail(email);
				
		if (listTemp == null) {
			listTemp = new ArrayList<History>();
		}
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
//	@SuppressWarnings("unchecked")
//	@RequestMapping(value = "/cart/updateCart", method = RequestMethod.PUT, headers = "Accept=application/json")
//	public ResponseEntity<String> updateCart(@RequestBody String json,
//			HttpSession session) {
//		// get cart from json
//		Cart cart = (Cart) Tools.fromJsonTo(json, Cart.class);
//		// get list cart item from session
//		List<Cart> listCartItems = (List<Cart>) session
//				.getAttribute("ShopCart");
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Type", "application/json; charset=utf-8");
//		// check if list cart item is null
//		if (listCartItems == null) {
//			listCartItems = new ArrayList<Cart>();
//			return new ResponseEntity<String>(Tools.toJsonArray(listCartItems),
//					headers, HttpStatus.BAD_REQUEST);
//		} else {
//			for (Cart c : listCartItems) {
//				if (c.getId().equals(cart.getId())) {
//					c.setCount(cart.getCount());
//				}
//			}
//			session.setAttribute("ShopCart", listCartItems);
//			return new ResponseEntity<String>(Tools.toJsonArray(listCartItems),
//					headers, HttpStatus.OK);
//		}
//	}

}
