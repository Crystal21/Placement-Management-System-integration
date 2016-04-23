package org.crce.interns.service;

import org.crce.interns.beans.FacultyBean;
import org.crce.interns.beans.StudentBean;



public interface ManageUserService {

	public void addStudent(StudentBean studentBean);
	public void addFaculty(FacultyBean facultyBean);
	public void removeUser(StudentBean studentBean,String username);
}
