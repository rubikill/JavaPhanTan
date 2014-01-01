package co.hcmus.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	private static final Logger logger = LoggerFactory
			.getLogger(AccountController.class);

	
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
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/account", method = RequestMethod.GET)
	public String accounts(HttpServletRequest request) {
		logger.info("Admin get all Accounts");
		prepairData(request);
		return "accounts";
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	/**
	*
	*
	*/
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	@ResponseBody
	public List<Account> getAllAccounts() {
		return accountService.getAccounts();
	}

	/**
	*
	*
	*/
	@RequestMapping(value = "/account", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> addAccount(@RequestBody String json) {
		try{
			Account account = Tools.fromJsonTo(json, Account.class);

			System.out.println("---------" + account);
			accountService.addAccount(account);

			return new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception ex){

		}

		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	/**
	*
	*
	*/
	@RequestMapping(value = "/account", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<String> updateAccount(@RequestBody String json) {
		try{
			Account account = Tools.fromJsonTo(json, Account.class);
			accountService.updateAccount(account);

			return new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception ex){

		}

		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	/**
	*
	*
	*/
	@RequestMapping(value = "/account", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> deleteAccount(@RequestBody String json) {
		try{
			Account account = Tools.fromJsonTo(json, Account.class);
			accountService.deleteAccount(account.getEmail());

			return new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception ex){

		}

		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}



	/**
	 * ADMIN PAGE - Deactive an account
	 * 
	 * @param account
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/account/block", method = RequestMethod.POST)
	public String blockAccount(Account account) {
		account = accountService.getAccount(account.getEmail());
		account.setStatus(STATUS.BLOCK.getStatusCode());
		accountService.updateAccount(account);
		logger.info("Admin block an Account with Email : " + account.getEmail());
		return "redirect:/admin/account";
	}

	/**
	 * ADMIN PAGE - Active an account
	 * 
	 * @param account
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/account/active", method = RequestMethod.POST)
	public String activeAccount(Account account) {
		account = accountService.getAccount(account.getEmail());
		account.setStatus(STATUS.ACTIVE.getStatusCode());
		accountService.updateAccount(account);
		logger.info("Admin active an Account with Email : " + account.getEmail());
		return "redirect:/admin/account";
	}

	/**
	 * ADMIN PAGE - Change password
	 * @param account
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/account/changepassword", method = RequestMethod.POST)
	public String changePassword(Account account) {
		String password1 = account.getPassword();
		String password2 = account.getAddress();
		if (password1.equals(password2)) {
			account = accountService.getAccount(account.getEmail());
			account.setPassword(encryptPasswordProvider.hash(password1, Constant.MD5).toString());
			accountService.updateAccount(account);
			logger.info("Change password success. Email : "
					+ account.getEmail());
		}
		else
		{
			logger.info("Change password fail. password mismatch. Email:"
					+ account.getEmail());
		}
		return "redirect:/admin/account";
	}

	/**
	 * ADMIN PAGE - Edit an account passing from MANAGE ACCOUNT
	 * 
	 * @param account
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/account/edit", method = RequestMethod.POST)
	public String editAccount(Account account) {
		account.setPassword(accountService.getAccount(account.getEmail()).getPassword());
		accountService.updateAccount(account);
		logger.info("Admin edit an Account with Email : " + account.getEmail());
		return "redirect:/admin/account";
	}

	/**
	 * ADMIN PAGE - Create new account
	 * 
	 * @param account
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/account/create", method = RequestMethod.POST)
	public String createAccount(Account account) {
		account.setPassword(encryptPasswordProvider.hash(account.getPassword(), Constant.MD5).toString());
		accountService.addAccount(account);
		logger.info("Admin create an Account with Email");
		return "redirect:/admin/account";
	}

	/**
	 * ADMIN PAGE - Login page 
	 * @param error
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/login", method = RequestMethod.GET)
	public String login(
			@RequestParam(value = "error", required = false) boolean error,
			ModelMap model) {
		if (error == true) {
			logger.info("An user login fail");
			model.put("error",
					"You have entered an invalid username or password!");
		} else {
			logger.info("An user login success");
			model.put("error", null);
		}
		return "login";
	}

	@RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
	public String logout(Locale locale, Model model, HttpServletRequest request) {
		logger.info("An user logout fail");
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

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		try {
			Account accountTemp = Tools.fromJsonTo(json, Account.class);
			// Create AccountService
			// get Account with email
			logger.info("User login with Account { Email : "
					+ accountTemp.getEmail() + "}"); // loger
			Account account = accountService.getAccount(accountTemp.getEmail());
			// check account
			if (account == null) {
				logger.error("Account does not exsits with  Account { Email : "
						+ accountTemp.getEmail() + "}");
				return new ResponseEntity<String>("Account does not exsits",
						headers, HttpStatus.BAD_REQUEST);
			} else {
				if (encryptPasswordProvider.checkSum(accountTemp.getPassword(),
						account.getPassword(), Constant.MD5)) {
					logger.info("User login success with  Account { Email : "
							+ accountTemp.getEmail() + "}");
					session.setAttribute("email", account.getEmail());
					return new ResponseEntity<String>(Tools.toJson(account),
							headers, HttpStatus.OK);
				} else {
					logger.info("User login not success with  Account { Email : "
							+ accountTemp.getEmail() + "}");
					return new ResponseEntity<String>("Wrong password",
							headers, HttpStatus.BAD_REQUEST);
				}
			}
		} catch (Exception e) {
			logger.error("Error in rest login Account");
			return new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Login
	 * 
	 * @param json
	 *            contain email and password
	 * @return Result
	 */
	@RequestMapping(value = "/login/fb", method = RequestMethod.POST)
	public ResponseEntity<String> loginFB(@RequestBody String json, HttpSession session) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		try {
			Account account = Tools.fromJsonTo(json, Account.class);

			System.out.println(account.getEmail());

			// check account
			if (accountService.getAccount(account.getEmail()) == null) {
				//save to database
				accountService.addAccount(account);
			}

			session.setAttribute("email", account.getEmail());
			return new ResponseEntity<String>(Tools.toJson(account), headers, HttpStatus.OK);			
		} catch (Exception e) {
			
		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
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
			logger.info("ping success...");
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
		JsonNode jsonNode = null;
		try {
			jsonNode = mapper.readTree(json);
			account.setEmail(jsonNode.path("email").getTextValue());
			// loger
			logger.info("Registrer Account with Email : "
					+ jsonNode.path("email").getTextValue());

			if (accountService.getAccount(account.getEmail()) != null) {
				logger.error("Email has been used : "
						+ jsonNode.path("email").getTextValue());
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
			logger.error("Error JsonProcessingException : " + e1.toString());
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			logger.error("Error IOException : " + e1.toString());
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
			emailForm.body = "Your have registered, your password is: " + jsonNode.path("password").getTextValue();

			sendMailHelper.sendMail(emailForm);
			logger.info("Register sucess with Email : " + account.getEmail());
			return new ResponseEntity<String>(
					"{\"message\" : \"Create success\"}", headers,
					HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println("Problem when create account");
			logger.error("Problem when create account : " + e.toString());
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
		logger.info("Forgerpass with Email : " + email);
		EmailForm emailForm = new EmailForm();
		emailForm.reciver = email;
		emailForm.subject = "Reset password for " + email;
		emailForm.body = "Your new password is: " + "xxxxxxxxx";

		// Send a email to reset password
		try {
			sendMailHelper.sendMail(emailForm);
			logger.info("Forgerpass Send mail succsess with Email  : " + email);
			return new ResponseEntity<String>("Send mail succsess", headers,
					HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Forgerpass Send mail failure with Email  : " + email);
			e.printStackTrace();
			return new ResponseEntity<String>("Send mail failure", headers,
					HttpStatus.BAD_REQUEST);
		}
	}
}
