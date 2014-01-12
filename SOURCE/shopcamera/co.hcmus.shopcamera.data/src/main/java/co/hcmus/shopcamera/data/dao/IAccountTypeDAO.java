package co.hcmus.shopcamera.data.dao;

import java.util.List;

import co.hcmus.shopcamera.data.model.AccountType;

/**
 * Interface of account type DAO
 * @author Thanh Toan
 *
 */
public interface IAccountTypeDAO {
	/**
	 * Create
	 * @param accountType
	 */
	public void addAccountType(AccountType accountType);

	/**
	 * Updtae
	 * @param accountType
	 */
	public void updateAccountType(AccountType accountType);

	/**
	 * Get
	 * @param id
	 * @return
	 */
	public AccountType getAccountType(String id);

	/**
	 * Delete
	 * @param id
	 */
	public void deleteAccountType(String id);

	/**
	 * Get all
	 * @return
	 */
	public List<AccountType> getAccountTypes();
}
