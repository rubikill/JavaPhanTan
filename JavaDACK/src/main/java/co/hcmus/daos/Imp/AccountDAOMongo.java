package co.hcmus.daos.Imp;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import co.hcmus.daos.IAccountDAO;
import co.hcmus.models.Account;
import co.hcmus.util.STATUS;

/**
 * Impl using mongodb
 * 
 * @author Thanh Toan
 * 
 */
@Repository("accountDAO")
@Transactional
public class AccountDAOMongo implements IAccountDAO {
	private static final Logger logger = LoggerFactory
			.getLogger(AccountDAOMongo.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;
	public static final String COLLECTION_NAME = "account"; // Collection name
															// save in MongoDB

	// Add new Account
	@Override
	public void addAccount(Account account) {
		if (!mongoTemplate.collectionExists(Account.class)) {
			mongoTemplate.createCollection(Account.class);
		}
		logger.info("AccountDAOMongo add account");
		mongoTemplate.insert(account, COLLECTION_NAME);
	}

	// Get all Accounts
	@Override
	public List<Account> getAccounts() {
		logger.info("AccountDAOMongo get all accounts");
		return mongoTemplate.findAll(Account.class, COLLECTION_NAME);
	}

	// Update an Account
	@Override
	public void updateAccount(Account account) {
		logger.info("AccountDAOMongo update Account with Email :" + account.getEmail());
		mongoTemplate.save(account, COLLECTION_NAME);
	}

	// Delete an Account
	@Override
	public void deleteAccount(String email) {
		Account account = getAccount(email);
		account.setStatus(STATUS.INACTIVE.getStatusCode());
		logger.info("AccountDAOMongo delete Account with Email :" + email);
		mongoTemplate.save(account, COLLECTION_NAME);
	}

	// Get a specific account by email
	@Override
	public Account getAccount(String email) {
		Query searchAccountQuery = new Query(Criteria.where("email").is(email));

		System.out.println("query:" + searchAccountQuery.toString());
		logger.info("AccountDAOMongo get Account with Email :" + email);
		return mongoTemplate.findOne(searchAccountQuery, Account.class,
				COLLECTION_NAME);
	}

	@Override
	public List<Account> getAccountByAccountType(String accountTypeId,
			String status) {
		Query searchAccountByAccountTypeIdQuery;

		if (status.equals("none")) {
			searchAccountByAccountTypeIdQuery = new Query(Criteria.where(
					"accountTypeId").is(accountTypeId));
		} else {
			searchAccountByAccountTypeIdQuery = new Query(Criteria
					.where("accountTypeId").is(accountTypeId).and("status")
					.is(status));
		}
		logger.info("AccountDAOMongo get Accounts by Type with TypeId :" + accountTypeId);
		return mongoTemplate.find(searchAccountByAccountTypeIdQuery,
				Account.class, COLLECTION_NAME);
	}

	// @Override
	// public UserDetails loadUserByUsername(String email)
	// throws UsernameNotFoundException {
	// Account account = getAccount(email);
	// System.out.println(email);
	// User userDetail = new User(account.getEmail(), account.getPassword(),
	// true, true, true, true,
	// getAuthorities(account.getAccountTypeId()));
	// return userDetail;
	// }
	//
	// public List<GrantedAuthority> getAuthorities(String accountTypeId) {
	// List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
	//
	// if (role.intValue() == 1) {
	// authList.add(new SimpleGrantedAuthority("ROLE_USER"));
	// authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	// } else if (role.intValue() == 2) {
	// authList.add(new SimpleGrantedAuthority("ROLE_USER"));
	// }
	//
	// return authList;
	// }
	//
	// public User getUserDetail(String username) {
	// MongoOperations mongoOperation = (MongoOperations) mongoTemplate;
	// User user = mongoOperation.findOne(new Query(Criteria.where("username")
	// .is(username)), User.class);
	// System.out.println(user.toString());
	// return user;
	// }

}
