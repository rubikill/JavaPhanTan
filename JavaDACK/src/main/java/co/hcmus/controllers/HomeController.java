package co.hcmus.controllers;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.hcmus.models.ExchangeRate;
import co.hcmus.util.FetchDataFromOtherPage;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	
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
	public List<ExchangeRate> getExchangeRates() {
		return FetchDataFromOtherPage.getExchangeRate();
	}
	
}
