package co.hcmus.services;

import java.util.List;

import co.hcmus.models.AccountType;

/**
 * 
 * @author Thanh Toan
 * 
 */
public interface IAccountTypeService {
	/**
	 * 
	 * @param accounttype
	 */
	public void addAccountType(AccountType accounttype);

	/**
	 * 
	 * @param accounttype
	 */
	public void updateAccountType(AccountType accounttype);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public AccountType getAccountType(String id);

	/**
	 * 
	 * @param id
	 */
	public void deleteAccountType(String id);

	/**
	 * 
	 * @return
	 */
	public List<AccountType> getAccountTypes();

}
