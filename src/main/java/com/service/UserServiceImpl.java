package com.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.dao.UserDao;
import com.model.object.Account;
import com.model.object.AccountFetchObject;
import com.model.object.BankFetchObject;
import com.model.object.Banks;
import com.model.object.Transaction;
import com.model.object.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;

	Map<Integer, Banks> banksMap = new LinkedHashMap<>();
	Map<Integer, String> banks = new LinkedHashMap<>();
	List<Account> accounts = new ArrayList<>();
	List<Transaction> transactions = new ArrayList<>();
	{
		// addming bank details and meta data
		banksMap.put(1, new Banks(1, "Dena Bank", "adminDena", "AdminDena123$"));
		banksMap.put(2, new Banks(2, "Canara Bank", "admin", "adminCanara123$"));
		banksMap.put(3, new Banks(3, "State Bank", "admin", "adminState123$"));
		banksMap.put(4, new Banks(4, "Standard Charted Bank", "admin", "adminCharted123$"));
		banksMap.put(5, new Banks(5, "SEI Bank", "admin", "adminSEI123$123$"));
		banksMap.put(6, new Banks(6, "HDFC Bank", "admin", "adminHDFC123$"));
		banksMap.put(7, new Banks(7, "ICICI Bank", "admin", "adminICICI123$"));
		banksMap.put(8, new Banks(8, "Andhra Bank", "admin", "adminAndhra123$"));
		banksMap.put(9, new Banks(9, "Kotak Mahindra Bank", "admin", "adminKotak123$"));

		// adding bank details only i.e bankId and bankName
		for (Map.Entry<Integer, Banks> entry : banksMap.entrySet()) {
			banks.put(entry.getKey(), entry.getValue().getBankName());
		}

		// adding transactions
		transactions.add(new Transaction(1, "credit", 10000, 1));
		transactions.add(new Transaction(2, "debit", 7000, 1));
		transactions.add(new Transaction(3, "debit", 13250, 1));
		// adding transactions with account
		accounts.add(new Account(1, "Rana", 1, transactions));

		// clearing transactions to add new based on accounts
		transactions = new ArrayList<>();
		// adding transactions for accounts
		transactions.add(new Transaction(4, "credit", 1500, 2));
		transactions.add(new Transaction(5, "debit", 66000, 2));
		// adding transactions to accounts
		accounts.add(new Account(2, "Saddam", 2, transactions));

		// clearing transactions to add new based on accounts
		transactions = new ArrayList<>();
		// adding transactions for accounts
		transactions.add(new Transaction(6, "credit", 11000, 3));
		transactions.add(new Transaction(7, "credit", 12366, 3));
		transactions.add(new Transaction(8, "credit", 10000, 3));
		// adding transactions to accounts
		accounts.add(new Account(3, "Deepak", 2, transactions));

		// clearing transactions to add new based on accounts
		transactions = new ArrayList<>();
		// adding transactions for accounts
		transactions.add(new Transaction(9, "credit", 50000, 4));
		transactions.add(new Transaction(10, "debit", 10000, 4));
		// adding transactions to accounts
		accounts.add(new Account(4, "Parth", 2, transactions));

		// clearing transactions to add new based on accounts
		transactions = new ArrayList<>();
		// adding transactions for accounts
		transactions.add(new Transaction(11, "debit", 10000, 5));
		transactions.add(new Transaction(12, "debit", 10000, 5));
		transactions.add(new Transaction(13, "debit", 10000, 5));
		transactions.add(new Transaction(14, "debit", 10000, 5));
		// adding transactions to accounts
		accounts.add(new Account(5, "Bhupendra", 3, transactions));

		// clearing transactions to add new based on accounts
		transactions = new ArrayList<>();
		// adding transactions for accounts
		transactions.add(new Transaction(15, "credit", 10000, 6));
		transactions.add(new Transaction(16, "credit", 10000, 6));
		// adding transactions to accounts
		accounts.add(new Account(6, "Ankit", 6, transactions));

		// clearing transactions to add new based on accounts
		transactions = new ArrayList<>();
		// adding transactions for accounts
		transactions.add(new Transaction(17, "debit", 10000, 8));
		transactions.add(new Transaction(18, "debit", 10000, 8));
		transactions.add(new Transaction(19, "credit", 10000, 8));
		transactions.add(new Transaction(20, "credit", 10000, 8));
		transactions.add(new Transaction(21, "credit", 10000, 8));
		transactions.add(new Transaction(22, "credit", 10000, 8));
		transactions.add(new Transaction(23, "credit", 10000, 8));
		transactions.add(new Transaction(24, "credit", 10000, 8));
		// adding transactions to accounts
		accounts.add(new Account(7, "Sagar", 8, transactions));

		accounts.add(new Account(8, "Chandrashekhar", 9, new ArrayList<>()));

	}

	@Override
	public void registerUser(User user) throws InvalidDataAccessResourceUsageException {
		System.out.println("servcice");
		dao.registerUser(user);

	}

	@Override
	public Map<Integer, String> getBanks(User user) {
		for (User u : dao.getAllUser()) {
			if (user.getIdentityNumber() == u.getIdentityNumber() && user.getUserName().equals(u.getUserName())
					&& user.getPassword().equals(u.getPassword())) {
				return banks;
			}
		}

		return null;
	}

	@Override
	public Banks getBanksMetaData(BankFetchObject bankFetchObject) {
		for (User u : dao.getAllUser()) {
			if (bankFetchObject.getUserIdentityNumber() == u.getIdentityNumber()
					&& bankFetchObject.getUserName().equals(bankFetchObject.getUserName())
					&& bankFetchObject.getPassword().equals(bankFetchObject.getPassword())) {
				return banksMap.get(bankFetchObject.getBankId());
			}
		}
		return null;
	}

	@Override
	public List<Account> getAccounts(AccountFetchObject accountFetchObject) {
		List<Account> resultAccount = new ArrayList<>();
		for (Entry<Integer, Banks> bankMap : banksMap.entrySet()) {
			if (bankMap.getValue().getAdminAccessId().equals(accountFetchObject.getAdminUsername()) 
					&& bankMap.getValue().getAdminAccessPwd().equals(accountFetchObject.getAdminPassword())
					&& bankMap.getValue().getBankId() == accountFetchObject.getBankId()) {
						for(Account account:accounts){
							if(account.getBankId()==accountFetchObject.getBankId()){
								resultAccount.add(account);
							}
						}
			}
		}
		return resultAccount;
	}

}
