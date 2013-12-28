package co.hcmus.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.hcmus.models.ExchangeRate;
import co.hcmus.util.FetchDataFromOtherPage;
import co.hcmus.util.Tools;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(ProductController.class);
	
	// private Manufacturer
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		System.out.println("AT HOME CONTROLLER");
		request.setAttribute("nav", "home");
		return "home";
	}

	 
	@RequestMapping(value = "/admin/denied", method = RequestMethod.GET)
	public String denied(HttpServletRequest request) {
		System.out.println("AT DENIED CONTROLLER");
		return "denied";
	}

	
	@RequestMapping(value = "/exchangerate", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getProducts() {

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		// get all product
		List<ExchangeRate> result = FetchDataFromOtherPage.getExchangeRate();
		logger.info("Rest to get all Products");
		return new ResponseEntity<String>(Tools.toJsonArray(result), headers,
				HttpStatus.OK);
	}
	
}
