package org.crce.interns.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import org.crce.interns.beans.FeedbackBean;
import org.crce.interns.model.Feedback;
import org.crce.interns.service.FeedbackService;
import org.crce.interns.validators.FeedbackFormValidator;

@Controller
public class FeedbackController {

	
	@Autowired
	private FeedbackService feedbackService;
	
	@Autowired
    FeedbackFormValidator validator;
	/*@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
*/
   
	@RequestMapping(value="/feedback", method = RequestMethod.GET)
	public ModelAndView listFeedback() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("feedback",prepareListofBean(feedbackService.listFeedback()));
		
		return new ModelAndView("feedbackList", model);
	}
	@RequestMapping(value = "/addFeedback", method = RequestMethod.GET)
	public ModelAndView saveEmployee(@ModelAttribute("command") FeedbackBean feedbackBean, 
			BindingResult result) {
		System.out.println("in controller1");
		//Feedback feedback = prepareModel(feedbackBean);
		//feedbackService.addFeedback(feedback);
		//System.out.println("in controller1");
		return new ModelAndView("addFeedback");
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)  
	 public ModelAndView addEmployee(  @ModelAttribute("command")FeedbackBean feedbackBean,  
	   BindingResult result) { 
		//validating
		validator.validate(feedbackBean, result);
				if (result.hasErrors()) {
			System.out.println("Error in form");
            
            return new ModelAndView("addFeedback");
        }
				Feedback feedback = prepareModel(feedbackBean);
				feedbackService.addFeedback(feedback);
	  Map<String, Object> model = new HashMap<String, Object>();  
	 model.put("feedback",  prepareList(feedbackService.listFeedback(),feedbackBean.getCompany()));  
	  return new ModelAndView("feedbackSaveSuccess",model);  
	 }  
	
	
	/*@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}*/
	
	private List<FeedbackBean> prepareListofBean(List<Feedback> feedback){
		List<FeedbackBean> beans = null;
		if(feedback != null && !feedback.isEmpty()){
			beans = new ArrayList<FeedbackBean>();
			FeedbackBean bean = null;
			for(Feedback a : feedback){
				
				System.out.println(a.getFeeback() + "Inside controller");
				
				bean = new FeedbackBean();
				bean.setUsername(a.getUsername());
				bean.setCompany(a.getCompany());
				bean.setFeeback(a.getFeeback());
				
						beans.add(bean);
			}

		}
		return beans;
	}
	
	private Feedback prepareModel(FeedbackBean feedbackBean){
		Feedback feedback = new Feedback();
		feedback.setUsername(feedbackBean.getUsername());
		feedback.setCompany(feedbackBean.getCompany());
		feedback.setFeeback(feedbackBean.getFeeback());
		
		return feedback;
	}
	
	private List<FeedbackBean> prepareList(List<Feedback> feedback,String company){
		List<FeedbackBean> beans = null;
		if(feedback != null && !feedback.isEmpty()){
			beans = new ArrayList<FeedbackBean>();
			FeedbackBean bean = null;
			for(Feedback a : feedback){
				if(company.equals(a.getCompany()))
				{
				bean = new FeedbackBean();
				bean.setUsername(a.getUsername());
				bean.setCompany(a.getCompany());
				bean.setFeeback(a.getFeeback());
				
						beans.add(bean);}
				else continue;
			}

		}
		return beans;
	}

	
	
}
