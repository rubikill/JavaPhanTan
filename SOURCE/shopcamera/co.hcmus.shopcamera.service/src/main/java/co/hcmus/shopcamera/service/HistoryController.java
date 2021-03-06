package co.hcmus.shopcamera.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.hcmus.shopcamera.data.model.Cart;
import co.hcmus.shopcamera.data.model.History;
import co.hcmus.shopcamera.data.model.HistoryDetail;
import co.hcmus.shopcamera.data.model.PaymentType;
import co.hcmus.shopcamera.manager.IHistoryDetailService;
import co.hcmus.shopcamera.manager.IHistoryService;
import co.hcmus.shopcamera.manager.IPaymentTypeService;
import co.hcmus.shopcamera.utility.STATUS;
import co.hcmus.shopcamera.utility.Tools;

/**
 * History (order) controller
 * 
 * @author WindyZBoy
 * 
 */
@Controller
@Scope("request")
public class HistoryController {
	
	private static final Logger logger = LoggerFactory
	.getLogger(HistoryController.class);
	@Autowired
	private IHistoryService historyService;
	@Autowired
	private IHistoryDetailService historyDetailSevice;
	@Autowired
	private IPaymentTypeService paymentTypeService;

	ObjectMapper mapper = new ObjectMapper();

	/**
	 * ADMIN PAGE - Get all products of an order by its id
	 * @param request
	 * @param id
	 * @return 
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/orders/{id}", method = RequestMethod.GET)
	public String getHistoryDetails(HttpServletRequest request,
		@PathVariable String id) {
		List<HistoryDetail> listHistoryDetails = historyDetailSevice
		.getHistoryDetails();
		History history = historyService.getHistory(id);
		request.setAttribute("history", history);
		request.setAttribute("historyDetail", new HistoryDetail());
		request.setAttribute("listHistoryDetails", listHistoryDetails);
		request.setAttribute("nav", "orders");
		logger.info("Admin get histtoryDetails with Id : " + id);
		return "orders/detail";
	}

	/**
	 * ADMIN PAGE - Add new product into an order
	 * @param id
	 * @param historyDetail
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/orders/{id}/add", method = RequestMethod.POST)
	public String addProductHistoryDetails(@PathVariable String id,
		HistoryDetail historyDetail) {
		historyDetail.setId(null);
		historyDetail.setHistoryId(id);
		historyDetailSevice.addHistoryDetail(historyDetail);
		logger.info("Admin add HisttoryDetail with HistoryId : " + id);
		return "redirect:/admin/orders/" + id;
	}

	/**
	 * ADMIN PAGE - Edit a product in an order
	 * @param id
	 * @param historyDetail
	 * @return redirect to orders's home in admin page
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/orders/{id}/edit", method = RequestMethod.POST)
	public String editProductHistoryDetails(@PathVariable String id,
		HistoryDetail historyDetail) {
		historyDetailSevice.updateHistoryDetail(historyDetail);
		logger.info("Admin edit HisttoryDetail with Id : " + id);
		return "redirect:/admin/orders/" + id;
	}

	/**
	 * ADMIN PAGE - Active a product in an order
	 * @param id
	 * @param historyDetail
	 * @return redirect to orders's home in admin page
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/orders/{id}/active", method = RequestMethod.POST)
	public String setProductHistoryDetailsActive(@PathVariable String id,
		HistoryDetail historyDetail) {
		historyDetail = historyDetailSevice.getHistoryDetailById(historyDetail
			.getHistoryId());
		historyDetail.setStatus(STATUS.ACTIVE.getStatusCode());
		historyDetailSevice.updateHistoryDetail(historyDetail);
		logger.info("Admin active HisttoryDetail with Id : " + id);
		return "redirect:/admin/orders/" + id;
	}

	/**
	 * ADMIN PAGE - Deactive a product in an order
	 * @param id
	 * @param historyDetail
	 * @return redirect to orders's home in admin page 
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/orders/{id}/deactive", method = RequestMethod.POST)
	public String setProductHistoryDetailsDeactive(@PathVariable String id,
		HistoryDetail historyDetail) {
		historyDetail = historyDetailSevice.getHistoryDetailById(historyDetail
			.getHistoryId());
		historyDetail.setStatus(STATUS.INACTIVE.getStatusCode());
		historyDetailSevice.updateHistoryDetail(historyDetail);
		logger.info("Admin delete HisttoryDetail with Id : " + id);
		return "redirect:/admin/orders/" + id;
	}

	/**
	 * ADMIN PAGE - Show all orders
	 * @param request
	 * @return redirect to orders's home in admin page
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/orders", method = RequestMethod.GET)
	public String getHistory(HttpServletRequest request) {
		List<History> listHistory = historyService.getHistorys();
		List<PaymentType> listPaymentType = paymentTypeService
		.getPaymentTypes();
		request.setAttribute("history", new History());
		request.setAttribute("listHistory", listHistory);
		request.setAttribute("listPaymentType", listPaymentType);
		request.setAttribute("nav", "orders");
		logger.info("Admin get  all History ");
		return "orders";
	}

	/**
	 * ADMIN PAGE - Edit an orders
	 * @param history
	 * @return redirect to orders's home in admin page
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/orders/edit", method = RequestMethod.POST)
	public String editHistory(History history) {
		historyService.updateHistory(history);
		logger.info("Admin edit History with Id :"  + history.getId());
		return "redirect:/admin/orders";
	}

	/**
	 * ADMIN PAGE - Create an orders
	 * @param history
	 * @return redirect to orders's home in admin page
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/orders/create", method = RequestMethod.POST)
	public String addHistory(History history) {
		historyService.addHistory(history);
		logger.info("Admin create History ");
		return "redirect:/admin/orders";
	}

	/**
	 * ADMIN PAGE - Active an orders
	 * @param id
	 * @return redirect to orders's home in admin page
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/orders/active/{id}", method = RequestMethod.GET)
	public String activeHistory(@PathVariable String id) {
		History history = historyService.getHistory(id);
		history.setStatus(STATUS.ACTIVE.getStatusCode());
		historyService.updateHistory(history);
		logger.info("Admin active History with Id :"  + history.getId());
		return "redirect:/admin/orders";
	}

	/**
	 * ADMIN PAGE - Deactive an orders
	 * @param id
	 * @return redirect to orders's home in admin page
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/orders/deactive/{id}", method = RequestMethod.GET)
	public String deactiveHistory(@PathVariable String id) {
		History history = historyService.getHistory(id);
		history.setStatus(STATUS.INACTIVE.getStatusCode());
		historyService.updateHistory(history);
		logger.info("Admin deactive History with Id :"  + history.getId());
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
		logger.info("User create a history");
		List<Cart> cartItems = (List<Cart>) session.getAttribute("ShopCart");
		if (cartItems == null) {
			logger.error("Cart item failing...");
			return new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);
		}

		History history = null;
		try {
			String id = UUID.randomUUID().toString();

			int quantity = 0;
			float total = 0;
			for (Cart cart : cartItems) {
				quantity += cart.getCount();
				total += cart.getPrice() + cart.getPrice()*0.1 + cart.getCount()/100*cart.getPrice();
				HistoryDetail hd = new HistoryDetail(id, cart.getCount(),
					cart.getId(), STATUS.ACTIVE.getStatusCode());
				historyDetailSevice.addHistoryDetail(hd);
			}

			JsonNode jsonNode = mapper.readTree(json);
			SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy-MM-dd'T'hh:mm:ss.SSS'Z'");

			System.out.println(json);
			System.out.println(jsonNode.path("paymentDelivery").getTextValue());
			// parse payment date
			Date paymentDate = formatter.parse(jsonNode.path("paymentDate")
				.getTextValue());

			System.out.println(paymentDate);
			// parse deliver date
			Date deliveryDate = formatter.parse(jsonNode
				.path("paymentDelivery").getTextValue());

			System.out.println(deliveryDate);

			// String paymentStatus = jsonNode.path("paymentStatus")
			// .getTextValue();
			// Get email from session
			String email = (String) session.getAttribute("email");

			System.out.println(jsonNode);
			history = new History(email, quantity,
				STATUS.ACTIVE.getStatusCode(), null, new Date(),
				deliveryDate, paymentDate, null,total);

			history.setId(id);

			historyService.addHistory(history);

			logger.info("User create History success");
			session.removeAttribute("ShopCart");

		} catch (JsonProcessingException e) {
			logger.error("Error Create History JsonProcessingException : " + e.toString());
			e.printStackTrace();
			return new ResponseEntity<String>(Tools.toJson(history), headers,
				HttpStatus.BAD_REQUEST);
		} catch (IOException e) {
			logger.error("Error Create History IOException : " + e.toString());
			e.printStackTrace();
			return new ResponseEntity<String>(Tools.toJson(history), headers,
				HttpStatus.BAD_REQUEST);
		} catch (ParseException e) {
			logger.error("Error Create History ParseException : " + e.toString());
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
	
	@RequestMapping(value = "/history", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getHistorys(HttpSession session) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");

		String email = (String) session.getAttribute("email");
		List<History> listTemp = historyService.getHistorysByEmail(email);

		if (listTemp == null) {
			listTemp = new ArrayList<History>();
		}
		logger.info("Get All history");
		return new ResponseEntity<String>(Tools.toJsonArray(listTemp), headers,
			HttpStatus.OK);
	}

	/**
	 * Web service to cancel oder
	 * 
	 * @param json
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/history/cancel/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> updateCart(@PathVariable("id") String id,
		HttpSession session) {
		/*
		 * { "historyId":xxx, "cart": { ... } ","paymentId":... }
		 */
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		try{
			
			History history = historyService.getHistory(id);

			history.setStatus(STATUS.DISABLE.getStatusCode());
			logger.info("Cancel history scusses");
			historyService.updateHistory(history);

			return new ResponseEntity<String>(headers, HttpStatus.OK);
		} catch(Exception ex){
			logger.error("Error cancel history");
			return new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);
		}
	}

}
