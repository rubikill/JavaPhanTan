package co.hcmus.shopcamera.manager;

import java.util.List;

import co.hcmus.shopcamera.data.model.Account;
import co.hcmus.shopcamera.data.model.AccountType;

/**
 * 
 * @author Thanh Toan
 * 
 */
public interface IAccountService {
	/**
	 * 
	 * @param account
	 */
	public void addAccount(Account account);

	/**
	 * 
	 * @param account
	 */
	public void updateAccount(Account account);

	/**
	 * 
	 * @param email
	 * @return
	 */
	public Account getAccount(String email);

	/**
	 * 
	 * @param email
	 */
	public void deleteAccount(String email);

	/**
	 * 
	 * @return
	 */
	public List<Account> getAccounts();

	/**
	 * 
	 * @param accountTypeId
	 * @param status
	 * @return
	 */
	public List<Account> getAccountByAccountType(String accountTypeId,
			String status);
}
