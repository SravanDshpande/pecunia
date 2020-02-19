package com.cg.pecunia.service;

import java.util.List;
import java.util.Random;

import com.cg.pecunia.bean.Account;
import com.cg.pecunia.dao.AccountDao;
import com.cg.pecunia.dao.AccountDaoMapImp;
import com.cg.pecunia.exception.AccountException;

public class AccountServiceImp implements AccountService {

	private AccountDao accountdao;

	public AccountServiceImp() {
		accountdao = new AccountDaoMapImp();
	}

	public int addAccount(Account account) throws AccountException {
		if (validateName(account.getAccountName()))
			throw new AccountException("Name should have alphabets");
		Random random = new Random();

		int accnumber = random.nextInt(100000000) + 1000000000;
		account.setAccountNumber(accnumber);
		return accnumber;
	}

	public Account updateAccountByNumber(int accountNumber, Account account) throws AccountException {

		return accountdao.updateAccountByNumber(accountNumber, account);
	}

	public int deleteAccountByNumber(int accountNumber) throws AccountException {
		//String accnum = String.valueOf(accountNumber);
		//if (accnum.matches("[0-9]{10}"))
			//throw new AccountException("Id should be of 10 digit");
		return accountdao.deleteAccountByNumber(accountNumber);
	}

	public boolean validateName(String accountName) throws AccountException {
		return accountName.matches("[A-Za-z]+");

	}

	public List<Account> listAccounts() throws AccountException {
		
		return accountdao.listAccounts();
	}

}
