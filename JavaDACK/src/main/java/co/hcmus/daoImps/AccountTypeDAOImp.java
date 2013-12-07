package co.hcmus.daoImps;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.hcmus.daos.AccountTypeDAO;
import co.hcmus.models.AccountType;

@Repository("accountTypeDAO")
public class AccountTypeDAOImp implements AccountTypeDAO {
	@Autowired
	SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addAccountType(AccountType accountType) {
		getCurrentSession().saveOrUpdate(accountType);
	}

	public void updateAccountType(AccountType accountType) {
		getCurrentSession().update(accountType);
	}

	public AccountType getAccountType(int id) {
		AccountType accountType = new AccountType();
		accountType = (AccountType) getCurrentSession().get(AccountType.class, id);
		return accountType;
	}

	public void deleteAccountType(int id) {
		AccountType accountType = getAccountType(id);
		if (accountType != null) {
			getCurrentSession().delete(accountType);
		}
	}

	@SuppressWarnings("unchecked")
	public List<AccountType> getAccountTypes() {
		return getCurrentSession().createQuery("from AccountType").list();
	}

	@Override
	public AccountType getAccountType(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccountType(String id) {
		// TODO Auto-generated method stub
		
	}

}
