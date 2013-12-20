package co.hcmus.services.Imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IAccountDAO;
import co.hcmus.daos.IAccountTypeDAO;
import co.hcmus.models.Account;
import co.hcmus.models.Comment;
import co.hcmus.services.IAccountService;
import co.hcmus.services.ICommentService;
import co.hcmus.util.STATUS;

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
		return accountDAO.getAccount(email);
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
