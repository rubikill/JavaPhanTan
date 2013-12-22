package co.hcmus.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {


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

	
}
