/*package com.attra.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.attra.DaoClassImpl.UserDao;
import com.attra.Model.Userregistration;
@Controller
public class RegistrationController {
@Autowired
UserDao userdao;
@Qualifier("UserDao")
@RequestMapping(value="/register",method=RequestMethod.GET)
public ModelAndView dispaly1()
{
	return new ModelAndView("Register","command",new Userregistration());
}

@RequestMapping(value="/register",method=RequestMethod.POST)
public String register(Userregistration userReg,HttpServletRequest request,HttpServletResponse response)
{
	HttpSession session=request.getSession(true);
	session.setAttribute("PatientId", userReg.getPatientId());
	session.setAttribute("PatientName", userReg.getPatientName());
	userdao.register(userReg);
	return "Login";
}


}
*/




package com.attra.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.attra.DaoClassImpl.UserDao;
import com.attra.Model.Userregistration;
@Controller
public class RegistrationController {
@Autowired
UserDao userdao;
@Qualifier("UserDao")
@RequestMapping(value="/register",method=RequestMethod.GET)
public ModelAndView dispaly1()
{
	return new ModelAndView("Register","command",new Userregistration());
}

@RequestMapping(value="/register",method=RequestMethod.POST)
public String register(Userregistration userReg,HttpServletRequest request,HttpServletResponse response)
{
	HttpSession session=request.getSession();
	session.setAttribute("Patient Id", userReg.getPatientId());
	session.setAttribute("Patient Name", userReg.getPatientName());
	boolean res=userdao.register(userReg);
	if(res)
	{
	return "RegSucc";
	}
	else
	{
		return "message";
	}
}


}
