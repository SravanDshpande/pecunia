package com.cg.pecunia.dao;

import com.cg.pecunia.bean.Account;
import com.cg.pecunia.exception.AccountException;

public interface AccountDao {
	
	public long addAccount(Account account) throws AccountException;
	public Account updateAccountByNumber(long accountNumber,String name,long contact,String address)throws AccountException;
	public Account deleteAccountByNumber(long accountNumber)throws AccountException;

}
