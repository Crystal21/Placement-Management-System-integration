package org.crce.interns.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

public interface SendEmailService {
	public ModelAndView sendMail(HttpServletRequest request,
			@RequestParam(value = "fileUpload") CommonsMultipartFile[] file);
}
