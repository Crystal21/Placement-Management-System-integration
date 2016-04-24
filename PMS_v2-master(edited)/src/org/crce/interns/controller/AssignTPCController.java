package org.crce.interns.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.crce.interns.beans.FacultyUserBean;
import org.crce.interns.beans.UserDetailsBean;
import org.crce.interns.model.UserDetails;
import org.crce.interns.service.AssignTPCService;
import org.crce.interns.validators.AddTPCTaskValidator;
import org.crce.interns.validators.AddTPCValidator;
import org.crce.interns.validators.RemoveTPCValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AssignTPCController {
	@Autowired
	private AssignTPCService userService;

	@Autowired
	AddTPCValidator validator;

	@Autowired
	RemoveTPCValidator rvmvalidator;

	@Autowired
	AddTPCTaskValidator addTPCTaskValidator;


	@RequestMapping(value = "/TPOHome", method = RequestMethod.GET)
	public ModelAndView goTPOHome(@ModelAttribute("command") FacultyUserBean userBean, BindingResult result) {
		System.out.println("In TPO Home Page\n");
		return new ModelAndView("TPO");
	}
	
	@RequestMapping(value="/ViewUsersT", method = RequestMethod.GET)
	public ModelAndView viewUsers() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("users", userService.viewUsers());
		return new ModelAndView("viewUserT", modelMap);
	}
	
	@RequestMapping(value="/ViewFacultyTasks", method = RequestMethod.GET)
	public ModelAndView viewFacultyTasks() {
		System.out.println("In View TPC Tasks\n");
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("fusers", userService.viewFacultyTasks());
		return new ModelAndView("viewFacultyTasks", modelMap);
	}
	
	
	@RequestMapping(value = "/InsertWork", method = RequestMethod.GET)
	public ModelAndView createUserWork(@ModelAttribute("command") FacultyUserBean userBean, BindingResult result) {
		System.out.println("In Assign TPC Work\n");
		return new ModelAndView("insertWork");
	}
	
	@RequestMapping(value = "/AssignTPC", method = RequestMethod.GET)
	public ModelAndView assignTPC(@ModelAttribute("command") UserDetailsBean userBean, BindingResult result) {
		System.out.println("In Assign TPC\n");
		return new ModelAndView("assignTPC");
	}
	
	@RequestMapping(value = "/RemoveTPC", method = RequestMethod.GET)
	public ModelAndView removeTPC(@ModelAttribute("command") UserDetailsBean userBean, BindingResult result) {
		System.out.println("In Remove TPC\n");
		return new ModelAndView("removeTPC");
	}

	@RequestMapping(value = "/SubmitAssignTPC", method = RequestMethod.POST)
	public ModelAndView submitAssignTPC(@ModelAttribute("command") UserDetailsBean userBean,/*@ModelAttribute("fuserBean")FacultyUserBean fuserBean,*/ BindingResult bindingResult) {
		validator.validate(userBean, bindingResult);
		System.out.println("In Submit Assign TPC\n");
		if (bindingResult.hasErrors()) {
			System.out.println("Binding Errors are present...");
			return new ModelAndView("assignTPC");
		}
		//System.out.println("Task Assigned is "+fuserBean.getUserWork());
		int a;
		a=userService.assignTPC(userBean);
	//	FacultyUserBean fuserBean= new FacultyUserBean();
			System.out.println("Value Returned from Service: "+a);
			if(a==0)
			{
				return new ModelAndView("noUser");
			}
			if(a==3)
			{
				return new ModelAndView("notStud");	
			}
			if(a==4)
			{
				return new ModelAndView("notFac");
			}
			if(a==34){
				return new ModelAndView("alTPC");
			}
		return new ModelAndView("redirect:/ViewUsersT");
		//return new ModelAndView("redirect:/TPOHome");
	}
	
		
	
	@RequestMapping(value = "/SubmitInsertWork", method = RequestMethod.POST)
	public ModelAndView createWork(@ModelAttribute("command") FacultyUserBean fuserBean, BindingResult bindingResult) {
		/*validator.validate(fuserBean, bindingResult);*/
		addTPCTaskValidator.validate(fuserBean, bindingResult);
		System.out.println("In Submit TPC Work\n");
		if (bindingResult.hasErrors()) {
			System.out.println("Binding Errors are present...");
			return new ModelAndView("insertWork");
		}
		System.out.println("Username in Controller :"+fuserBean.getUserName());
		int a;
		a=userService.insertWork(fuserBean);
		
		System.out.println("Value Returned from Service: "+a);
		if(a==0)
		{
			return new ModelAndView("noUser");
		}
		
		return new ModelAndView("redirect:/ViewFacultyTasks");
	}
		
	
	@RequestMapping(value = "/SubmitRemoveTPC", method = RequestMethod.POST)
	public ModelAndView submitRemoveTPC(@ModelAttribute("command") UserDetailsBean userBean, BindingResult bindingResult) {
		rvmvalidator.validate(userBean, bindingResult);
		System.out.println("In Submit Remove TPC\n");
		if (bindingResult.hasErrors()) {
			System.out.println("Binding Errors are present...");
			return new ModelAndView("removeTPC");
		}
		int a;
		a=userService.removeTPC(userBean);
		System.out.println("Value Returned from Service: "+a);
		if(a==0)
		{
			return new ModelAndView("noUser");
		}
		if(a==33)
		{
			return new ModelAndView("notTPC");
		}
		return new ModelAndView("redirect:/ViewUsersT");
	//	return new ModelAndView("redirect:/TPOHome");
	}

}
