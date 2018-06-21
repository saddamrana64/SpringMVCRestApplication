package com.model.object;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class BankFetchObject implements Serializable {

	private int bankId;
	private int userIdentityNumber;
	private String userName;
	private String password;
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public int getUserIdentityNumber() {
		return userIdentityNumber;
	}
	public void setUserIdentityNumber(int userIdentityNumber) {
		this.userIdentityNumber = userIdentityNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
