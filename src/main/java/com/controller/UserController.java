package com.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.exceptionHandler.UserAlreadyExistsException;
import com.model.object.Account;
import com.model.object.AccountFetchObject;
import com.model.object.BankFetchObject;
import com.model.object.Banks;
import com.model.object.User;
import com.service.UserService;

/**
 * Handles requests for the Employee service.
 */
@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public @ResponseBody User registerUser(@RequestBody User user) {
		logger.info("Start createUser.");
			service.registerUser(user);
		return user;
	}
	
	@RequestMapping(value = "/banks", method = RequestMethod.POST)
	public @ResponseBody Map<Integer,String> getBanksList(@RequestBody User user) {
		logger.info("getting bank list.");
		return service.getBanks(user);
	}
	
	@RequestMapping(value = "/bank", method = RequestMethod.POST)
	public @ResponseBody Banks getBankDetails(@RequestBody BankFetchObject bankFetchObject) {
		logger.info("getting banks metaData.");
		return service.getBanksMetaData(bankFetchObject);
	}
	
	@RequestMapping(value = "/accounts", method = RequestMethod.POST)
	public @ResponseBody List<Account> getAccounts(@RequestBody AccountFetchObject accountFetchObject) {
		logger.info("getting account list.");
		return service.getAccounts(accountFetchObject);
	}
	
}
