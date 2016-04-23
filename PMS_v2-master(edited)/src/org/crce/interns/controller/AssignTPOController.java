package org.crce.interns.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.crce.interns.beans.FacultyUserBean;
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
	
	@RequestMapping(value="/ViewUsersA", method = RequestMethod.GET)
	public ModelAndView viewUsers() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("users", userService.viewUsers());
		return new ModelAndView("viewUserA", modelMap);
	}

	@RequestMapping(value = "/AssignTPO", method = RequestMethod.GET)
	public ModelAndView assignTPO(@ModelAttribute("command") UserDetailsBean userBean, BindingResult result) {
		System.out.println("In Assign TPO\n");
		return new ModelAndView("assignTPO");	}

	
	
	
	
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
		userService.assignTPO(userBean);
		
		return new ModelAndView("redirect:/ViewUsersA");
		//return new ModelAndView("redirect:/AdminHome");
	}

	@RequestMapping(value = "/SubmitRemoveTPO", method = RequestMethod.POST)
	public ModelAndView deleteUser(@ModelAttribute("command") UserDetailsBean userBean, BindingResult bindingResult) {
		validator.validate(userBean, bindingResult);
		if (bindingResult.hasErrors()) {
			System.out.println("Binding Errors are present...");
			return new ModelAndView("removeTPO");
		}
		userService.removeTPO(userBean);
		return new ModelAndView("redirect:/ViewUsersA");
		//return new ModelAndView("redirect:/AdminHome");
	}
}
