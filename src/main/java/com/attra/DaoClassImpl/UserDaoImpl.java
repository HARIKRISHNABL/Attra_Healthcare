/*package com.attra.DaoClassImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.attra.Model.Userlogin;
import com.attra.Model.Userregistration;
@Repository("UserDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory factory;
	int success=0;
	
	@Transactional
	public void register(Userregistration userReg)
	{
		Session session = factory.getCurrentSession();
		session.save(userReg);	
		System.out.println("hello");
		String email=userReg.getEmail();
		String password=userReg.getPassword();
		Userlogin userLog=new  Userlogin();
		userLog.setEmail(email);
		userLog.setPassword(password);
		session.save(userLog);		
		System.out.println("hello monika ");
	}
	
	@Transactional
	public boolean UserLoginCheck(Userlogin userlogin)
	{
		Session session = factory.getCurrentSession();
		Userlogin userlogin1 = new Userlogin();
		userlogin1 = (Userlogin) session.get(Userlogin.class, userlogin.getEmail());
		if(userlogin1!=null)
		{
			if(userlogin1.getPassword().equals(userlogin.getPassword()) == true)
		{
			return true;
		}
		}
		
			return false;
		
		
	}
	
}
*/




package com.attra.DaoClassImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.attra.Model.Userlogin;
import com.attra.Model.Userregistration;

import javassist.bytecode.Descriptor.Iterator;
@Repository("UserDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory factory;
	int success=0;
	
	@Transactional
	public boolean register(Userregistration userReg)
	{
		Session session = factory.getCurrentSession();
		Query qry = session.createQuery("select u.email from Userregistration u where email=?");
		qry.setParameter(0,userReg.getEmail());
		List l=qry.list();
		String demail = null;
		boolean result=true;
		java.util.Iterator itr=l.iterator();
		while(itr.hasNext())
		{
			demail=(String) itr.next();
			
		}
		if(demail==null)
		{
		session.save(userReg);
		System.out.println("hello");
		String email=userReg.getEmail();
		String password=userReg.getPassword();
		
		Userlogin userLog=new  Userlogin();
		userLog.setEmail(email);
		userLog.setPassword(password);
		session.save(userLog);		
		System.out.println("hello monika ");
		}
		else
		{
			result=false;
		}
		return result;
	}
	
	@Transactional
	public boolean UserLoginCheck(Userlogin userlogin)
	{
		Session session = factory.getCurrentSession();
		Userlogin userlogin1 = new Userlogin();
		userlogin1 = (Userlogin) session.get(Userlogin.class, userlogin.getEmail());
		if(userlogin1!=null)
		{
			if(userlogin1.getPassword().equals(userlogin.getPassword()) == true)
		{
			return true;
		}
		}
		
			return false;
		
		
	}
	
}
