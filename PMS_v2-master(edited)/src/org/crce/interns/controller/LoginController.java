package org.crce.interns.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import org.crce.interns.beans.LoginForm;
import org.crce.interns.beans.NotifyForm;
import org.crce.interns.service.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController extends HttpServlet{

	
	@Autowired
	public LoginService loginService;
	
	
	@RequestMapping("/")
	public ModelAndView welcome() {
		System.out.println("return model");
		return new ModelAndView("index");
	}
	

	@RequestMapping(value="/form" , method = RequestMethod.GET)  
  	public ModelAndView showForm(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("Inside Controller");
		LoginForm loginForm = new LoginForm();
		ModelAndView model=null;
		model = new ModelAndView("Login");
		model.addObject("loginForm", loginForm);
		
		return model;	
		
	}
	
	@RequestMapping(value="/logged" ,method = RequestMethod.POST)
	public ModelAndView processForm(HttpServletRequest request, HttpServletResponse response, @Valid LoginForm loginForm, BindingResult result) {

		System.out.println("Inside Controller");
		ModelAndView model=null;	
		/*if (result.hasErrors()) {
			return "loginform";
		}*/
		
		String role=loginService.checkLogin(loginForm.getUserName(),loginForm.getPassword());
			
		System.out.println("Role is:" +role);
	
		
		if(role.equals("Student")){
			model = new ModelAndView("Student");
			HttpSession session=request.getSession();
			String name =  request.getParameter("userName");
		    System.out.println("UserName: " + name); // Here it prints the username properly
		    
		    request.getSession(true).setAttribute("userName", name );
		     request.getSession(true).setAttribute("roleId", "1" );
		    // System.out.println(session.getAttribute("userName"));
		    System.out.println("Logged in as what????: " + name);
		    boolean b=loginService.getNotification(loginForm.getUserName());
		    model.addObject("b", b);
			return model;
		}
		
		else if(role.equals("FacultyTPC"))
		{
			model = new ModelAndView("FacultyTPC");
			NotifyForm notify=new NotifyForm();
			model.addObject("notify", notify);
			HttpSession session=request.getSession();
			String name =  request.getParameter("userName");
		    System.out.println("UserName: " + name); // Here it prints the username properly
		    
		    request.getSession(true).setAttribute("userName", name );
		    request.getSession(true).setAttribute("roleId", "4" );
		    
		    System.out.println("Logged in as what????: " + name);
		    
			return model;
		}
		else if(role.equals("StudentTPC"))
		{
			model = new ModelAndView("StudentTPC");
			HttpSession session=request.getSession();
			String name =  request.getParameter("userName");
		    System.out.println("UserName: " + name); // Here it prints the username properly
		    
		    request.getSession(true).setAttribute("userName", name );
		    request.getSession(true).setAttribute("roleId", "3" );
		    
		    System.out.println("Logged in as what????: " + name);
		    boolean b=loginService.getNotification(loginForm.getUserName());
		    model.addObject("b", b);
			return model;
		}
		else if(role.equals("TPO"))
		{
			model = new ModelAndView("TPO");
			HttpSession session=request.getSession();
			String name =  request.getParameter("userName");
		    System.out.println("UserName: " + name); // Here it prints the username properly
		    
		    request.getSession(true).setAttribute("userName", name );
		    request.getSession(true).setAttribute("roleId", "5" );
		    
		    System.out.println("Logged in as what????: " + name);
			return model;
		}
		else if(role.equals("Admin"))
		{
			model = new ModelAndView("Admin");
			HttpSession session=request.getSession();
			String name =  request.getParameter("userName");
		    System.out.println("UserName: " + name); // Here it prints the username properly
		    request.getSession(true).setAttribute("userName", name );
		    request.getSession(true).setAttribute("roleId", "6" );
		 
		    
		    System.out.println("Logged in as what????: " + name);
			return model;
		}
		else{
			result.rejectValue("userName","invaliduser");
			model = new ModelAndView("loginform");
			return model;
		}
	}
	
	@RequestMapping(value="/notify" ,method = RequestMethod.POST)
	public String notifyForm(@Valid NotifyForm notify, BindingResult result,
			Map model) 
	{
		String userName=notify.getUserName();
		int update=loginService.getStudentByid(userName);
		//System.out.println("hello");
		if(update==0)
		{
			model.put("notify",notify);
			return "FacultyTPC";
		}
		else
			return "success";
	}
	

}
