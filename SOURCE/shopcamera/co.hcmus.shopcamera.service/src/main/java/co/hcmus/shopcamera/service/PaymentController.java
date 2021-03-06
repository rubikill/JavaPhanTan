package co.hcmus.shopcamera.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.hcmus.shopcamera.data.model.PaymentType;
import co.hcmus.shopcamera.manager.impl.PaymentTypeServiceMongo;
import co.hcmus.shopcamera.utility.STATUS;
import co.hcmus.shopcamera.utility.Tools;

/**
 * 
 * @author WindyZBoy
 * 
 */
@Controller
public class PaymentController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(PaymentController.class);
	@Autowired
	PaymentTypeServiceMongo paymentTypeService;

	/**
	 * ADMIN PAGE - get all payment type and render by return its name
	 * 
	 * @param request
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/paymenttype", method = RequestMethod.GET)
	public String getPaymentType(HttpServletRequest request) {
		prepairData(request);
		logger.info("Admin get all paymenttype");
		return "paymenttype";
	}

	/**
	 * ADMIN PAGE - add new payment type
	 * 
	 * @param paymentType
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/paymenttype/add", method = RequestMethod.POST)
	public String addPaymentType(PaymentType paymentType) {
		paymentTypeService.addPaymentType(paymentType);
		logger.info("Admin create PaymentType with name " + paymentType.getName());
		return "redirect:/admin/paymenttype";
	}

	/**
	 * ADMIN PAGE - Active a payment
	 * 
	 * @param id
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/paymenttype/active/{id}", method = RequestMethod.GET)
	public String activePaymentType(@PathVariable String id) {
		PaymentType paymentType = paymentTypeService.getPaymentTypeById(id);
		paymentType.setStatus(STATUS.ACTIVE.getStatusCode());
		paymentTypeService.updatePaymentType(paymentType);
		logger.info("Admin active PaymentType with Id " + id);
		return "redirect:/admin/paymenttype";
	}

	/**
	 * ADMIN PAGE - Deactive a payment
	 * 
	 * @param id
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/paymenttype/deactive/{id}", method = RequestMethod.GET)
	public String deactivePaymentType(@PathVariable String id) {
		PaymentType paymentType = paymentTypeService.getPaymentTypeById(id);
		paymentType.setStatus(STATUS.INACTIVE.getStatusCode());
		paymentTypeService.updatePaymentType(paymentType);
		logger.info("Admin deactive PaymentType with Id " + id);
		return "redirect:/admin/paymenttype";
	}

	/**
	 * ADMIN PAGE - Edit a payment
	 * 
	 * @param paymentType
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/paymenttype/edit", method = RequestMethod.POST)
	public String editPaymentType(PaymentType paymentType) {
		paymentTypeService.updatePaymentType(paymentType);
		logger.info("Admin edit PaymentType with Id " + paymentType.getId());
		return "redirect:/admin/paymenttype";
	}

	/**
	 * Prepair data for loading payment
	 * 
	 * @param request
	 */
	private void prepairData(HttpServletRequest request) {
		List<PaymentType> listPaymentType = paymentTypeService
				.getPaymentTypes();
		request.setAttribute("listPaymentType", listPaymentType);
		request.setAttribute("paymentType", new PaymentType());
		request.setAttribute("nav", "paymenttype");
	}

	/**
	 * Web service to get paymentTypeService
	 * 
	 * @return
	 */
	@RequestMapping(value = "/PaymentType", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getPaymentTypes() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		// get all product
		List<PaymentType> listPaymentType = paymentTypeService
				.getPaymentTypes();
		logger.info("Rest to get all PaymentType");
		return new ResponseEntity<String>(Tools.toJsonArray(listPaymentType),
				headers, HttpStatus.OK);
	}

}
