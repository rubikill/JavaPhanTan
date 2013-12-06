package co.hcmus.daos;

import java.util.List;

import co.hcmus.models.AccountType;

public interface AccountTypeDAO {
	public void addAccountType(AccountType accountType);
	public void updateAccountType(AccountType accountType);
	public AccountType getAccountType(String id);
	public void deleteAccountType(String id);
	public List<AccountType> getAccountTypes();
	
}
