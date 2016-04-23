<<<<<<< HEAD
package org.crce.interns.service;

import java.util.List;

import org.crce.interns.beans.FacultyUserBean;
import org.crce.interns.beans.UserDetailsBean;
import org.crce.interns.model.UserDetails;
import org.springframework.stereotype.Service;

public interface AssignTPCService {
	public int assignTPC (UserDetailsBean userBean);
	public void removeTPC(UserDetailsBean userBean);
	public List<UserDetailsBean> viewUsers();
	public List<FacultyUserBean> viewFacultyTasks();
	public void insertWork(FacultyUserBean fuserBean);

/*
	
	

*/
}
=======
package org.crce.interns.service;

import java.util.List;

import org.crce.interns.beans.FacultyUserBean;
import org.crce.interns.beans.UserDetailsBean;
import org.crce.interns.model.UserDetails;
import org.springframework.stereotype.Service;

public interface AssignTPCService {
	public int assignTPC (UserDetailsBean userBean);
	public void removeTPC(UserDetailsBean userBean);
	public List<UserDetailsBean> viewUsers();
	public List<FacultyUserBean> viewFacultyTasks();
	public void insertWork(FacultyUserBean fuserBean);

/*
	
	

*/
}
>>>>>>> darshgup139-master
