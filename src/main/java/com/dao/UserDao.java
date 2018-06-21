package com.dao;

import java.util.List;

import org.springframework.dao.InvalidDataAccessResourceUsageException;

import com.model.object.User;

public interface UserDao {
	void registerUser(User um)throws InvalidDataAccessResourceUsageException;
	List<User> getAllUser();
}
