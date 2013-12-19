package co.hcmus.controllers;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.hcmus.models.Cart;
import co.hcmus.models.History;
import co.hcmus.models.HistoryDetail;
import co.hcmus.models.PaymentType;
import co.hcmus.services.IHistoryDetailService;
import co.hcmus.services.IHistoryService;
import co.hcmus.services.IPaymentTypeService;
import co.hcmus.util.STATUS;
import co.hcmus.util.Tools;

@Controller
@Scope("request")
public class HistoryController {
	@Autowired
	private IHistoryService historyService;
	@Autowired
	private IHistoryDetailService historyDetailSevice;
	@Autowired
	private IPaymentTypeService paymentTypeService;

	ObjectMapper mapper = new ObjectMapper();
	
	/**
	 * ADMIN PAGE - Show all orders
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/orders", method = RequestMethod.GET)
	public String getProducType(Locale locale, Model model,
			HttpServletRequest request) {
		List<History> listHistory = historyService.getHistorys();
		List<PaymentType> listPaymentType = paymentTypeService.getPaymentTypes();
		request.setAttribute("history", new History());
		request.setAttribute("listHistory", listHistory);
		request.setAttribute("listPaymentType", listPaymentType);
		request.setAttribute("nav", "orders");
		return "orders";
	}

	@RequestMapping(value = "/admin/orders/add", method = RequestMethod.POST)
	public String addProducType(Locale locale, Model model,
			HttpServletRequest request, History history) {
		historyService.addHistory(history);
		request.setAttribute("nav", "orders");
		return "redirect:/admin/orders";
	}
	
	@RequestMapping(value = "/admin/orders/active", method = RequestMethod.POST)
	public String activeProducType(Locale locale, Model model,
			HttpServletRequest request, History history) {
		history.setStatus(STATUS.ACTIVE.getStatusCode());
		historyService.updateHistory(history);
		request.setAttribute("nav", "orders");
		return "redirect:/admin/orders";
	}
	
	@RequestMapping(value = "/admin/orders/deactive", method = RequestMethod.POST)
	public String deactiveProducType(Locale locale, Model model,
			HttpServletRequest request, History history) {
		history.setStatus(STATUS.INACTIVE.getStatusCode());
		historyService.updateHistory(history);
		request.setAttribute("nav", "orders");
		return "redirect:/admin/orders";
	}
	
	/**
	 * Web service to create new history from cart
	 * 
	 * @param session
	 * @param json
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/history/create", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> addNewHistory(HttpSession session,
			@RequestBody String json) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		
		// TODO CHECK IF CUSTOMER IS LOGON
		List<Cart> cartItems = (List<Cart>) session
					.getAttribute("ShopCart");
		if (cartItems == null) {
			return new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);
		}
		
		History history = null;
		try {
			String id = UUID.randomUUID().toString();
			
			int quantity = 0;

			for(Cart cart : cartItems){
				quantity += cart.getCount();
				HistoryDetail hd = new HistoryDetail(id, cart.getCount(),
						cart.getId(), STATUS.ACTIVE.getStatusCode());
				historyDetailSevice.addHistoryDetail(hd);
			}

			JsonNode jsonNode = mapper.readTree(json);
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd'T'hh:mm:ss.SSS'Z'");

			System.out.println(json);
			System.out.println(jsonNode.path("paymentDelivery")
					.getTextValue());
			// parse payment date
			Date paymentDate = formatter.parse(jsonNode.path("paymentDate")
					.getTextValue());
			
			System.out.println(paymentDate);
			// parse deliver date
			Date deliveryDate = formatter.parse(jsonNode
					.path("paymentDelivery").getTextValue());
			
			System.out.println(deliveryDate);

			// String paymentStatus = jsonNode.path("paymentStatus")
			// 		.getTextValue();
			// Get email from session
			String email = (String) session.getAttribute("email");

			
			System.out.println(jsonNode);
			history = new History(email, quantity, STATUS.ACTIVE.getStatusCode(),
					null, new Date(), deliveryDate, paymentDate,
					null);

			history.setId(id);

			historyService.addHistory(history);

			System.out.println("create history success");
			session.removeAttribute("ShopCart");

		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(Tools.toJson(history), headers,
					HttpStatus.BAD_REQUEST);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(Tools.toJson(history), headers,
					HttpStatus.BAD_REQUEST);
		} catch (ParseException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(Tools.toJson(history), headers,
					HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>(Tools.toJson(history), headers,
				HttpStatus.OK);
	}

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
	public ResponseEntity<String> getHistorys(HttpSession session) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");

		// TODO NEED TO CONFIRM THAT CUSTOMER HAS LOGON

		String email = (String) session.getAttribute("email");
		List<History> listTemp = historyService.getHistorysByEmail(email);

		if (listTemp == null) {
			listTemp = new ArrayList<History>();
		}
		return new ResponseEntity<String>(Tools.toJsonArray(listTemp), headers,
				HttpStatus.OK);
	}

	/**
	 * Web service to update history
	 * 
	 * @param json
	 * @param session
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/history/update", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<String> updateCart(@RequestBody String json,
			HttpSession session) {
		/*
		 * { "historyId":xxx, "cart": { ... } ","paymentId":... }
		 */
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		History history = new History();
		ObjectMapper mapper = new ObjectMapper();
		try {
			String id = (String) session.getAttribute("historyId");
			// parse json String to jsonNode
			JsonNode jsonNode = mapper.readTree(json);
			// get list cart item from json
			List<Cart> listCartToUpdate = (List<Cart>) Tools.fromJsonToArray(
					jsonNode.getPath("cart").getTextValue(), Cart.class);
			int quantity = 0;
			for (int i = 0; i < listCartToUpdate.size(); i++) {
				Cart cart = listCartToUpdate.get(i);
				quantity += cart.getCount();
				HistoryDetail hd = new HistoryDetail(id, cart.getCount(),
						cart.getId(), STATUS.ACTIVE.getStatusCode());
				historyDetailSevice.updateHistoryDetail(hd);
			}

			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			// parse payment date
			Date paymentDate = formatter.parse(jsonNode.path("paymentDate")
					.getTextValue());
			// parse deliver date
			Date deliveryDate = formatter.parse(jsonNode
					.path("paymentDelivery").getTextValue());
			// parse paymentTypeId
			String paymentTypeID = jsonNode.path("paymentTypeId")
					.getTextValue();
			// parse paymentStatus
			String paymentStatus = jsonNode.path("paymentStatus")
					.getTextValue();
			// Get email from session
			String email = (String) session.getAttribute("email");

			history = new History(email, quantity, STATUS.ACTIVE.getStatusCode(),
					paymentStatus, new Date(), deliveryDate, paymentDate,
					paymentTypeID);

			history.setId(id);

			historyService.updateHistory(history);

			session.setAttribute("ShopCart", listCartToUpdate);

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>(Tools.toJson(history), headers,
				HttpStatus.OK);

	}

}
