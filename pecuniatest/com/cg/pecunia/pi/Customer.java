package com.cg.pecunia.pi;

import java.util.Scanner;

import com.cg.pecunia.bean.Account;
import com.cg.pecunia.exception.AccountException;
import com.cg.pecunia.service.AccountService;
import com.cg.pecunia.service.AccountServiceImp;

public class Customer {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Account account=null;
		AccountService acountservice=new AccountServiceImp();
		while(true)
		{
			System.out.println("1. Add Account");
			System.out.println("2. Update Account");
			System.out.println("3.Delete Account");
			System.out.println("4. Exit");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
			try
			{
				
				System.out.println("Please Enter account Name");
				String name = sc.nextLine();
				System.out.println("Please Enter Address");
				String address = sc.nextLine();
				System.out.println("Please Enter Contact");
				long contact=sc.nextLong();
				
				account.setAddress(address);
				account.setAccountName(name);
				account.setContactNumber(contact);
				account.setBalance(0);
				
			
				long accnumber = acountservice.addAccount(account); 
				
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
					System.out.println("Please Enter account Number");
					long accountNumber=sc.nextLong();
					System.out.println("Please Enter account Name");
					String name = sc.nextLine();
					System.out.println("Please Enter Address");
					String address = sc.nextLine();
					System.out.println("Please Enter Contact");
					long contact=sc.nextLong();
					account=acountservice.updateAccountByNumber(accountNumber,name,contact,address);
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
					long accountNumber=sc.nextLong();
					account = acountservice.deleteAccountByNumber(accountNumber);
					System.out.println("deleted account sucessfully! :(");
					
					
				}
				catch(AccountException e)
				{
					System.err.println(e.getMessage());
				}break;
			case 4:
				System.out.println("thank you");
				return;
		}
		}
	}}

