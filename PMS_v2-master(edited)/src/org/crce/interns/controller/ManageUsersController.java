package org.crce.interns.controller;
import java.util.ArrayList;
import java.util.List;
import org.crce.interns.beans.UserCompanyBean;
import org.crce.interns.model.Company;
import org.crce.interns.model.UserCompany;
import org.crce.interns.service.impl.ManageUsersService;
import org.crce.interns.validators.AddApplicantsValidator;
import org.crce.interns.validators.DeleteApplicantsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("manageUsersController")
public class ManageUsersController {

	@Autowired
	private ManageUsersService crudService;

	@Autowired
	private AddApplicantsValidator addApplicantsValidator;
	
	@Autowired
	private DeleteApplicantsValidator deleteApplicantsValidator;
	
	@RequestMapping(value = "/view-candidate.html", method = RequestMethod.GET)
	public ModelAndView gotoviewcandidate() {
		ModelAndView model = null;
		model = new ModelAndView("view-candidate");
		return model;
	}

	// @SuppressWarnings("unused")

	@RequestMapping(value = "/viewclist.html", method = RequestMethod.POST)
	public ModelAndView viewcandidate(@RequestParam("company") String company) {
		ModelAndView model;

		System.out.println("inside controller"+company);
		 
		model = new ModelAndView("candidate-list");
		 List<UserCompany> userList=new ArrayList<UserCompany>();
		 userList.addAll(crudService.retreiveDetails(company));
		 System.out.println("inside controller..........");
		// for(UserCompany d:userList) System.out.println(d.getUsername()+" "+d.getCompany());
		 model.addObject("userList",userList);
		return model;
	}

	@RequestMapping(value = "/showlist.html", method = RequestMethod.POST )
	public ModelAndView cruddetails(@RequestParam(value = "option") String option) {
		ModelAndView model;
		UserCompanyBean userBean = new UserCompanyBean();
		
		if (option.equals("Add"))
			model = new ModelAndView("add-candidate");
		else if (option.equals("Delete"))
			model = new ModelAndView("delete-candidate");
		else
			model = null;
		 model.addObject("userBean",userBean);
		return model;
	}

	@RequestMapping(value = "/addcandidate.html", method = RequestMethod.POST)
	public ModelAndView addcandidate(@ModelAttribute("userBean") UserCompanyBean userBean, BindingResult bindingResult) {
		ModelAndView model;
	//	UserCompanyBean userBean = new UserCompanyBean();
	//	userBean.setUsername(name);
	//	userBean.setCompany(company);
	//	System.out.println(userBean.getUsername());
		crudService.createDetails(userBean);
		addApplicantsValidator.validate(userBean, bindingResult);
		if (bindingResult.hasErrors()) {
			System.out.println("Binding Errors are present...");
			model = new ModelAndView("add-candidate");
		} else
		model = new ModelAndView("add-success");
		//model.addAttribute(userBean);
		return model;
	}

	@RequestMapping(value = "/deletecandidate.html", method = RequestMethod.POST)
	public ModelAndView deletecandidate(@ModelAttribute("userBean") UserCompanyBean userBean, BindingResult bindingResult) {
		ModelAndView model;
		//UserCompanyBean userBean = new UserCompanyBean();
		//UserCompanyId uci=new UserCompanyId();
		//uci.setUsername(name);
	//	uci.setCompany_id();
	//	userBean.setId(uci);
		//userBean.setUsername(name);
		//userBean.setCompany(company);
		crudService.deleteDetails(userBean);
		addApplicantsValidator.validate(userBean, bindingResult);
		if (bindingResult.hasErrors()) {
			System.out.println("Binding Errors are present...");
			model = new ModelAndView("delete-candidate");
		} else
		model = new ModelAndView("delete-success");
		return model;
	}

}
