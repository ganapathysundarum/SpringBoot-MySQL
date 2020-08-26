package com.tcs.fullstack.employee.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.tcs.fullstack.employee.service.EmployeeService;

@Controller
@SessionAttributes("emp_name,emp_id")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String employeeLoginPage(){
		return "employee_login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String employeeLoginSuccess(String loginname, String password, ModelMap model){
		
		Integer empId = service.authendicateEmployee(loginname, password, model);
		
		if (null == empId || empId == 0) {           
            model.put("errorMessage", "Invalid Credentials!!");
            return "employee_login";
        }
		
		 model.put("emp_name", loginname);
		 model.put("password", password);        
		 model.put("emp_id", empId);
		 
		 System.out.println("Login emp id : "+empId);
		 
		return "redirect:/list-employee?employeeId="+empId+"&employeeName="+loginname;
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {			
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/list-employee", method = RequestMethod.GET)
	public String showEmployeeDetailsById(String employeeId,String employeeName,ModelMap model) {			
		System.out.println("Forwarded emp id : "+employeeId);
		model.put("emp_id", employeeId);
		model.put("emp_name",employeeName);
		service.retrieveEmployeeById(employeeId, model);
		return "employee_list";
	}
	
}
