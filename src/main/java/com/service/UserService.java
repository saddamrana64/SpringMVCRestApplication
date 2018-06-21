package com.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.dao.InvalidDataAccessResourceUsageException;

import com.model.object.Account;
import com.model.object.AccountFetchObject;
import com.model.object.BankFetchObject;
import com.model.object.Banks;
import com.model.object.User;

public interface UserService {

	void registerUser(User user) throws InvalidDataAccessResourceUsageException;
	Map<Integer,String> getBanks(User user);
	Banks getBanksMetaData(BankFetchObject bankFetchObject);
	List<Account> getAccounts(AccountFetchObject accountFetchObject);
}
