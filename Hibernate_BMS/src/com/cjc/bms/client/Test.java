package com.cjc.bms.client;

import java.util.Scanner;

import com.cjc.bms.service.Rbi;
import com.cjc.bms.serviceImpl.Sbi;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Rbi rbi=new Sbi();
			
		         while(true) {
				 
		         System.out.println("1. Create Account");
				 System.out.println("2. Dispaly All Details");
				 System.out.println("3. Deposite Money");          
				 System.out.println("4. Withdrawal Money");
				 System.out.println("5. Check Balance");
				
				 System.out.println("Enter your choice");
				 int ch=sc.nextInt();
				 
		         switch(ch) {                     
		             
		             case 1:
		            	 rbi.createAccount();
		            	 break;
		             
		             case 2:
		            	 rbi.AllDetails();
		            	 break;
		             
		             case 3:
		            	 rbi.depositeMoney();
		            	 break;
		            	 
		             case 4:
		            	 rbi.withdrawal(); 
		            	 break;
		            	 
		             case 5:
		            	 rbi.balanceCheck();
		            	 break;
		             
		             default :
		            	  System.out.println("Invalid choice, please enter valid choice");
		             }
			}
   
	}
    }


