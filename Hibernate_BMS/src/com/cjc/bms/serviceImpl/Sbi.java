package com.cjc.bms.serviceImpl;

import com.cjc.bms.model.Account;
import com.cjc.bms.service.Rbi;
import com.config.HibernateUtil;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Sbi implements Rbi {

	Scanner sc=new Scanner(System.in);
	Account a=new Account();
	
	@Override
	public void createAccount() {
	System.out.println("Create Account");	
		
	System.out.println("Enter 10 digits account number ");
	String accno=sc.next();
	a.setAccNo(accno);
	
	System.out.println("Enter name");
	String name=sc.next();
	a.setName(name);
	
	System.out.println("Enter mobno");
	String mobno=sc.next();
	a.setMobNo(mobno);
	
	System.out.println("Enter adharno");
	String adharno=sc.next();
	a.setAdharNo(adharno);
	
	System.out.println("Enter gender");
	String gender=sc.next();
	a.setGender(gender);
	
	System.out.println("Enter age");
	int age=sc.nextInt();
	a.setAge(age);
	
	System.out.println("Enter balance");
	double balance=sc.nextDouble();
    a.setBalance(balance);
    
    Session session=HibernateUtil.getSessionFactory().openSession();
    
    session.persist(a);
    
    session.beginTransaction().commit();
    
    }

	@Override
	public void AllDetails() {
		
		System.out.println("Dispaly All Details");
		
		System.out.println("Enter Account No");
		String accNo=sc.next();
		
	Session session=HibernateUtil.getSessionFactory().openSession();
	
	String hql="from Account where accNo=:accNo";
		    
	  Query<Account> query=session.createQuery(hql, Account.class);
		
	 query.setParameter("accNo", accNo);
	 List<Account> list=query.getResultList();
		
			
	list.forEach((s)->{
		
		System.out.println(s);
	});
		   }

	@Override
	public void depositeMoney() {
		
		System.out.println("Deposite Money");
		
		System.out.println("Enter Account No");
		String accNo=sc.next();
		
		System.out.println("Enter Deposite Amount");
		double amount=sc.nextDouble();
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		
		String hql = "update Account set balance = balance + :amount where accNo = :accNo";
		Query<Account> query=session.createQuery(hql);
		
	
		query.setParameter("amount", amount);
	    query.setParameter("accNo", accNo);
		Transaction tx=session.beginTransaction();
		query.executeUpdate();
		
		tx.commit();
		
		   
	}

	@Override
	public void withdrawal() {

		
		System.out.println("Withdrawal Money");
		
		System.out.println("Enter Account No");
		String accNo=sc.next();
		
		System.out.println("Enter Withdrawal Amount");
		double amount=sc.nextDouble();
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		
		String hql = "update Account set balance = balance - :amount where accNo = :accNo";
		Query<Account> query=session.createQuery(hql);
		
	
		query.setParameter("amount", amount);
	    query.setParameter("accNo", accNo);
		Transaction tx=session.beginTransaction();
		query.executeUpdate();
		
		tx.commit();
		
		
	}

	@Override
	public void balanceCheck() {
		
		System.out.println("Check Balance");
		
		System.out.println("Enter Account No");
		String accNo=sc.next();
		
        Session session=HibernateUtil.getSessionFactory().openSession();
		
		String hql = "from Account where accNo=:accNo";
		
        Query<Account> query=session.createQuery(hql, Account.class);
		
		query.setParameter("accNo", accNo);
		
		Account a=query.getSingleResult();
		
		System.out.println(a.getBalance());
		
		
	   }		
}
