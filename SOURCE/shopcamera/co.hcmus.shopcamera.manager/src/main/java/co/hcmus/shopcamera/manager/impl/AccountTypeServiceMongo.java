package co.hcmus.shopcamera.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.shopcamera.data.dao.IAccountTypeDAO;
import co.hcmus.shopcamera.data.model.Account;
import co.hcmus.shopcamera.data.model.AccountType;
import co.hcmus.shopcamera.data.model.PermissionDetail;
import co.hcmus.shopcamera.manager.IAccountService;
import co.hcmus.shopcamera.manager.IAccountTypeService;
import co.hcmus.shopcamera.manager.IPermissionDetailService;
import co.hcmus.shopcamera.utility.STATUS;

@Service("accountTypeService")
@Transactional
public class AccountTypeServiceMongo implements IAccountTypeService {

	private static final Logger logger = LoggerFactory
			.getLogger(AccountTypeServiceMongo.class);
	
	@Autowired
	private IAccountTypeDAO accountTypeDAO;
	@Autowired
	private IAccountService accountService;

	@Autowired
	private IPermissionDetailService permissionDetailService;

	@Override
	public void addAccountType(AccountType accountType) {
		logger.info("AccountTypeServiceMongo add accountType with name : " + accountType.getName());
		accountTypeDAO.addAccountType(accountType);

	}

	@Override
	public void updateAccountType(AccountType accountType) {
		logger.info("AccountTypeServiceMongo update accountType with id : " + accountType.getId());
		accountTypeDAO.updateAccountType(accountType);

	}

	@Override
	public AccountType getAccountType(String id) {
		logger.info("AccountTypeServiceMongo get accountType with id : " + id);
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
		logger.info("AccountTypeServiceMongo delete accountType with id : " + id);
		accountTypeDAO.deleteAccountType(id);
	}

	@Override
	public List<AccountType> getAccountTypes() {
		logger.info("AccountTypeServiceMongo get all AccountType");
		return accountTypeDAO.getAccountTypes();
	}

}
