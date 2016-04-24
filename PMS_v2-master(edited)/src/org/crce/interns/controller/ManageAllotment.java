package org.crce.interns.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.crce.interns.beans.AllotmentBean;
import org.crce.interns.model.Allotment;
import org.crce.interns.service.ManageAllotmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ManageAllotment extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3205005179545325725L;
	@Autowired
	private ManageAllotmentService manageAllotmentService;
	
	/*
	@RequestMapping("/")
	public ModelAndView welcome() {
				return new ModelAndView("index");
	}
	*/
	
	@RequestMapping(value = "/saveAllotment", method = RequestMethod.POST)
	public ModelAndView addAllotment(HttpServletRequest request, @RequestParam CommonsMultipartFile fileUpload,@ModelAttribute("allotmentBean")AllotmentBean allotmentBean,BindingResult result) {
		
		manageAllotmentService.addAllotment(allotmentBean);
		manageAllotmentService.handleFileUpload(request,fileUpload);
		return new ModelAndView("FacultyTPC");
	}
	
	/*
	@RequestMapping(value = "/addAllotment", method = RequestMethod.GET)
	public ModelAndView createAllotment(@ModelAttribute("command")  AllotmentBean allotmentBean ,
			BindingResult result) {
	    
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("allotments",  prepareListofBean(manageAllotmentService.listAllotment()));
		return new ModelAndView("addAllotment", model);
	}
	*/
	
	@RequestMapping(value = "/addAllotment", method = RequestMethod.GET)
	public ModelAndView createAllotment(Model model) {
		AllotmentBean allotmentBean = new AllotmentBean(); // declaring

         model.addAttribute("allotmentBean", allotmentBean); // adding in model
         Map<String, Object> model1 = new HashMap<String, Object>();
 		 model1.put("allotments",  prepareListofBean(manageAllotmentService.listAllotment()));
		 return new ModelAndView("addAllotment");
		 
	}

	@RequestMapping(value="/viewAllotment", method = RequestMethod.GET)
	public ModelAndView listAllotment() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("allotments",  prepareListofBean(manageAllotmentService.listAllotment()));
		return new ModelAndView("viewAllotment", model);
	}
	
	private List<AllotmentBean> prepareListofBean(List<Allotment> allotments) {
		
		List<AllotmentBean> beans = null;
		if(allotments != null && !allotments.isEmpty())
		{
			beans = new ArrayList<AllotmentBean>();
			AllotmentBean bean = null;
			for(Allotment allotment : allotments)
			{
				bean = new AllotmentBean();
				bean.setAllotment_id(allotment.getAllotment_id());
				bean.setCompany_name(allotment.getCompany_name());
				bean.setDrive_date(allotment.getDrive_date());
				bean.setJob_description(allotment.getJob_description());
				bean.setRoom_no(allotment.getRoom_no());
				bean.setRound_no(allotment.getRound_no());
				beans.add(bean);			
			}
		}
		return beans;
	}

	/*
	 
	@RequestMapping(value = "/addAllotment", method = RequestMethod.GET)
	public ModelAndView createAllotment(Model model) {
		AllotmentBean allotmentBean = new AllotmentBean(); // declaring

         model.addAttribute("allotmentBean", allotmentBean); // adding in model

		return new ModelAndView("addAllotment");
	}
	
	@RequestMapping(value = "/viewAllotment", method = RequestMethod.GET)
	public ModelAndView createAllotment(@ModelAttribute("command")  AllotmentBean allotment,
			BindingResult result) {
			
		 Map<String, Object> model = new HashMap<String, Object>();
		 model.put("categories",  categoryService.getCategories());
			return new ModelAndView("addCategory", model);
		return new ModelAndView("addAllotment");
	}
	
	  @RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("command") EmployeeBean employeeBean ,
			BindingResult result) {
	    
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("addEmployee", model);
	}

	 */


		}
