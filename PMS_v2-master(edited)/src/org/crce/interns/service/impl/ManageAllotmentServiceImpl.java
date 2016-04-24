package org.crce.interns.service.impl;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.crce.interns.beans.AllotmentBean;
import org.crce.interns.dao.ManageAllotmentDao;
import org.crce.interns.model.Allotment;
import org.crce.interns.service.ManageAllotmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Service("manageAllotmentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class ManageAllotmentServiceImpl implements ManageAllotmentService{

	@Autowired
	private ManageAllotmentDao manageAllotmentDao;
	
	private String saveDirectory = "C:/work/";

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addAllotment(AllotmentBean allotmentBean) {
		// TODO Auto-generated method stub
		Allotment allotment = new Allotment();
		BeanUtils.copyProperties(allotmentBean, allotment);
		//profile.setRole_id("1");

		manageAllotmentDao.createAllotment(allotment);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Allotment> listAllotment() {
		// TODO Auto-generated method stub
		return manageAllotmentDao.listAllotment();
	}

	@Override
	public void handleFileUpload(HttpServletRequest request, CommonsMultipartFile fileUpload) {
		// TODO Auto-generated method stub
		if (!fileUpload.isEmpty()) {

			
			System.out.println("Saving file: " + fileUpload.getOriginalFilename());

			if (!fileUpload.getOriginalFilename().equals(""))
				try {
					fileUpload.transferTo(new File(saveDirectory + fileUpload.getOriginalFilename()));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
		
		//manageAllotmentDao.addNewResume(username,saveDirectory + fileUpload.getOriginalFilename());

	}

}
