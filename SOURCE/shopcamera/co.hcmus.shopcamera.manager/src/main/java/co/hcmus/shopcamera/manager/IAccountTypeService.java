package co.hcmus.shopcamera.manager;

import java.util.List;

import co.hcmus.shopcamera.data.model.AccountType;

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
