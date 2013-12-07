package co.hcmus.controllers;

import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.hcmus.models.Account;
import co.hcmus.services.Imp.AccountServiceMongo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AccountController {
	@Autowired
	private AccountServiceMongo accountService;
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		return "register";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "login";
	}
	
	
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact(Locale locale, Model model) {
		return "contact";
	}
	
	@RequestMapping(value = "/forgetpass", method = RequestMethod.GET)
	public String forgetpass(Locale locale, Model model) {
		return "forgetpass";
	}
	
	
	//---------------TEST---------------------
	//----------Uncomment in file tile.xml to run this one------------
//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	public String test(Locale locale, Model model) {
//		Account account = new Account("qbcd@asd.com", "abcdw", "099900", "address", new Date(), "0", "password", "status", "token", 0);
//		accountService.addAccount(account);
//		String email = accountService.getAccount("qbcd@asd.com").getEmail();
//		model.addAttribute("email", email);
//		return "test";
//	}
}
