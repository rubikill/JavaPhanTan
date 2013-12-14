package co.hcmus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
	
	/**
	 * Web service to get paymentTypeService
	 * @return
	 */
	@RequestMapping(value = "/PaymentType", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getPaymentTypes() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		// get all product
		List<PaymentType> listPaymentType = paymentTypeService.getPaymentTypes();
		return new ResponseEntity<String>(Tools.toJsonArray(listPaymentType), headers,
			HttpStatus.OK);
	}
	
}
