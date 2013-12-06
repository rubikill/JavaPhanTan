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
	public void addAccountType(AccountType accounttype) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAccountType(AccountType accounttype) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AccountType getAccountType(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccountType(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AccountType> getAccountTypes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
