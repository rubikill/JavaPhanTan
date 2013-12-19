package co.hcmus.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	// @Autowired
	// private ImageServiceMongo imageService;

	// private Manufacturer
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		// productService.saveImage("52a60af5dcac3f217a062f8d",
		// "E:\\DropBox\\Java + LTHD\\DACK\\RESOURCE\\Resource\\1_detail.jpg");
		// productService.writeImage("52a60af5dcac3f217a062f8d", "abcdbab.jpg");

		request.setAttribute("nav", "home");
		return "home";
	}

}
