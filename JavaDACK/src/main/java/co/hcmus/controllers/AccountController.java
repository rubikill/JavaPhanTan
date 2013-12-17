package co.hcmus.controllers;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
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
	@Autowired
	private IAccountService accountService;

	@Autowired
	private IAccountTypeService accountTypeService;

	/**
	 * Controller to mapping admin page - MANAGE ACCOUNT
	 * @param locale
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/account", method = RequestMethod.GET)
	public String accounts(Locale locale, Model model,
			HttpServletRequest request) {
		prepairData(request);
		Account account = new Account();
		// account.setBirthday(new Date());
		model.addAttribute("account", account);
		return "accounts";
	}

	/**
	 * Controller to edit an account passing from MANAGE ACCOUNT - Admin page
	 * @param locale
	 * @param model
	 * @param request
	 * @param account
	 * @return
	 */
	@RequestMapping(value = "/admin/account/edit", method = RequestMethod.POST)
	public String editAccount(Locale locale, Model model,
			HttpServletRequest request, Account account) {
		
//		System.out.println("email:" + account.getEmail());
//		System.out.println("account:" + account.getName());

		//TODO add MD5 hash password
		
		accountService.updateAccount(account);
		prepairData(request);

		Account account1 = new Account();
		model.addAttribute("account", account1);
		return "accounts";
	}
	
//	@RequestMapping(value = "/admin/account/block", method = RequestMethod.POST)
//	public String blockAccount(Locale locale, Model model,
//			HttpServletRequest request, Account account) {
//		
//		System.out.println("email:" + account.getEmail());
//		System.out.println("account:" + account.getName());
//		
//		accountService.updateAccount(account);
//		prepairData(request);
//
//		Account account1 = new Account();
//		model.addAttribute("account", account1);
//		return "accounts";
//	}

	@RequestMapping(value = "/admin/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model, HttpServletRequest request) {
		return "login";
	}

	@RequestMapping(value = "/admin/forgotpass", method = RequestMethod.GET)
	public String forgotpass(Locale locale, Model model,
			HttpServletRequest request) {
		return "forgotpass";
	}

	private void prepairData(HttpServletRequest request) {
		List<Account> listAccount = accountService.getAccounts();
		
		AccountType act  = listAccount.get(0).getAccountType();
		if (act!=null){
			System.out.println(act.getName());
		}
		else
			System.out.println("ACT NULL");
		
		List<AccountType> listAccountType = accountTypeService
				.getAccountTypes();
		for (int i = 0; i < listAccountType.size(); i++) {
//			System.out.println(listAccountType.get(i).getName());
		}
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
	@SuppressWarnings("deprecation")
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
			System.out.println("ping failure...");
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
		} else {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json");
			Account account = accountService.getAccount(session.getAttribute(
					"email").toString());
			System.out.println("ping success...");
			return new ResponseEntity<String>(Tools.toJson(account), headers,
					HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ResponseEntity<String> logout(HttpSession session) {
		session.removeAttribute("email");
		System.out.println("logout...");
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	/**
	 * Register
	 * 
	 * @param json
	 *            Account information
	 * @return Result
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody String json) {

		System.out.println(json);
		Account account = Tools.fromJsonTo(json, Account.class);

		// verify account infomation here
		// ...

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html");
		// Create AccountService
		// get Account with email
		account.setPassword(encryptPasswordProvider.hash(account.getPassword(),
				Constant.MD5).toString());

		// Gen Token here
		account.setToken(UUID.randomUUID().toString());
		// Set accout type here

		// Set status
		account.setStatus(STATUS.INACTIVE.getStatusCode());
		// check account
		if (accountService.getAccount(account.getEmail()) == null) {
			try {
				accountService.addAccount(account);

				EmailForm emailForm = new EmailForm();
				emailForm.reciver = account.getEmail();
				emailForm.subject = "Welcome to Camera Shop";
				emailForm.body = "Your new password is: " + "xxxxxxxxx";

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

		Account account = accountService.getAccount(json);

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
