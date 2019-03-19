package com.attra.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.attra.DaoClassImpl.PatientListInterface;
import com.attra.Model.Appointmentdetail;
@Controller
public class PatientListController {
	@Autowired
	@Qualifier("PatientListInterface")
	PatientListInterface patientListInterface;
	@RequestMapping(value="/patient-list",method=RequestMethod.GET)
	public String patientList(HttpServletRequest request,HttpServletResponse response,Model model)
	{
	
			try {
				HttpSession session=request.getSession();
				String doctorName=(String) session.getAttribute("doctorEmail");
				if(doctorName!=null) 
		System.out.println("hai");
		String email= session.getAttribute("Email").toString();
		System.out.println(email);
		List<Appointmentdetail> patientlist=patientListInterface.getPatientList(email);
		model.addAttribute("patientlist", patientlist);
		System.out.println(session.getAttribute("DoctorName").toString());
		model.addAttribute("DoctorName",session.getAttribute("DoctorName").toString());
		//request.setAttribute("patientlist", patientlist);
		System.out.println(patientlist.size());
		return "PatientAppointment";
	

	}
			
	catch(Exception e)
	{
   return "AdminLogin";
		
	}
			
	}
}