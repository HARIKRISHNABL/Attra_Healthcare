package com.attra.DaoClassImpl;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attra.Model.Appointmentdetail;
import com.attra.Model.Departmentdetail;
import com.attra.Model.Doctoravailability;
import com.attra.Model.Doctordetail;
import com.attra.Model.Hospitaldetail;
import com.attra.Model.Userregistration;


@Repository("CustomerDAO")
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	 SessionFactory sessionFactory;
	
	/*@Transactional
 public List<Hospitaldetail> getCustomers() {
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query thequery=currentSession.createQuery("from Hospitaldetail");
		
		
		List <Hospitaldetail>customers=thequery.list();
		return customers;
	}

	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Departmentdetail> getDepartmentdetail(int id) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query thequery=currentSession.createQuery("from Departmentdetail where HospitalId="+id);
		List<Departmentdetail> customers = thequery.list();
		
		List <Departmentdetail> customers =  (List<Departmentdetail>) currentSession.get(Departmentdetail.class, id);
		return customers;
	}*/

	@Transactional
	public boolean saveData(int hospId, int depId, int docId, String schDelId, String doctorAvail,String patientname,int patientid) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		//Date date=null;
		
		Query thequery=currentSession.createQuery("from Doctoravailability where DoctorId="+docId);
		List<Doctoravailability> patientCounts = thequery.list();
		int patientCount=patientCounts.get(0).getAttendingPatient();
		System.out.println("patient count : "+patientCount);
		
		
		if(patientCount==0)
			return false;
		else {
		
			thequery=currentSession.createQuery("from Departmentdetail where DeptId="+depId);
			List<Departmentdetail> customers = thequery.list();
			String s1=customers.get(0).getDeptName();
			System.out.println("Dept Name : "+s1);
			
		
			thequery=currentSession.createQuery("from Hospitaldetail where HospitalId="+hospId);
			List<Hospitaldetail>  customers1=thequery.list();
			String hospitalName=customers1.get(0).getHospitalName();
			System.out.println("Hos name"+ hospitalName);
			
			thequery=currentSession.createQuery("from Doctordetail where DoctorId="+docId);
			List<Doctordetail>  doctor = thequery.list();
			String doctorName = doctor.get(0).getDoctorName();
			System.out.println("Doc name"+ doctorName);
			
			thequery=currentSession.createQuery("from Doctoravailability where DoctorId="+docId);
			List<Doctoravailability>  fees = thequery.list();
			int doctorFees=fees.get(0).getConsultationFee();
			System.out.println("Doc fees"+ doctorFees);
			
			
			Appointmentdetail appointmentdetail=new Appointmentdetail();
			Userregistration userregistration = new Userregistration();
			userregistration.setPatientId(patientid);
			Doctordetail doctordetail =new Doctordetail();
			doctordetail.setDoctorId(docId);
			appointmentdetail.setUserregistration(userregistration);
			appointmentdetail.setDoctordetail(doctordetail);
			appointmentdetail.setPatientName(patientname);
			appointmentdetail.setDoctorName(doctorName);
			appointmentdetail.setHospitalName(hospitalName);
			
			
			String parsedDate = null;
				try {
	
					Date data = new SimpleDateFormat("MM/dd/yyyy").parse(schDelId);
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
					parsedDate = simpleDateFormat.format(data);
	
					System.out.println("parsed date : " + parsedDate);
	
				} catch (ParseException e) {
	
					e.printStackTrace();
				}
			appointmentdetail.setAppointmentDate(parsedDate);
			appointmentdetail.setTimeSlot(doctorAvail);
			appointmentdetail.setConsultationFee(doctorFees);
			appointmentdetail.setStatus("Pending");
			
			currentSession.save(appointmentdetail);
			
			int decrementCount=(patientCount-1);
			Doctoravailability doctoravailability=new Doctoravailability();
			doctoravailability=(Doctoravailability) currentSession.get(Doctoravailability.class, docId);
			doctoravailability.setAttendingPatient(decrementCount);
			
			currentSession.save(doctoravailability);
			
		}
		return true;
	}

}


