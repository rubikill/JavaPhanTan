package co.hcmus.shopcamera.data.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.shopcamera.data.dao.IAccountTypeDAO;
import co.hcmus.shopcamera.data.model.Account;
import co.hcmus.shopcamera.data.model.AccountType;
import co.hcmus.shopcamera.utility.STATUS;

@Repository("accountTypeDAO")
@Transactional
public class AccountTypeDAOMongo implements IAccountTypeDAO {
	
	private static final Logger logger = LoggerFactory
			.getLogger(AccountTypeDAOMongo.class);
	@Autowired
	private MongoTemplate mongoTemplate;
	public static final String COLLECTION_NAME = "accountType";// Collection
																// name save in
																// MongoDB

	// Add new AccountType
	@Override
	public void addAccountType(AccountType accountType) {
		if (!mongoTemplate.collectionExists(Account.class)) {
			mongoTemplate.createCollection(Account.class);
		}
		logger.info("AccountTypeDAOMongo add accountType with name :" + accountType.getName());
		mongoTemplate.insert(accountType, COLLECTION_NAME);

	}

	// Update an AccountType
	@Override
	public void updateAccountType(AccountType accountType) {
		logger.info("AccountTypeDAOMongo update accountType with Id :" + accountType.getId());
		mongoTemplate.save(accountType, COLLECTION_NAME);

	}

	// Get a specific AccountType by id
	@Override
	public AccountType getAccountType(String id) {
		Query searchAccountTypeQuery = new Query(Criteria.where("_id").is(id));
		logger.info("AccountTypeDAOMongo get accountType with Id :" + id);
		return mongoTemplate.findOne(searchAccountTypeQuery, AccountType.class,
				COLLECTION_NAME);
	}

	// Delete a specific AccountType by id
	@Override
	public void deleteAccountType(String id) {
		AccountType accountType = getAccountType(id);
		accountType.setStatus(STATUS.INACTIVE.getStatusCode());
		logger.info("AccountTypeDAOMongo delete accountType with Id :" + id);
		mongoTemplate.save(accountType, COLLECTION_NAME);
	}

	// Get all AccountTypes
	@Override
	public List<AccountType> getAccountTypes() {
		logger.info("AccountTypeDAOMongo get all accountType");
		return mongoTemplate.findAll(AccountType.class, COLLECTION_NAME);
	}

}
