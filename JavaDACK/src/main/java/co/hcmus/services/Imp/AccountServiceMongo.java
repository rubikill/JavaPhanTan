package co.hcmus.services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IAccountDAO;
import co.hcmus.models.Account;
import co.hcmus.services.IAccountService;

@Service("accountService")
@Transactional
public class AccountServiceMongo implements IAccountService {

	@Autowired
	private IAccountDAO accountDAO;

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
		accountDAO.deleteAccount(email);
	}

	
}
