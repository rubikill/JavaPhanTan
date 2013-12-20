package co.hcmus.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.hcmus.helpers.SendMailHelper;
import co.hcmus.models.Account;
import co.hcmus.models.AccountType;
import co.hcmus.models.EmailForm;
import co.hcmus.provider.EncryptProvider;
import co.hcmus.services.IAccountService;
import co.hcmus.services.IAccountTypeService;
import co.hcmus.util.Constant;
import co.hcmus.util.STATUS;
import co.hcmus.util.Tools;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private IAccountService accountService;

	@Autowired
	private IAccountTypeService accountTypeService;

	/**
	 * ADMIN PAGE - Controller to mapping admin page - MANAGE ACCOUNT
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/account", method = RequestMethod.GET)
	public String accounts(HttpServletRequest request) {
		prepairData(request);
		return "accounts";
	}

	/**
	 * ADMIN PAGE - Deactive an account
	 * 
	 * @param account
	 * @return
	 */
	@RequestMapping(value = "/admin/account/block", method = RequestMethod.POST)
	public String blockPromotion(Account account) {
		account = accountService.getAccount(account.getEmail());
		account.setStatus(STATUS.INACTIVE.getStatusCode());
		accountService.updateAccount(account);
		return "redirect:/admin/accounts";
	}

	/**
	 * ADMIN PAGE - Active an account
	 * @param account
	 * @return
	 */
	@RequestMapping(value = "/admin/account/active", method = RequestMethod.POST)
	public String activePromotion(Account account) {
		account = accountService.getAccount(account.getEmail());
		account.setStatus(STATUS.ACTIVE.getStatusCode());
		accountService.updateAccount(account);
		return "redirect:/admin/accounts";
	}

	/**
	 * ADMIN PAGE - Edit an account passing from MANAGE ACCOUNT
	 * @param account
	 * @return
	 */
	@RequestMapping(value = "/admin/account/edit", method = RequestMethod.POST)
	public String editAccount(Account account) {
		// TODO add MD5 hash password
		accountService.updateAccount(account);
		return "redirect:/admin/accounts";
	}

	/**
	 * ADMIN PAGE - Create new account
	 * @param account
	 * @return
	 */
	@RequestMapping(value = "/admin/account/create", method = RequestMethod.POST)
	public String createAccount(Account account) {
		// TODO add MD5 hash password
		accountService.addAccount(account);
		return "redirect:/admin/accounts";
	}

	@RequestMapping(value = "/admin/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model, HttpServletRequest request) {
		return "login";
	}

	@RequestMapping(value = "/admin/forgotpass", method = RequestMethod.GET)
	public String forgotpass(Locale locale, Model model,
			HttpServletRequest request) {
		return "forgotpass";
	}

	/**
	 * ADMIN PAGE - Prepair data for loading
	 * 
	 * @param request
	 */
	private void prepairData(HttpServletRequest request) {
		List<Account> listAccount = accountService.getAccounts();
		List<AccountType> listAccountType = accountTypeService
				.getAccountTypes();
		Account account = new Account();
		request.setAttribute("account", account);
		request.setAttribute("listAccountType", listAccountType);
		request.setAttribute("listAccount", listAccount);
		request.setAttribute("nav", "account");
	}

	// @RequestMapping(value = "/register", method = RequestMethod.GET)
	// public String register(Locale locale, Model model) {
	// return "register";
	// }

	// @RequestMapping(value = "/login", method = RequestMethod.GET)
	// public String login(Locale locale, Model model) {
	// return "login";
	// }

	// @RequestMapping(value = "/contact", method = RequestMethod.GET)
	// public String contact(Locale locale, Model model) {
	// return "contact";
	// }

	// @RequestMapping(value = "/forgetpass", method = RequestMethod.GET)
	// public String forgetpass(Locale locale, Model model) {
	// return "forgetpass";
	// }

	@Autowired
	EncryptProvider encryptPasswordProvider;

	@Autowired
	SendMailHelper sendMailHelper;

	/**
	 * Login
	 * 
	 * @param json
	 *            contain email and password
	 * @return Result
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestBody String json,
			HttpSession session) {
		Account accountTemp = Tools.fromJsonTo(json, Account.class);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		// Create AccountService
		// get Account with email

		Account account = accountService.getAccount(accountTemp.getEmail());

		// check account
		if (account == null) {
			return new ResponseEntity<String>("Account does not exsits",
					headers, HttpStatus.BAD_REQUEST);
		} else {
			if (encryptPasswordProvider.checkSum(accountTemp.getPassword(),
					account.getPassword(), Constant.MD5)) {
				System.out.println("Login success");
				session.setAttribute("email", account.getEmail());
				return new ResponseEntity<String>(Tools.toJson(account),
						headers, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Wrong password", headers,
						HttpStatus.BAD_REQUEST);
			}
		}
	}

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public ResponseEntity<String> ping(HttpSession session) {
		if (session.getAttribute("email") == null) {
			logger.error("ping failure...");
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
		} else {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json");
			Account account = accountService.getAccount(session.getAttribute(
					"email").toString());
			logger.error("ping success...");
			return new ResponseEntity<String>(Tools.toJson(account), headers,
					HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ResponseEntity<String> logout(HttpSession session) {
		session.removeAttribute("email");
		logger.info("logout...");
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	ObjectMapper mapper = new ObjectMapper();

	/**
	 * Register
	 * 
	 * @param json
	 *            Account information
	 * @return Result
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody String json) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/plain");

		// parse json String to jsonNode
		Account account = new Account();
		try {
			JsonNode jsonNode = mapper.readTree(json);
			account.setEmail(jsonNode.path("email").getTextValue());

			if (accountService.getAccount(account.getEmail()) != null) {
				return new ResponseEntity<String>(
						"{\"message\" : \"This email has been used\"}",
						headers, HttpStatus.BAD_REQUEST);
			}

			account.setName(jsonNode.path("name").getTextValue());
			account.setBirthday(Tools.formatDate(jsonNode.path("birthday")
					.getTextValue(), Constant.ISO_FORMAT_DATETME));
			account.setPassword(encryptPasswordProvider.hash(
					jsonNode.path("password").getTextValue(), Constant.MD5)
					.toString());
			account.setAddress(jsonNode.path("address").getTextValue());
			account.setPhone(jsonNode.path("phone").getTextValue());

		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Gen Token here
		String token = UUID.randomUUID().toString();
		account.setToken(token);
		// Set accout type here

		// Set status
		account.setStatus(STATUS.INACTIVE.getStatusCode());

		try {
			accountService.addAccount(account);

			EmailForm emailForm = new EmailForm();
			emailForm.reciver = account.getEmail();
			emailForm.subject = "Welcome to Camera Shop";
			emailForm.body = "Your new password is: " + token;

			sendMailHelper.sendMail(emailForm);

			return new ResponseEntity<String>(
					"{\"message\" : \"Create success\"}", headers,
					HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println("Problem when create account");
			e.printStackTrace();
			return new ResponseEntity<String>(
					"{\"message\" : \"Problem when create account\"}", headers,
					HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Register
	 * 
	 * @param json
	 *            Account information
	 * @return Result
	 */
	@RequestMapping(value = "/forgetpass", method = RequestMethod.POST)
	public ResponseEntity<String> forgetPassword(@RequestBody String json) {
		// Recive a email address here
		String email = json;

		// Account account = accountService.getAccount(json);

		// Do reset pass here

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");

		EmailForm emailForm = new EmailForm();
		emailForm.reciver = email;
		emailForm.subject = "Reset password for " + email;
		emailForm.body = "Your new password is: " + "xxxxxxxxx";

		// Send a email to reset password
		try {
			sendMailHelper.sendMail(emailForm);

			return new ResponseEntity<String>("Send mail succsess", headers,
					HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("Send mail failure", headers,
					HttpStatus.BAD_REQUEST);
		}
	}
}
