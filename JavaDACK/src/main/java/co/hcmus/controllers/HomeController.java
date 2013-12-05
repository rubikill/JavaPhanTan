package co.hcmus.controllers;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}

	@RequestMapping(value = "/compair", method = RequestMethod.GET)
	public String compair(Locale locale, Model model) {
		return "compair";
	}

	@RequestMapping(value = "/special_offer", method = RequestMethod.GET)
	public String special_offer(Locale locale, Model model) {
		return "special_offer";
	}

	@RequestMapping(value = "/tac", method = RequestMethod.GET)
	public String tac(Locale locale, Model model) {
		return "tac";
	}

}
