package com.attra.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.attra.DaoClassImpl.CustomerDAO;
import com.attra.Model.Appointmentdetail;
import com.attra.Model.Departmentdetail;
import com.attra.Model.Hospitaldetail;



@Controller

//@RequestMapping("/contr")

	/*@Autowired
	private CustomerDAO customerDAO;
	*/
	
	/*public String listCustomers(HttpServletRequest request,HttpServletResponse response,Model model)
	{
		System.out.println("hai");*/
		
		/*try {
			HttpSession session=request.getSession();
			String patientname=(String) session.getAttribute("PatientName");

			//String patientname=session.getAttribute("PatientName").toString();
			System.out.println(patientname);
			if(patientname!=null)
			
				return "userLanding";
				
			
		}
		catch(Exception e)
		{
	   return "Login";
			
		
		}*/
	

public class UserPageController {
	@RequestMapping("/list")
public String patientList(HttpServletRequest request,HttpServletResponse response,Model model)
{

		try {
			HttpSession session=request.getSession();
			String patientname=(String) session.getAttribute("PatientName");

			if(patientname!=null) 
	System.out.println("hai");
	
	return "userLanding";
			

}
		
catch(Exception e)
{
return "Login";
	
}
		
}

}








		
		/*List<Hospitaldetail> thecustomer=customerDAO.getCustomers();
		model.addAttribute("customers",thecustomer);*/
	
	
	
	/*@RequestMapping("/listDepartment")
	public @ResponseBody String listDep(Model model,@RequestParam("hospId") int hospId)
	{
		System.out.println("hello");
		
		List<Departmentdetail> thecustomer=customerDAO.getDepartmentdetail(hospId);
		model.addAttribute("customers1",thecustomer);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String userJson = null;
		   try {
		      userJson = objectMapper.writeValueAsString(thecustomer);
		   } catch (JsonProcessingException e) {
		      e.printStackTrace();
		   }
		   System.out.println(userJson);

		
		Gson gson = new Gson();
        String json = gson.toJson(thecustomer); //convert 
        System.out.println(json);

		
		return "welcome";
	}
*/	




