package com.model.object;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
@Entity
@Table(name="user_info")
public class User implements Serializable{

	private static final long serialVersionUID = -7788619177798333712L;
	
	@Id
	private int identityNumber;
	@Column
	private String name;
	@Column
	private int age;
	@Column
	private String userName;
	@Column
	private String password;
	
	
	
	public int getIdentityNumber() {
		return identityNumber;
	}
	public void setIdentityNumber(int identityNumber) {
		this.identityNumber = identityNumber;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
}
