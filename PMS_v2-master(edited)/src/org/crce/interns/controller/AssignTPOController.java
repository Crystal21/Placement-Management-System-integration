package org.crce.interns.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.crce.interns.beans.FacultyUserBean;
import org.crce.interns.beans.NotifyForm;
import org.crce.interns.beans.UserDetailsBean;
import org.crce.interns.service.AssignTPOService;
import org.crce.interns.validators.AddTPOValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AssignTPOController {
	@Autowired
	private AssignTPOService userService;

	@Autowired
	AddTPOValidator validator;

	@RequestMapping(value = "/AdminHome", method = RequestMethod.GET)
	public ModelAndView goAdminHome(@ModelAttribute("command") FacultyUserBean userBean, BindingResult result) {
		System.out.println("In Admin Home Page\n");
		return new ModelAndView("Admin");
	}
	
	@RequestMapping(value = "/FTPCHome", method = RequestMethod.GET)
	public ModelAndView goFTPCHome(@ModelAttribute("notify") FacultyUserBean userBean, BindingResult result) {
		System.out.println("In Faculty TPC Home Page\n");
		return new ModelAndView("FacultyTPC");
	}
	
	@RequestMapping(value="/ViewUsersA", method = RequestMethod.GET)
	public ModelAndView viewUsers() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("users", userService.viewUsers());
		return new ModelAndView("viewUserA", modelMap);
	}
	
	@RequestMapping(value="/ViewUsersF", method = RequestMethod.GET)
	public ModelAndView viewUsersF() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("users", userService.viewUsers());
		return new ModelAndView("viewUserF", modelMap);
	}


	@RequestMapping(value = "/AssignTPCF", method = RequestMethod.GET)
	public ModelAndView assignTPCF(@ModelAttribute("command") UserDetailsBean userBean, BindingResult result) {
		System.out.println("In Assign TPC\n");
		return new ModelAndView("assignTPCF");
	}
	
	@RequestMapping(value = "/AssignTPO", method = RequestMethod.GET)
	public ModelAndView assignTPO(@ModelAttribute("command") UserDetailsBean userBean, BindingResult result) {
		System.out.println("In Assign TPO\n");
		return new ModelAndView("assignTPO");	}

	@RequestMapping(value = "/RemoveTPCF", method = RequestMethod.GET)
	public ModelAndView removeTPCF(@ModelAttribute("command") UserDetailsBean userBean, BindingResult result) {
		System.out.println("In Remove TPCF\n");
		return new ModelAndView("removeTPCF");
	}

	@RequestMapping(value = "/RemoveTPO", method = RequestMethod.GET)
	public ModelAndView removeTPO(@ModelAttribute("command") UserDetailsBean userBean, BindingResult result) {
		System.out.println("In Remove TP0\n");
		return new ModelAndView("removeTPO");
	}

	@RequestMapping(value = "/SubmitAssignTPO", method = RequestMethod.POST)
	public ModelAndView createUser(@ModelAttribute("command") UserDetailsBean userBean, BindingResult bindingResult) {
		validator.validate(userBean, bindingResult);
		if (bindingResult.hasErrors()) {
			System.out.println("Binding Errors are present...");
			return new ModelAndView("assignTPO");
		}
		int a;
		a=userService.assignTPO(userBean);
		System.out.println("Value Returned from Service: "+a);
		if(a==0)
		{
			return new ModelAndView("noUser");
		}
		if(a==5)
		{
			return new ModelAndView("notFac");
		}
		if(a==55){
			return new ModelAndView("alTPO");
		}
		return new ModelAndView("redirect:/ViewUsersA");
		//return new ModelAndView("redirect:/AdminHome");
	}
		
	@RequestMapping(value = "/SubmitAssignTPCF", method = RequestMethod.POST)
	public ModelAndView createTPCF(@ModelAttribute("command") UserDetailsBean userBean, BindingResult bindingResult) {
		validator.validate(userBean, bindingResult);
		if (bindingResult.hasErrors()) {
			System.out.println("Binding Errors are present...");
			return new ModelAndView("assignTPCF");
		}
		int a;
		a=userService.assignTPCF(userBean);
		//return new ModelAndView("redirect:/FTPCHome");
		if(a==0)
		{
			return new ModelAndView("noUser");
		}
		if(a==3)
		{
			return new ModelAndView("notStud");	
		}
		if(a==34){
			return new ModelAndView("alTPC");
		}
		return new ModelAndView("redirect:/ViewUsersF");
		//return new ModelAndView("redirect:/AdminHome");
	}
	
	@RequestMapping(value = "/SubmitRemoveTPO", method = RequestMethod.POST)
	public ModelAndView deleteUser(@ModelAttribute("command") UserDetailsBean userBean, BindingResult bindingResult) {
		
		System.out.println("In Submit RemoveTPo");
		validator.validate(userBean, bindingResult);
		System.out.println("In Submit RemoveTPo");
		if (bindingResult.hasErrors()) {
			System.out.println("Binding Errors are present...");
			return new ModelAndView("removeTPO");
		}
		int a;
		a=userService.removeTPO(userBean);
		System.out.println("Value Returned from Service: "+a);
		if(a==0)
		{
			return new ModelAndView("noUser");
		}
		if(a==55)
		{
			return new ModelAndView("notTPO");
		}
		return new ModelAndView("redirect:/ViewUsersA");
		//return new ModelAndView("redirect:/AdminHome");
	}
	
	@RequestMapping(value = "/SubmitRemoveTPCF", method = RequestMethod.POST)
	public ModelAndView deleteTPCF(@ModelAttribute("command") UserDetailsBean userBean, BindingResult bindingResult) {
		
		System.out.println("In Submit RemoveTPCF");
		validator.validate(userBean, bindingResult);

		if (bindingResult.hasErrors()) {
			System.out.println("Binding Errors are present...");
			return new ModelAndView("removeTPCF");
		}
		int a;
		a=userService.removeTPCF(userBean);
		System.out.println("in Remove TPCF:Value Returned from Service: "+a);
		if(a==0)
		{
			return new ModelAndView("noUser");
		}
		if(a==55)
		{
			return new ModelAndView("notTPC");
		}
		return new ModelAndView("redirect:/ViewUsersF");
		//return new ModelAndView("redirect:/AdminHome");
	}
}
