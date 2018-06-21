package com.model.object;

import java.util.List;

public class Account {
	private int accountId;
	private String accountName;
	private int bankId;
	private List<Transaction> transaction;
	
	
	
	public List<Transaction> getTransaction() {
		return transaction;
	}
	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public Account(int accountId, String accountName, int bankId, List<Transaction> transaction) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.bankId = bankId;
		this.transaction = transaction;
	}
	
	
	
	
	
}
