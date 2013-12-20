package co.hcmus.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This model this contain user information
 * 
 * @author Thanh Toan
 * 
 */
@Document
public class Account {

	@Id
	private String email; 					// Email
	private String name; 					// Full name
	private String phone; 					// Phone number
	private String address; 				// Address
	private Date birthday; 					// Birthday
	private String accountTypeId; 			// Id in AccountType collection, define which
											// account's type is
	private String password; 				// Password -- MD5
	private String status; 					// Status of account (inactive, active, block)
	private String token;					// Token key
	private int point; 						// Point - after reach a number of points, account type
											// will be changed to VIP. Limit is defined in PointLevel colection

	private AccountType accountType;

	/**
	 * @return Email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return Full name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            Full name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Phone number
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            Phone number to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return Birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            Birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return Id in AccountType collection, define which account's type is
	 */
	public String getAccountTypeId() {
		return accountTypeId;
	}

	/**
	 * @param accountTypeId
	 *            the accountTypeId to set
	 */
	public void setAccountTypeId(String accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	/**
	 * @return Password -- MD5
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            Password -- MD5 to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return Status of account (Inactive, Active, Block)
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            Account's status to set, get it from STATUS
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return Token key
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token
	 *            Token key to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return Point - after reach a number of points, account type will be
	 *         changed to VIP. Limit is defined in PointLevel collection
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * @param point
	 *            the point to set. After reach a number of points, account type
	 *            will be changed to VIP. Limit is defined in PointLevel
	 *            collection
	 */
	public void setPoint(int point) {
		this.point = point;
	}

	/**
	 * @return the accountType
	 */
	public AccountType getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType
	 *            the accountType to set
	 */
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	/**
	 * 
	 */
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param email
	 * @param name
	 * @param phone
	 * @param address
	 * @param birthday
	 * @param accountTypeId
	 * @param password
	 * @param status
	 * @param token
	 * @param point
	 * @param accountType
	 */
	public Account(String email, String name, String phone, String address,
			Date birthday, String accountTypeId, String password,
			String status, String token, int point, AccountType accountType) {
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
		this.accountType = accountType;
	}

}
