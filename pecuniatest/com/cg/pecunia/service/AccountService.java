package com.cg.pecunia.service;



import java.util.List;

import com.cg.pecunia.bean.Account;
import com.cg.pecunia.exception.AccountException;

public interface AccountService {
	
	public int addAccount(Account account) throws AccountException;
	
	public Account updateAccountByNumber(int accountNumber,Account account)throws AccountException;
	
	public int deleteAccountByNumber(int accountNumber)throws AccountException;

	public boolean validateName(String accountName)throws AccountException;
	
	public List<Account> listAccounts() throws AccountException; 
}
