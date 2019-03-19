package com.attra.DaoClassImpl;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attra.Model.Departmentdetail;
import com.attra.Model.Userregistration;
@Repository("PatientNameRetrieval")
public class PatientNameRetrievalImpl implements PatientNameRetrieval{
	@Autowired
	 SessionFactory sessionFactory;
	@Transactional
	public String patientName(String email)
	{
		String patient=null;
		Session currentSession=sessionFactory.getCurrentSession();
		Query thequery=currentSession.createQuery("select u.patientName from Userregistration u where u.email=:email");
		thequery.setParameter("email", email);
		List patients = thequery.list();
		Iterator it=patients.iterator();
		while(it.hasNext())
		{
			//Object o=it.next();
			//Doctordetail d=(Doctordetail) it.next();
			patient=(String) it.next();
		}
		return patient;
	}
	@Transactional
	public int patientIdRetrieval(String email)
	{
		
		int patientid=0;
		
		Session currentSession=sessionFactory.getCurrentSession();
		Query thequery=currentSession.createQuery("select u.patientId from Userregistration u where u.email=:email");
		thequery.setParameter("email", email);
		List patients1 = thequery.list();
		Iterator it=patients1.iterator();
		while(it.hasNext())
		{
			//Object o=it.next();
			//Doctordetail d=(Doctordetail) it.next();
			patientid=(Integer)it.next();
		}
		return patientid;
	}

}
