package co.hcmus.shopcamera.data.dao;

import java.util.List;

import co.hcmus.shopcamera.data.model.Account;

/**
 * Interface of Account DAO
 * @author Thanh Toan
 *
 */
public interface IAccountDAO {
	/**
	 * Insert
	 * @param account
	 */
	public void addAccount(Account account);

	/**
	 * Update
	 * @param account
	 */
	public void updateAccount(Account account);

	/**
	 * Get
	 * @param email
	 * @return
	 */
	public Account getAccount(String email);

	/**
	 * Delete
	 * @param email
	 */
	public void deleteAccount(String email);

	/**
	 * Get all
	 * @return
	 */
	public List<Account> getAccounts();

	/**
	 * Get by type
	 * @param accountTypeId
	 * @param status
	 * @return
	 */
	public List<Account> getAccountByAccountType(String accountTypeId,
			String status);
}
