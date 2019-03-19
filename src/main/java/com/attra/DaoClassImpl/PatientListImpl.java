package com.attra.DaoClassImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attra.Model.Appointmentdetail;
import com.attra.Model.Doctordetail;
@Repository("PatientListInterface")
public class PatientListImpl implements PatientListInterface{
	@Autowired
	SessionFactory factory;
	@Transactional
	public List getPatientList(String email)
	{
		
		Date date = new Date();
		Date date1 = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");
		 String strDate= formatter.format(date);
		 System.out.println(strDate);
		 try {
			 date1=formatter.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(date1);
		//out.print(strDate);
		//String doctorId="null";
		int did=0;
		Session session=factory.getCurrentSession();
		Doctordetail doctorDetail=new Doctordetail();
		//String email=adminLogin.getDoctorEmail().toString();
		//Query query=session.createSQLQuery("select DoctorName from doctordetails where DoctorEmail="+email);
		Query query=session.createQuery("select d.doctorId from Doctordetail d where d.doctorEmail=:email");
		query.setParameter("email", email);
		
		List name1=query.list();
		Iterator it=name1.iterator();
		while(it.hasNext())
		{
			//Object o=it.next();
			//Doctordetail d=(Doctordetail) it.next();
			//doctorId=(String) it.next();
			did=(Integer) it.next();
			//did=Integer.parseInt(doctorId);
		}
		//where a.appointmentDate=:sysdate select a.appointmentId,a.patientName,a.appointmentDate,a.timeSlot,a.status
		Appointmentdetail appointmentDetail=new Appointmentdetail();
		Query query1=session.createQuery(" from Appointmentdetail where DoctorId="+did);
		//query1.setParameter("doctorid", did);
		//query1.setp
		List<Appointmentdetail> patientlist=query1.list();
		
		//appointmentDetail=(Appointmentdetail) session.get(Appointmentdetail.class, did);
		return patientlist;
	}

}
