package org.crce.interns.controller;

import javax.servlet.http.HttpServletRequest;

import org.crce.interns.exception.IncorrectFileFormatException;
import org.crce.interns.exception.MaxFileSizeExceededError;
import org.crce.interns.service.ResumeUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResumeUploadController {


	@Autowired
	private ResumeUploadService resumeUploadService;

	@RequestMapping("resumeUpload")
	public ModelAndView welcome() {
		return new ModelAndView("ResumeUpload");
	}

	@RequestMapping(value = "/uploadResume", method = RequestMethod.POST)
	public ModelAndView resumeUpload(HttpServletRequest request,
			@RequestParam(required = false) CommonsMultipartFile fileUpload)
					throws Exception {

		try {
			 String username = (String)request.getSession(true).getAttribute("userName");
			System.out.println("in try");
			resumeUploadService.handleFileUpload(request, fileUpload, username);
		} catch (IncorrectFileFormatException e) {
			System.out.println(e);
			ModelAndView model = new ModelAndView("ResumeUpload");
			model.addObject("error", 1);
			return model;
		} catch (MaxFileSizeExceededError m) {
			System.out.println(m);
			ModelAndView model = new ModelAndView("ResumeUpload");
			model.addObject("error1", 1);
			return model;
		}
		return new ModelAndView("ResumeUpload");
	}
}
