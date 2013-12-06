package co.hcmus.services;

import java.util.List;

import co.hcmus.models.AccountType;

public interface IAccountTypeService {
	public void addAccountType(AccountType accounttype);

	public void updateAccountType(AccountType accounttype);

	public AccountType getAccountType(int id);

	public void deleteAccountType(int id);

	public List<AccountType> getAccountTypes();

}
