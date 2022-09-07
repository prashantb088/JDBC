/**
 * Illustrating BANK MANAGEMENT SYSTEM TO CREATE BANK ACCOUNT ADD ACCOUNT DETAILS TO DATABASE AND PRINT DATA OF ONE OR ALL ACCOUNT USING DATA ACCESS OBJECT
 * PERFORMING MONEY DEPOSIT AND MONEY WITHDRAWING FROM ACCOUNT BALANCE
 * By Prashant Bansal
 */

package com.slot2jdbc;
import java.util.*;


public class bankingmain {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner bs = new Scanner(System.in);
		bankingdao dao = new bankingdao();
		bankingCustomer b1 = new bankingCustomer();
		
		System.out.println("\t\t-----Welcome to Indian Bank-----");
		
		System.out.println("Select Operation : \n1 for Register Account\n2 for Login");
		int op = bs.nextInt();
		
		switch(op) {
		
		case 1->{
			//Creating New Account
			System.out.println("Enter Customer Details to create new Account");
			System.out.print("Enter Customer Name");
			String cname = bs.next();
			System.out.print("Create Customer Password");
			String cpwd = bs.next();
			System.out.print("Enter Customer Phone");
			String cphone = bs.next();
			System.out.print("Enter Acc balance");
			int caccbal = bs.nextInt();
			b1.cname = cname;
			b1.cpassword = cpwd;
			b1.cphone = cphone;
			b1.caccbal = caccbal;
			
			dao.connect();
			int res=dao.registerCustomer(b1);
			if(res!=0) {
				System.out.println("Account Created");
			}
			else {
				System.out.println("Something went wrong,Please tryagain");
				
			}
			
		}
		
		case 2->{
			//Login into my Account
			System.out.println("Enter Customer Details to Login : ");
			System.out.print("Enter Customer Name : ");
			String cname = bs.next();
			System.out.print("Enter Customer Password : ");
			String cpwd = bs.next();
			
			dao.connect();
			int res = dao.login(cname , cpwd);
			if(res==0) {
				System.out.println("Wrong Username or password!!!");
				
			}
			else if(res==-1) {
				System.out.println("Account not found\n Please register yourself");
				
			}
			else {
				System.out.println("Login success!!!");
				
				//We are giving access to Withdraw or Deposit
				System.out.println("Select Operation :\n1 for Withdraw \n2 for deposit");
				int op2 = bs.nextInt();
				switch(op2) {
				
				case 1->{
					//Withdraw Amount
					System.out.println("Enter amount to withdraw : ");
					int amt = bs.nextInt();
					int res2 = dao.withdraw(res,amt);
					if(res2<=0) {
						System.out.println("Something went wrong");
						
					}
					else {
						System.out.println("Withdraw done");
					}
					
				 }
				 }
				
			}
			}
		    }
		
		bs.close();
		}
		
}

