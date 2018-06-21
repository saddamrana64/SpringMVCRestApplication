package com.model.object;

public class Banks {

	private int bankId;
	private String bankName;
	private String adminAccessId;
	private String adminAccessPwd;

	public Banks(int bankId, String bankName, String adminAccessId, String adminAccessPwd) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.adminAccessId = adminAccessId;
		this.adminAccessPwd = adminAccessPwd;
	}

	public String getAdminAccessId() {
		return adminAccessId;
	}

	public void setAdminAccessId(String adminAccessId) {
		this.adminAccessId = adminAccessId;
	}

	public String getAdminAccessPwd() {
		return adminAccessPwd;
	}

	public void setAdminAccessPwd(String adminAccessPwd) {
		this.adminAccessPwd = adminAccessPwd;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

}
