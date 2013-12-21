package co.hcmus.services.Imp;

import java.util.ArrayList;
import java.util.Collection;

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

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		Account account = accountService.getAccount(username);

		if (account == null)
			throw new UsernameNotFoundException("User not found");

		return buildUserFromAccount(account);
	}

	User buildUserFromAccount(Account account) {

		String username = account.getEmail();
		String password = account.getPassword();
		boolean enabled = account.getStatus().equals(
				STATUS.ACTIVE.getStatusCode()) ? true : false;
		System.out.println("Name:" + account.getEmail());
		System.out.println("Password:" + account.getPassword());
		System.out.println("Status:"
				+ account.getStatus().equals(STATUS.ACTIVE.getStatusCode()));
		System.out.println("==========================");
		System.out.println("email:" + account.getEmail());
		System.out.println("Account type id:" + account.getAccountTypeId());
		System.out.println("==========================");
		
		boolean accountNonExpired = enabled;
		boolean credentialsNonExpired = enabled;
		boolean accountNonLocked = enabled;
		System.out.println("==========================\n");
		System.out.println("==========================\n");
		System.out.println("==========================\n");
		System.out.println("==========================\n");
		System.out.println("\n ACCOUNT TYPE:" + account
				.getAccountType().getName() + "\n");
		Collection<GrantedAuthority> authorities = getAuthorities(account
				.getAccountType().getName());
		User user = new User(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
		System.out.println("GET AUTHORITY FINISH\n");
		
		// User user = new User("john", "123456", true, true,
		// true, true, authorities);

		return user;
	}

	private Collection<GrantedAuthority> getAuthorities(String accountType) {
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		System.out.println("\n ACCOUNT TYPE:" + accountType + "\n");
		if (accountType.equals("ADMIN")) {
			System.out.println("\n SET ROLE ADMIN USER \n");
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			authorities.add(new SimpleGrantedAuthority("ROLE_VIP"));
			authorities.add(new SimpleGrantedAuthority("ROLE_NORMAL"));
		} else if (accountType.equals("VIP")) {
			System.out.println("\n SET ROLE VIP USER \n");
			authorities.add(new SimpleGrantedAuthority("ROLE_VIP"));
			authorities.add(new SimpleGrantedAuthority("ROLE_NORMAL"));
		} else if (accountType.equals("NORMAL")) {
			System.out.println("\n SET ROLE NORMAL USER \n");
			authorities.add(new SimpleGrantedAuthority("ROLE_NORMAL"));
		}

		return authorities;
	}

}