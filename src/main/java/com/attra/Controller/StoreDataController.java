package com.attra.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.attra.DaoClassImpl.CustomerDAO;
import com.attra.Model.ReturnMessage;

@Controller
public class StoreDataController {
	
	@Autowired
	private CustomerDAO customerDAO;
	boolean i;
	@RequestMapping(value="/storeData",method=RequestMethod.POST)
	public @ResponseBody String storeData(Model model,@RequestParam("hospId") int hospId,
			@RequestParam("depId") int depId,@RequestParam("docId") int docId,
			@RequestParam("schDelId") String schDelId,@RequestParam("doctorAvail") String doctorAvail,
			HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		/*try {
		
		
		if(patientname!=null)
		
		{*/
			try {
				
		HttpSession session=request.getSession();
		String patientname=session.getAttribute("PatientName").toString();	
		if(patientname!=null) 
		System.out.println("print");
		System.out.println(hospId);
		System.out.println(depId);
		System.out.println(docId);
		System.out.println(schDelId);
		System.out.println(doctorAvail);
		System.out.println(request.getAttribute("PatientName"));
		model.addAttribute("PatientName",session.getAttribute("PatientName").toString());
		String strpatientid= session.getAttribute("patientid").toString();
		int patientid=Integer.parseInt(strpatientid);
		
			 i = customerDAO.saveData(hospId,depId,docId,schDelId,doctorAvail,patientname,patientid);
			 	System.out.println(i);
	
			 	return "success";
	}
			catch(Exception e)
			{
		   return "Login";
				
			}
	}
}
		
		
		
			
	
		/*if(i==true)
		{
		JOptionPane.showMessageDialog(null, "Your request has been sent to doctor for fixing an appointment.\n                     Please wait for email confirmation");*/	
			//return "userLanding";	
		/*}
		else
		{
			JOptionPane.showMessageDialog(null, "Doctor is not available.Try for some other date");	
			return "userLanding";
			
			
		}*/
			/*if(i==true)
			{
				return 1;
			}
			else
			{
				return 0;
			}		*/
		
	
		
