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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.hcmus.models.PaymentType;
import co.hcmus.services.Imp.PaymentTypeServiceMongo;
import co.hcmus.util.Tools;

@Controller
public class PaymentController {
	@Autowired
	PaymentTypeServiceMongo paymentTypeService;

	@RequestMapping(value = "/admin/paymenttype", method = RequestMethod.GET)
	public String getPaymentType(Locale locale, Model model,
			HttpServletRequest request) {
		prepairData(request);
		System.out.println("PAYMENT SHOW!");
		return "paymenttype";
	}

	@RequestMapping(value = "/admin/paymenttype/add", method = RequestMethod.POST)
	public String addPaymentType(Locale locale, Model model,
			HttpServletRequest request) {
		request.setAttribute("nav", "paymenttype");
		return "redirect:/admin/paymenttype";
	}

	@RequestMapping(value = "/admin/paymenttype/active", method = RequestMethod.GET)
	public String activePaymentType(Locale locale, Model model,
			HttpServletRequest request) {
		request.setAttribute("nav", "paymenttype");
		return "redirect:/admin/paymenttype";
	}

	@RequestMapping(value = "/admin/paymenttype/deactive", method = RequestMethod.GET)
	public String deactivePaymentType(Locale locale, Model model,
			HttpServletRequest request) {
		request.setAttribute("nav", "paymenttype");
		return "redirect:/admin/paymenttype";
	}

	@RequestMapping(value = "/admin/paymenttype/edit", method = RequestMethod.POST)
	public String editPaymentType(Model model, HttpServletRequest request) {
		request.setAttribute("nav", "paymenttype");
		return "redirect:/admin/paymenttype";
	}

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
