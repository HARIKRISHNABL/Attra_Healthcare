package com.attra.DaoClassImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attra.Model.Adminlogin;
import com.attra.Model.Doctordetail;



@Repository("AdminLoginInterface")
public class AdminLoginImpl implements AdminLoginInterface{
	@Autowired
	SessionFactory factory;
	//int success=0;
	
	@Transactional
	public boolean AdminLoginCheck(Adminlogin adminLogin)
	{
		Session session=factory.getCurrentSession();
		Adminlogin adminLogin1=new Adminlogin();
		//Query query=session.createQuery("from Adminlogin a where a.doctorEmail=:doctorEmail and a.password=:password");
		/*Query query=session.createSQLQuery("select * from adminlogin where DoctorEmail=? and Password=?" );
		query.setParameter("doctorEmail", adminLogin.getDoctorEmail());
		query.setParameter("password", adminLogin.getPassword());
		List result=(List) query.list();*/
		adminLogin1=(Adminlogin) session.get(Adminlogin.class, adminLogin.getDoctorEmail());
		if(adminLogin1!=null)
		{
		if(adminLogin1.getPassword().equals(adminLogin.getPassword())==true)
		{
			
		return true;
		}
		}
		
			return false;
		
	}
	

}
