package com.cg.pecunia.pi;

import java.util.List;
import java.util.Scanner;

import com.cg.pecunia.bean.Account;
import com.cg.pecunia.exception.AccountException;
import com.cg.pecunia.service.AccountService;
import com.cg.pecunia.service.AccountServiceImp;

public class Customer {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Account account= new Account();
		AccountService acountservice=new AccountServiceImp();
		List<Account> list=null;
		while(true)
		{
			System.out.println("1. Add Account");
			System.out.println("2. Update Account");
			System.out.println("3. Delete Account");
			System.out.println("4. list all");
			System.out.println("5. Exit");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
			try
			{
				
				System.out.println(account);
				System.out.println("Please Enter account Name");
				String name = sc.nextLine();
				account.setAccountName(name);
				sc.nextLine();
				System.out.println("Please Enter Address");
				String address = sc.nextLine();
				account.setAddress(address);
				System.out.println("Please Enter Contact");
				long contact=sc.nextLong();
				account.setContactNumber(contact);
          	
				
			
				int accnumber = acountservice.addAccount(account); 
				
				System.out.println("accountNumber = "+accnumber);
				
				
			
			}
			catch(AccountException e)
			{
				System.err.println(e.getMessage());
			}
			break;
			case 2:
				try
				{
					System.out.println(account);
					System.out.println("Please Enter account Number");
					int accountNumber=sc.nextInt();
					sc.nextLine();
				
					System.out.println("Please Enter account Name");
					String name = sc.nextLine();
				      account.setAccountName(name);
					System.out.println("Please Enter Address");
					String address = sc.nextLine();
					account.setAddress(address);
					System.out.println("Please Enter Contact");
					long contact=sc.nextLong();
					account.setContactNumber(contact);
					account=acountservice.updateAccountByNumber(accountNumber,account);
					System.out.println("updated details");
					System.out.println("name = "+name);
					System.out.println("contact = "+contact);
					System.out.println("address = "+address);
				}
				catch(AccountException e)
				{
					System.err.println(e.getMessage());
				}
				break;
			case 3:
				try
				{
					System.out.println("Please Enter account number");
					int accountNumber=sc.nextInt();
					
					System.out.println("deleted account sucessfully! "+acountservice.deleteAccountByNumber(accountNumber));
					
					
				}
				catch(AccountException e)
				{
					System.err.println(e.getMessage());
				}break;
			case 4:
				try
				{
					list=acountservice.listAccounts();
					for(Account a:list)
					{
						System.out.println(a.getAccountNumber());
					}
				}
				
				catch(AccountException e)
				{
					System.err.println(e.getMessage());
				}break;
				
			case 5:
				System.out.println("thank you");
				return;
		}
		}
	}}

