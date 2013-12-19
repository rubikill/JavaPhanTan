package co.hcmus.controllers;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.hcmus.models.PaymentType;
import co.hcmus.services.Imp.PaymentTypeServiceMongo;
import co.hcmus.util.STATUS;
import co.hcmus.util.Tools;

@Controller
public class PaymentController {
	@Autowired
	PaymentTypeServiceMongo paymentTypeService;

	/**
	 * ADMIN PAGE - get all payment type
	 * @param locale
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/paymenttype", method = RequestMethod.GET)
	public String getPaymentType(Locale locale, Model model,
			HttpServletRequest request) {
		prepairData(request);
		return "paymenttype";
	}

	/**
	 * ADMIN PAGE - add new payment type
	 * @param locale
	 * @param model
	 * @param request
	 * @param paymentType
	 * @return
	 */
	@RequestMapping(value = "/admin/paymenttype/add", method = RequestMethod.POST)
	public String addPaymentType(Locale locale, Model model,
			HttpServletRequest request, PaymentType paymentType) {
		paymentTypeService.addPaymentType(paymentType);
		request.setAttribute("nav", "paymenttype");
		return "redirect:/admin/paymenttype";
	}

	/**
	 * ADMIN PAGE - Active a payment
	 * @param locale
	 * @param model
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/admin/paymenttype/active/{id}", method = RequestMethod.GET)
	public String activePaymentType(Locale locale, Model model,
			HttpServletRequest request, @PathVariable String id) {
		PaymentType paymentType = paymentTypeService.getPaymentTypeById(id);
		paymentType.setStatus(STATUS.ACTIVE.getStatusCode());
		paymentTypeService.updatePaymentType(paymentType);
		request.setAttribute("nav", "paymenttype");
		return "redirect:/admin/paymenttype";
	}

	/**
	 * ADMIN PAGE - Deactive a payment
	 * @param locale
	 * @param model
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/admin/paymenttype/deactive/{id}", method = RequestMethod.GET)
	public String deactivePaymentType(Locale locale, Model model,
			HttpServletRequest request, @PathVariable String id) {
		PaymentType paymentType = paymentTypeService.getPaymentTypeById(id);
		paymentType.setStatus(STATUS.INACTIVE.getStatusCode());
		paymentTypeService.updatePaymentType(paymentType);
		request.setAttribute("nav", "paymenttype");
		return "redirect:/admin/paymenttype";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param paymentType
	 * @return
	 */
	@RequestMapping(value = "/admin/paymenttype/edit", method = RequestMethod.POST)
	public String editPaymentType(Model model, HttpServletRequest request,
			PaymentType paymentType) {
		paymentTypeService.updatePaymentType(paymentType);
		System.out.println("id: " + paymentType.getId());
		System.out.println("name: " + paymentType.getName());
		System.out.println("status: " + paymentType.getStatus());
		
		
		request.setAttribute("nav", "paymenttype");
		return "redirect:/admin/paymenttype";
	}

	/**
	 * Prepair data for loading payment
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
		return new ResponseEntity<String>(Tools.toJsonArray(listPaymentType),
				headers, HttpStatus.OK);
	}

}
