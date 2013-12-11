package co.hcmus.controllers;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.hcmus.models.Account;
import co.hcmus.services.IAccountService;
import co.hcmus.util.Tools;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AccountController {
	@Autowired
	private IAccountService accountService;

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

	/**
	 * Login
	 * 
	 * @param json
	 *            contain email and password
	 * @return Result
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestBody String json) {
		Account accountTemp = Tools.fromJsonTo(json, Account.class);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		// Create AccountService
		// get Account with email
		Account account = accountService.getAccount(accountTemp.getEmail());

		// check account
		if (account == null) {
			return new ResponseEntity<String>("Account does not exsits", headers, HttpStatus.BAD_REQUEST);
		} else {
			if (account.getPassword().equals(accountTemp.getPassword())) {
				System.out.println("Login success");
				//session.putValue("email", account.getEmail());
				return new ResponseEntity<String>(headers, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Wrong password", headers,
						HttpStatus.BAD_REQUEST);
			}
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody String json) {
		Account account = Tools.fromJsonTo(json, Account.class);

		// verify account infomation here
		// ...

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html");
		// Create AccountService
		// get Account with email

		// check account
		if (accountService.getAccount(account.getEmail()) == null) {
			try {
				accountService.addAccount(account);				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Problem when create account");
				e.printStackTrace();
			}
			return new ResponseEntity<String>("Create success", headers,
					HttpStatus.OK);
		}
		return new ResponseEntity<String>("Create failure", headers,
				HttpStatus.BAD_REQUEST);
	}

	// ---------------TEST---------------------
	// ----------Uncomment in file tile.xml to run this one------------
	// @RequestMapping(value = "/test", method = RequestMethod.GET)
	// public String test(Locale locale, Model model) {
	// Account account = new Account("qbcd@asd.com", "abcdw", "099900",
	// "address", new Date(), "0", "password", "status", "token", 0);
	// accountService.addAccount(account);
	// String email = accountService.getAccount("qbcd@asd.com").getEmail();
	// model.addAttribute("email", email);
	// return "test";
	// }
}
