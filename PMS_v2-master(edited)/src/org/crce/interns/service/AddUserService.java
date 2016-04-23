package org.crce.interns.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface AddUserService {

	public void handleFileUpload(HttpServletRequest request, @RequestParam CommonsMultipartFile fileUpload, String year) throws Exception;
	
	
}
