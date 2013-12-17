package co.hcmus.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document
public class Account {
	@Id
	private String email;			// Email
	private String name;			// Full name
	private String phone;			// Phone number
	private String address;			// Address

	@DateTimeFormat(pattern="yyyy-MM-ddThh:mm:ss.SSSZ")
	private Date birthday;			// Birthday
	private String accountTypeId;	// Id in AccountType collection, define which account's type is
	private String password;		// Password -- MD5 (incomplete - hash)
	private String status;			// Status of account (inactive, active, block)	
	private String token;			// Token key
	private int point;				// Point - after reach a number of points, account type will 
									// be changed to VIP. Limit is defined in PointLevel colection

	private AccountType accountType;

	public Account(){
		
	}
	
	public Account(String email, String name, String phone, String address,
			Date birthday, String accountTypeId, String password,
			String status, String token, int point) {
		super();
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
		this.accountTypeId = accountTypeId;
		this.password = password;
		this.status = status;
		this.token = token;
		this.point = point;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(String accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
}
