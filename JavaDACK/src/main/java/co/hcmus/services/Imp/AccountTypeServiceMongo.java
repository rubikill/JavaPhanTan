package co.hcmus.services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IAccountTypeDAO;
import co.hcmus.models.Account;
import co.hcmus.models.AccountType;
import co.hcmus.models.PermissionDetail;
import co.hcmus.services.IAccountService;
import co.hcmus.services.IAccountTypeService;
import co.hcmus.services.IPermissionDetailService;
import co.hcmus.util.STATUS;

@Service("accountTypeService")
@Transactional
public class AccountTypeServiceMongo implements IAccountTypeService {

	@Autowired
	private IAccountTypeDAO accountTypeDAO;
	@Autowired
	private IAccountService accountService;

	@Autowired
	private IPermissionDetailService permissionDetailService;

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
		List<Account> listAccount = accountService.getAccountByAccountType(id,
				"none");
		for (Account account : listAccount)
			accountService.deleteAccount(account.getEmail());

		List<PermissionDetail> listPermissionDetail = permissionDetailService
				.getPermissionDetailByAccountTypeId(id,
						STATUS.ACTIVE.getStatusCode());
		for (PermissionDetail permissionDetail : listPermissionDetail)
			permissionDetailService.deletePermissionDetail(permissionDetail
					.getId());
		accountTypeDAO.deleteAccountType(id);
	}

	@Override
	public List<AccountType> getAccountTypes() {
		return accountTypeDAO.getAccountTypes();
	}

}
