package co.hcmus.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Account {
	@Id
	private String email;
	private String name;
	private String phone;
	private String address;
	private Date birthday;
	private String accountTypeId;
	private String password;
	private String status;
	private String token;
	private int point;

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

}
