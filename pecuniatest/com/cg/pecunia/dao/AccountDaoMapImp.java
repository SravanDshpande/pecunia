package com.cg.pecunia.dao;

import java.util.Map;

import com.cg.pecunia.bean.Account;
import com.cg.pecunia.exception.AccountException;

public class AccountDaoMapImp  implements AccountDao{
private Map<Long,Account> map;

public long addAccount(Account account) throws AccountException {
	if(map.containsKey(account.getAccountNumber()))
		throw new AccountException("Id already exists");
	else
		map.put( account.getAccountNumber(), account);
	return account.getAccountNumber();



}

public Account updateAccountByNumber(long accountNumber,String name,long contact,String address) throws AccountException {
	Account account=map.get(accountNumber);
	
	if(map.containsKey(account.getAccountNumber()))
	{
		
		account.setAccountName(name);
		account.setContactNumber(contact);
		account.setAddress(address);
		
	}
	map.replace(accountNumber, account);
	return account;
	
}

public Account deleteAccountByNumber(long accountNumber) throws AccountException {
	Account account=null;
	if(map.containsKey(accountNumber))
		account=map.remove(accountNumber);
	else
		throw new AccountException("Id not found");
	
	
	return account;
}




	
	
	}

	

	

	
	


