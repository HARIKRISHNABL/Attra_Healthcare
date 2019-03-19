package com.attra.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.attra.DaoClassImpl.AdminLoginInterface;
import com.attra.DaoClassImpl.ConformationInterface;
import com.attra.DaoClassImpl.DoctorNameRetrieval;
import com.attra.Model.Adminlogin;

@Controller
//@RequestMapping(value="/adminLoginObj")

public class AdminLoginController{
	@Autowired
	@Qualifier("AdminLoginInterface")
	AdminLoginInterface adminloginInterface;
	@Autowired
	@Qualifier("DoctorNameRetrieval")
	DoctorNameRetrieval doctorNameRetrieval;
	@RequestMapping(value="/error-page2")
public String dis()
{
		return "AdminLogin";
}
	@RequestMapping(value="/adminlogin")
	public String dis1()
	{
			return "AdminLogin";
	}
@RequestMapping(value="/adminLogin",method=RequestMethod.GET)

	/*public String display(Model model)
	{ 
	System.out.println("hai");
	   model.addAttribute("adminLoginObj", new Adminlogin());
		return "index";
	}

@RequestMapping(value="/adminLogin",method=RequestMethod.POST)
public String display2( @ModelAttribute("adminLoginObj")Adminlogin admin)
{
	System.out.println("hai");
		int success=adminloginInterface.AdminLoginCheck();
		if(success!=0)
		return "PatientAppointment";
		else
			return "index";
}*/
//@RequestParam String doctorEmail,@RequestParam String password,
public ModelAndView dispaly1()
{
	return new ModelAndView("AdminLogin","command",new Adminlogin());
}
@RequestMapping(value="/adminLogin",method=RequestMethod.POST)

public String display(Adminlogin adminLogin,Model model,HttpServletRequest request,HttpServletResponse response)
	{
	HttpSession session=request.getSession(true);
	boolean success=adminloginInterface.AdminLoginCheck(adminLogin);
	if(success==true)
	{
		
		String doctorName=doctorNameRetrieval.doctorNameReteieval(adminLogin);
		session.setAttribute("Email", adminLogin.getDoctorEmail());
		session.setAttribute("DoctorName", doctorName);
		//model.addAttribute("DoctorName", doctorName);
		return "GetPatientList";
	}
	
	else
		return "Errormsg";
	}

}









































































