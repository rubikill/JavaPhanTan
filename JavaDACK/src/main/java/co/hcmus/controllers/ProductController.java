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
public class ProductController {
	@RequestMapping(value = "/product_details", method = RequestMethod.GET)
	public String product_details(Locale locale, Model model) {
		return "product_details";
	}

	@RequestMapping(value = "/product_summary", method = RequestMethod.GET)
	public String product_summary(Locale locale, Model model) {
		return "product_summary";
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String products(Locale locale, Model model) {
		return "products";
	}
}
