package co.hcmus.daos;

import java.util.List;

import co.hcmus.models.Account;

public interface AccountDAO {
	public void addAccount(Account account);
	public void updateAccount(Account account);
	public Account getAccount(String email);
	public void deleteAccount(String email);
	public List<Account> getAccounts();
	
}
