package org.crce.interns.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.crce.interns.beans.AllotmentBean;
import org.crce.interns.model.Allotment;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface ManageAllotmentService {

	public void addAllotment(AllotmentBean allotmentBean);
	public void handleFileUpload(HttpServletRequest request, @RequestParam CommonsMultipartFile fileUpload);// throws Exception;
	public List<Allotment> listAllotment();
	
}
