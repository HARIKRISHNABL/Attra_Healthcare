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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.attra.DaoClassImpl.DoctorNameRetrieval;
import com.attra.DaoClassImpl.PatientNameRetrieval;
import com.attra.DaoClassImpl.UserDao;

import com.attra.Model.Userlogin;
import com.attra.Model.Userregistration;

@Controller
public class UserLoginController  {
	@Autowired 
	@Qualifier("PatientNameRetrieval")
	PatientNameRetrieval doctordao;
	@Autowired 
	@Qualifier("PatientNameRetrieval")
	PatientNameRetrieval doctordao1;
	@Autowired 
	@Qualifier("UserDao")
	UserDao userdao2;
	@RequestMapping(value="/login")
	public String disc1()
	{
		return "Login";
	}
	@RequestMapping(value="/error-page")
	public String disc()
	{
		return "Login";
	}
@RequestMapping(value="/login",method=RequestMethod.GET)
public ModelAndView dispaly1()
{
	return new ModelAndView("Login","command",new Userlogin());
	
}
//@RequestParam String email,@RequestParam String password,
@RequestMapping(value="/login",method=RequestMethod.POST)
public String display(Userlogin userlogin ,Model model,HttpServletRequest request,HttpServletResponse response)
{
	HttpSession session=request.getSession(true);
boolean result= userdao2.UserLoginCheck(userlogin);
if(result==true)
{
	 String patientname= doctordao.patientName(userlogin.getEmail().toString());
	 session.setAttribute("PatientName", patientname);
	 int patientid= doctordao1.patientIdRetrieval(userlogin.getEmail().toString());
	 session.setAttribute("patientid", patientid);
	//int id=list.get(0).getPatientId();
	//String name=list.get(1).getPatientName();
	//System.out.println(id);
	System.out.println(patientname);
	return "redirect";
}
else
{
	 return "error";
}


}

}



