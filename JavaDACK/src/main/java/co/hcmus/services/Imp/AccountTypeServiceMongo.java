package co.hcmus.services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IAccountTypeDAO;
import co.hcmus.models.AccountType;
import co.hcmus.services.IAccountTypeService;

@Service("accountTypeService")
@Transactional
public class AccountTypeServiceMongo implements IAccountTypeService {

	@Autowired
	private IAccountTypeDAO accountTypeDAO;

	@Override
	public void addAccountType(AccountType accountType) {
		accountTypeDAO.addAccountType(accountType);
		
	}

	@Override
	public void updateAccountType(AccountType accountType) {
		accountTypeDAO.updateAccountType(accountType);
		
	}

	@Override
	public AccountType getAccountType(String id) {
		return accountTypeDAO.getAccountType(id);
	}

	@Override
	public void deleteAccountType(String id) {
		accountTypeDAO.deleteAccountType(id);
	}

	@Override
	public List<AccountType> getAccountTypes() {
		return accountTypeDAO.getAccountTypes();
	}
	
	
}
