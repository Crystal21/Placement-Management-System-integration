package org.crce.interns.controller;



import org.crce.interns.service.AddUserService;
import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


@Controller
public class AddUserController {
	
	@Autowired
	private AddUserService addUserService;

	
	@RequestMapping(value="/addUser", method = RequestMethod.GET)
	public String indexjsp() {
		
		return "AddUserViaCSV";
	}

	
	
	
	@RequestMapping( value = "/uploadFile", method = RequestMethod.POST)
	public String addUser(HttpServletRequest request, @RequestParam CommonsMultipartFile fileUpload,@RequestParam("year")String year)
			throws Exception {

		
		//System.out.println(year);
		
		addUserService.handleFileUpload(request,fileUpload,year);
		// loadCopyFile("user_schema.userdetails");
		
		// returns to the same index page
		return "AddUserViaCSV";
	}

	

}
