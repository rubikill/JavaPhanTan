package co.hcmus.controllers;

import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.hcmus.models.Account;
import co.hcmus.models.AccountType;
import co.hcmus.models.Product;
import co.hcmus.services.Imp.AccountServiceMongo;
import co.hcmus.services.Imp.AccountTypeServiceMongo;
import co.hcmus.services.Imp.CommentServiceMongo;
import co.hcmus.services.Imp.HistoryServiceMongo;
import co.hcmus.services.Imp.PermissionServiceMongo;
import co.hcmus.services.Imp.ProductTypeServiceMongo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private AccountServiceMongo accountService;
	@Autowired
	private AccountTypeServiceMongo accountTypeService; 
	@Autowired
	private CommentServiceMongo commentService;
	@Autowired
	private HistoryServiceMongo historyService;
	@Autowired
	private PermissionServiceMongo permissionService;
	@Autowired
	private ProductTypeServiceMongo productService;
	

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//Add account
		Account account = new Account("abcd@acd.com","Thomas","092388332","A2, Phidel town",new Date(),"1","abcdef","active","1234567",100);
		accountService.addAccount(account);
		
		//Add accountType
		AccountType accountType = new AccountType("1", "Normal");
		accountTypeService.addAccountType(accountType);
		accountType = new AccountType("2", "VIP");
		accountTypeService.addAccountType(accountType);
		accountType = new AccountType("3", "Admin");
		accountTypeService.addAccountType(accountType);
		
		
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
