package org.crce.interns.service.impl;


import java.io.File;
import javax.servlet.http.HttpServletRequest;
import org.crce.interns.dao.AddUserDao;
import org.crce.interns.service.AddUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;



@Service("addUserService")
public class AddUserServiceImpl implements AddUserService {

	@Autowired
	private AddUserDao addUserDao;
	
	private String saveDirectory = "C:/Users/Crystal/workspace1/PMS_v2_Working-master/PMS_v2-master(edited)/src/resources/csv/";
	
	public void handleFileUpload(HttpServletRequest request, @RequestParam CommonsMultipartFile fileUpload, String year)
			throws Exception {
		if (!fileUpload.isEmpty()) {

			System.out.println("Saving file: " + fileUpload.getOriginalFilename());

			if (!fileUpload.getOriginalFilename().equals(""))

				fileUpload.transferTo(new File(saveDirectory + fileUpload.getOriginalFilename()));

		}
		addUserDao.loadCopyFile("loader_schema.loader",year);
	}
	
	
}
