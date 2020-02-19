package com.cg.pecunia.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.pecunia.bean.Account;
import com.cg.pecunia.exception.AccountException;

public class AccountDaoMapImp  implements AccountDao{
private Map<Integer,Account> map;
public AccountDaoMapImp()
{
	map=new HashMap<Integer,Account> ();
}
public int addAccount(Account account) throws AccountException {
	if(map.containsKey(account.getAccountNumber()))
		throw new AccountException("Id already exists");
	else
		map.put( account.getAccountNumber(), account);
	return account.getAccountNumber();



}

public Account updateAccountByNumber(int accountNumber,Account account) throws AccountException {
	Account updateaccount=map.get(accountNumber);
	System.out.println(updateaccount);
	if(map.containsKey(account.getAccountNumber()))
	{
		
		updateaccount.setAccountName(account.getAccountName());
		updateaccount.setContactNumber(account.getContactNumber());
		updateaccount.setAddress(account.getAddress());
		updateaccount.setAccountNumber(accountNumber);
		
	}
	updateaccount=map.replace(accountNumber, updateaccount);
	return updateaccount;
	
}

public int deleteAccountByNumber(int accountNumber) throws AccountException {
	Account account=null;
	if(!map.containsKey(accountNumber))
		map.remove(accountNumber);
	else
		throw new AccountException("Id not found");
	
	
	return accountNumber;




}
public List<Account> listAccounts() throws AccountException {
	
	Collection<Account> collection=map.values();
	List<Account> list=new ArrayList<Account>();
	for(Account a:collection)
		list.add(a);
	
	return list;
}
	
	
	}

	

	

	
	


