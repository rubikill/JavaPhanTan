package co.hcmus.daos.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import co.hcmus.daos.IAccountTypeDAO;
import co.hcmus.models.Account;
import co.hcmus.models.AccountType;

@Repository("accountTypeDAO")
public class AccountTypeDAOMongo implements IAccountTypeDAO {
	@Autowired
	private MongoTemplate mongoTemplate;
	public static final String COLLECTION_NAME = "accountType";//Collection name save in MongoDB

	// Add new AccountType
	@Override
	public void addAccountType(AccountType accountType) {
		if (!mongoTemplate.collectionExists(Account.class)) {
			mongoTemplate.createCollection(Account.class);
		}
		mongoTemplate.insert(accountType, COLLECTION_NAME);

	}
	
	//Update an AccountType
	@Override
	public void updateAccountType(AccountType accountType) {
		mongoTemplate.save(accountType, COLLECTION_NAME);

	}

	// Get a specific AccountType by id 
	@Override
	public AccountType getAccountType(String id) {
		Query searchAccountTypeQuery = new Query(Criteria.where("id").is(id));
		return mongoTemplate.findOne(searchAccountTypeQuery, AccountType.class,
				COLLECTION_NAME);
	}

	//Delete a specific AccountType by id
	@Override
	public void deleteAccountType(String id) {
		AccountType accountType = getAccountType(id);
		mongoTemplate.remove(accountType, COLLECTION_NAME);

	}

	// Get all AccountTypes
	@Override
	public List<AccountType> getAccountTypes() {
		return mongoTemplate.findAll(AccountType.class, COLLECTION_NAME);
	}

}
