package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.exceptionHandler.UserAlreadyExistsException;
import com.model.object.User;
@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sf;
	
	@Override
	public void registerUser(User um) throws InvalidDataAccessResourceUsageException{
		for(User user:getAllUser()){
			if(user.getIdentityNumber()==um.getIdentityNumber()){
				exceptionHandler();
			}
		}
		sf.getCurrentSession().save(um);
	}
	
	
	@ResponseStatus(value=HttpStatus.CONFLICT)
	@ExceptionHandler(UserAlreadyExistsException.class)
	public void exceptionHandler() 
	{
		throw new  UserAlreadyExistsException("User already exist");
	}
	
	public List<User> getAllUser(){
		return sf.getCurrentSession().createQuery("from User").list();
	}

}
