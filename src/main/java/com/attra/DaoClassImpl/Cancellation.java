package com.attra.DaoClassImpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attra.Model.Appointmentdetail;
@Repository("CancellationInterface")
public class Cancellation implements CancellationInterface{
	@Autowired
	SessionFactory factory;
	
	@Transactional
	public int updateStatusToCancel(int appointmentId,String status)
	{
		Session session;
		System.out.println("welcome");
		session =factory.getCurrentSession(); 
		Appointmentdetail appointmentDetail=new Appointmentdetail();
		appointmentDetail=(Appointmentdetail) session.get(Appointmentdetail.class, appointmentId);
		appointmentDetail.setStatus(status);
		int success=(Integer) session.save(appointmentDetail);
		return success;
	}

}
