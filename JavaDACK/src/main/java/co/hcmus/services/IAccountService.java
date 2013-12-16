package co.hcmus.services;

import java.util.List;

import co.hcmus.models.Account;

public interface IAccountService {
	public void addAccount(Account account);

	public void updateAccount(Account account);

	public Account getAccount(String email);

	public void deleteAccount(String email);

	public List<Account> getAccounts();

	public List<Account> getAccountByAccountType(String accountTypeId, String status);
}
