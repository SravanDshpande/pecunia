package com.cg.pecunia.service;

import java.util.Random;

import com.cg.pecunia.bean.Account;
import com.cg.pecunia.dao.AccountDao;
import com.cg.pecunia.dao.AccountDaoMapImp;
import com.cg.pecunia.exception.AccountException;

public class AccountServiceImp implements AccountService{
	
	private AccountDao accountdao;
	public AccountServiceImp()
	{
		accountdao=new AccountDaoMapImp();
	}

	public long addAccount(Account account) throws AccountException {
		if(!validateName(account.getAccountName()))
			throw new AccountException("Name should have alphabets");
		Random random=new Random();
	
	long accnumber=random.nextLong()+10000000000l;
	account.setAccountNumber(accnumber);
		return accnumber;
	}

	public Account updateAccountByNumber(long accountNumber, String name, long contact, String address)
			throws AccountException {
		
		return accountdao.updateAccountByNumber(accountNumber, name, contact, address);
	}

	public Account deleteAccountByNumber(long accountNumber) throws AccountException {
		String accnum=String.valueOf(accountNumber);
		if(!accnum.matches("[0-9]{5}"))
			throw new AccountException("Id should be of 10 digit");
		return accountdao.deleteAccountByNumber(accountNumber);
					}

	public boolean validateName(String accountName) throws AccountException {
		return accountName.matches("[A-Za-z]+");
		
	}
	
	
	
	

}
