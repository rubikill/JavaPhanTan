package co.hcmus.daos.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import co.hcmus.daos.IAccountDAO;
import co.hcmus.models.Account;

@Repository("accountDAO")
public class AccountDAOMongo implements IAccountDAO {
	@Autowired
	private MongoTemplate mongoTemplate;
	public static final String COLLECTION_NAME = "account";

	public void addAccount(Account account) {
		if (!mongoTemplate.collectionExists(Account.class)) {
			mongoTemplate.createCollection(Account.class);
		}
		mongoTemplate.insert(account, COLLECTION_NAME);
		
	}

	public List<Account> getAccounts() {
		return mongoTemplate.findAll(Account.class, COLLECTION_NAME);
	}

	public void updateAccount(Account account) {
		mongoTemplate.insert(account, COLLECTION_NAME);
	}

	@Override
	public void deleteAccount(String email) {
		Account account = getAccount(email);
		mongoTemplate.remove(account, COLLECTION_NAME);
	}

	@Override
	public Account getAccount(String email) {
		Query searchAccountQuery = new Query(Criteria.where("email").is(email));
		return mongoTemplate.findOne(searchAccountQuery, Account.class,COLLECTION_NAME);
	}
}
