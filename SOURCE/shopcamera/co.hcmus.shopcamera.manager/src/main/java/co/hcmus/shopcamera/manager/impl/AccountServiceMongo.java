package co.hcmus.shopcamera.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.shopcamera.data.dao.IAccountDAO;
import co.hcmus.shopcamera.data.dao.IAccountTypeDAO;
import co.hcmus.shopcamera.data.model.Account;
import co.hcmus.shopcamera.data.model.Comment;
import co.hcmus.shopcamera.manager.IAccountService;
import co.hcmus.shopcamera.manager.ICommentService;
import co.hcmus.shopcamera.utility.STATUS;

@Service("accountService")
@Transactional
public class AccountServiceMongo implements IAccountService {

	private static final Logger logger = LoggerFactory
			.getLogger(AccountServiceMongo.class);

	@Autowired
	private IAccountDAO accountDAO;
	@Autowired
	private ICommentService commentService;

	@Autowired
	private IAccountTypeDAO accountTypeDAO;

	@Override
	public void addAccount(Account account) {
		logger.info("AccountServiceMongo add account with name : "
				+ account.getName());
		accountDAO.addAccount(account);
	}

	public void updateAccount(Account account) {
		logger.info("AccountServiceMongo update account with email : "
				+ account.getEmail());
		accountDAO.updateAccount(account);
	}

	public List<Account> getAccounts() {
		List<Account> accounts = accountDAO.getAccounts();
		for (int i = 0; i < accounts.size(); i++) {
			String id = accounts.get(i).getAccountTypeId();

			accounts.get(i).setAccountType(accountTypeDAO.getAccountType(id));
		}
		logger.info("AccountServiceMongo get all accounts");
		return accounts;
	}

	@Override
	public Account getAccount(String email) {
		logger.info("AccountServiceMongo get account by email : " + email);
		Account account = accountDAO.getAccount(email);
		try{
			account.setAccountType(accountTypeDAO.getAccountType(account
					 		.getAccountTypeId()));
		}catch(Exception ex) {

		}
		
		return account;
	}

	@Override
	public void deleteAccount(String email) {
		List<Comment> listComment = commentService.getCommentByEmail(email,
				STATUS.ACTIVE.getStatusCode());
		for (Comment comment : listComment)
			commentService.deleteComment(comment.getId());

		logger.info("AccountServiceMongo delete account with name : " + email);
		accountDAO.deleteAccount(email);
	}

	@Override
	public List<Account> getAccountByAccountType(String accountTypeId,
			String status) {
		// TODO Auto-generated method stub
		logger.info("AccountServiceMongo get account by AccountTypeId : "
				+ accountTypeId);
		return accountDAO.getAccountByAccountType(accountTypeId, status);
	}

}
