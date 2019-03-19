package com.attra.DaoClassImpl;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attra.Model.Adminlogin;
import com.attra.Model.Doctordetail;
@Repository("DoctorNameRetrieval")
public class DoctorNameRetrievalImpl implements DoctorNameRetrieval{
	@Autowired
	SessionFactory factory;
	@Transactional
	public String doctorNameReteieval(Adminlogin adminLogin)
	{
		String name="null";
		Session session=factory.getCurrentSession();
		Doctordetail doctorDetail=new Doctordetail();
		String email=adminLogin.getDoctorEmail().toString();
		//Query query=session.createSQLQuery("select DoctorName from doctordetails where DoctorEmail="+email);
		Query query=session.createQuery("select d.doctorName from Doctordetail d where d.doctorEmail=:email");
		query.setParameter("email", email);
		
		List name1=query.list();
		Iterator it=name1.iterator();
		while(it.hasNext())
		{
			//Object o=it.next();
			//Doctordetail d=(Doctordetail) it.next();
			name=(String) it.next();
		}
		
		//name=name1.get(2).toString();
		//doctorDetail=(Doctordetail) session.get(Doctordetail.class, email);
		//String name=doctorDetail.getDoctorName().toString();
		System.out.println(name);
		return name;
	}
}
