package co.hcmus.services.Imp;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.models.Account;
import co.hcmus.services.IAccountService;
import co.hcmus.util.STATUS;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private IAccountService accountService;

	private static final Logger logger = LoggerFactory
			.getLogger(UserDetailsServiceImpl.class);

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		Account account = accountService.getAccount(username);

		if (account == null) {

			throw new UsernameNotFoundException("User not found");
		}

		return buildUserFromAccount(account);
	}

	User buildUserFromAccount(Account account) {
		logger.info("An user is login:");
		logger.info("- email:" + account.getEmail());
		logger.info("- password:" + account.getStatus());
		logger.info("- status: " + account.getStatus());
		logger.info("- Account Type:" + account.getAccountType().getName());
		String username = account.getEmail();
		String password = account.getPassword();
		boolean enabled = account.getStatus().equals(
				STATUS.ACTIVE.getStatusCode()) ? true : false;
		System.out.println("- email:" + account.getEmail() + "- password:"
				+ account.getPassword() + "- status: " + account.getStatus()
				+ "- enable: " + enabled + "- Account Type:"
				+ account.getAccountType().getName());

		boolean accountNonExpired = enabled;
		boolean credentialsNonExpired = enabled;
		boolean accountNonLocked = enabled;

		Collection<GrantedAuthority> authorities = getAuthorities(account
				.getAccountType().getName());
		User user = new User(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);

		return user;
	}

	private Collection<GrantedAuthority> getAuthorities(String accountType) {
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		if (accountType.equals("ADMIN")) {
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			authorities.add(new SimpleGrantedAuthority("ROLE_VIP"));
			authorities.add(new SimpleGrantedAuthority("ROLE_NORMAL"));
			System.out.println("- set ROLE: ROLE_ADMIN, ROLE_VIP, ROLE_NORMAL");
			logger.info("- set ROLE: ROLE_ADMIN, ROLE_VIP, ROLE_NORMAL");
		} else if (accountType.equals("VIP")) {
			System.out.println("\n SET ROLE VIP USER \n");
			authorities.add(new SimpleGrantedAuthority("ROLE_VIP"));
			authorities.add(new SimpleGrantedAuthority("ROLE_NORMAL"));
			logger.info("- set ROLE: ROLE_VIP, ROLE_NORMAL");
			System.out.println("- set ROLE: ROLE_VIP, ROLE_NORMAL");
		} else if (accountType.equals("NORMAL")) {
			authorities.add(new SimpleGrantedAuthority("ROLE_NORMAL"));
			System.out.println("ROLE_NORMAL");
			logger.info("- set ROLE: ROLE_NORMAL");
		}

		return authorities;
	}

}