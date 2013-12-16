package co.hcmus.services.Imp;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IAccountDAO;
import co.hcmus.models.Account;
import co.hcmus.models.Comment;
import co.hcmus.services.IAccountService;
import co.hcmus.services.ICommentService;
import co.hcmus.util.STATUS;

@Service("accountService")
@Transactional
public class AccountServiceMongo implements IAccountService {

	@Autowired
	private IAccountDAO accountDAO;
	@Autowired
	private ICommentService commentService;

	@Override
	public void addAccount(Account account) {
		accountDAO.addAccount(account);
	}

	public void updateAccount(Account account) {
		accountDAO.updateAccount(account);
	}

	public List<Account> getAccounts() {
		return accountDAO.getAccounts();
	}

	@Override
	public Account getAccount(String email) {
		return accountDAO.getAccount(email);
	}

	@Override
	public void deleteAccount(String email) {
		List<Comment> listComment = commentService.getCommentByEmail(email,
				STATUS.ACTIVE.getStatusCode());
		for(Comment comment : listComment)
			commentService.deleteComment(comment.getId());
		accountDAO.deleteAccount(email);
	}

	@Override
	public List<Account> getAccountByAccountType(String accountTypeId,
			String status) {
		// TODO Auto-generated method stub
		return accountDAO.getAccountByAccountType(accountTypeId, status);
	}

}
