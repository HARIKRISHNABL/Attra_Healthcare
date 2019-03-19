package com.attra.Controller;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.attra.DaoClassImpl.CancellationInterface;
import com.attra.DaoClassImpl.ConformationInterface;
import com.attra.Utils.EmailSendingInterface;
import javax.swing.JOptionPane;
/*import javafx.scene.control.Dialogs;
import javafx.stage.Stage;*/
/*import javafx.application.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;*/
@Controller 
public class PatientAppointmentController {

	@Autowired
	@Qualifier("EmailSendingInterface")
	EmailSendingInterface emailtopatient;
	@Autowired
	@Qualifier("ConformationInterface")
	ConformationInterface ab;
	@RequestMapping(value="/logout")

	public String logoutSuccess()
	{
		return "AdminLogin";
	}
	@RequestMapping(value="/conform",method=RequestMethod.POST)
	public String decisionFunction(HttpServletRequest request,HttpServletResponse response)
	{
		try {
		int success=0;
		if(request.getParameter("conform")!=null)
		{
			success=patientConform(request, response);
			
		}
		else if(request.getParameter("cancel")!=null)
		{
			success=patientCancel(request, response);
			
		}
		if(success!=0)
			return "GetPatientList";
			else
				return "ExceptionPage";
	}
	
	catch(Exception e)
	{
		return "GetPatientList";
	}
		
	}
	public int patientConform(HttpServletRequest request,HttpServletResponse response)
	{
		
		String[] strarray = new String[10];
		int success=0;
		System.out.println("hello");
		try {
			 strarray=request.getParameterValues("checkedvalues");
		
		Integer[] intarray=new Integer[strarray.length];
		int j=0;
	
			
					
		for(String str:strarray)
			 {
			
				
			intarray[j]=Integer.parseInt(str);
			
			System.out.println(intarray[j]);
			try {
				emailtopatient.sendEmail(intarray[j],"confirmed");
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			success=ab.updateStatus(intarray[j],"confirmed");
			
			j++;
			}
		}catch(NullPointerException e)
		{
			/*@SuppressWarnings("restriction")
			Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("warni");
	        alert.setHeaderText("hai hello");
	        alert.setContentText("check box u have to select");
	        alert.showAndWait();*/
			//Dialogs.showConfirmDialog(stage, "hello", "how are you");
			JOptionPane.showMessageDialog(null, "hai hello", "welcome", JOptionPane.WARNING_MESSAGE);
		}
		
		return success;
		
	}
		
	
	
	@Autowired
	@Qualifier("CancellationInterface")
	CancellationInterface xy;
	public int patientCancel(HttpServletRequest request,HttpServletResponse response)
	{
		
		System.out.println("hello");
		String strarray[]=request.getParameterValues("checkedvalues");
		Integer[] intarray=new Integer[strarray.length];
		int j=0;
	
			int success=0;
					
		for(String str:strarray)
			 {
			intarray[j]=Integer.parseInt(str);
			System.out.println(intarray[j]);
			try {
				emailtopatient.sendEmail(intarray[j],"cancelled");
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			success=xy.updateStatusToCancel(intarray[j],"cancelled");
			j++;
			}
		return success;
		
	}
}






