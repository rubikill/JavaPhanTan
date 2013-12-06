package co.hcmus.daoImps;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import co.hcmus.daos.AccountDAO;
import co.hcmus.models.Account;

@Repository("accountDAO")
public class AccountDAOImp implements AccountDAO {
	@Autowired
	private MongoTemplate mongoTemplate;
	public static final String COLLECTION_NAME = "account";
	
	public void addAccount(Account account) {
		if (!mongoTemplate.collectionExists(Account.class)) {
			mongoTemplate.createCollection(Account.class);
		}		
//		account.setEmail(UUID.randomUUID().toString());
		mongoTemplate.insert(account, COLLECTION_NAME);
	}
	
//	public Account getAccount(String email)
//	{
//		
//	}

	public List<Account> getAccounts() {
		return mongoTemplate.findAll(Account.class, COLLECTION_NAME);
	}
	
	public void deleteAccount(Account account) {
		mongoTemplate.remove(account, COLLECTION_NAME);
	}
	
	public void updateAccount(Account account) {
		mongoTemplate.insert(account, COLLECTION_NAME);		
	}

	@Override
	public void deleteAccount(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account getAccount(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}
