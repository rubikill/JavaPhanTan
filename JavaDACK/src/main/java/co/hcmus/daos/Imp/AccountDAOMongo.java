package co.hcmus.daos.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IAccountDAO;
import co.hcmus.models.Account;
import co.hcmus.util.STATUS;

@Repository("accountDAO")
@Transactional
public class AccountDAOMongo implements IAccountDAO {
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
		mongoTemplate.insert(account, COLLECTION_NAME);
	}

	// Get all Accounts
	@Override
	public List<Account> getAccounts() {
		return mongoTemplate.findAll(Account.class, COLLECTION_NAME);
	}

	// Update an Account
	@Override
	public void updateAccount(Account account) {
		mongoTemplate.save(account, COLLECTION_NAME);
	}

	// Delete an Account
	@Override
	public void deleteAccount(String email) {
		Account account = getAccount(email);
		account.setStatus(STATUS.INACTIVE.getStatusCode());
		mongoTemplate.save(account, COLLECTION_NAME);
	}

	// Get a specific account by email
	@Override
	public Account getAccount(String email) {
		Query searchAccountQuery = new Query(Criteria.where("email").is(email));
		return mongoTemplate.findOne(searchAccountQuery, Account.class,
				COLLECTION_NAME);
	}

	@Override
	public List<Account> getAccountByAccountType(String accountTypeId,
			String status) {
		Query searchAccountByAccountTypeIdQuery;
		if (status.equals("none")) {
			searchAccountByAccountTypeIdQuery = new Query(Criteria
					.where("accountTypeId").is(accountTypeId));
		} else {

			searchAccountByAccountTypeIdQuery = new Query(Criteria
					.where("accountTypeId").is(accountTypeId).and("status")
					.is(status));
		}
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
