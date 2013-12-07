package co.hcmus.serviceImps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.AccountDAO;
import co.hcmus.models.Account;
import co.hcmus.services.AccountService;

@Service("accountService")
@Transactional
public class AccountServiceImp implements AccountService {

	@Autowired
	private AccountDAO accountDAO;
	
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
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteAccount(String email) {
		// TODO Auto-generated method stub
		
	}
}
