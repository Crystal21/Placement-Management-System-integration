package org.crce.interns.dao;

import java.util.List;

import org.crce.interns.model.FacultyUser;
import org.crce.interns.model.RMUser;
import org.crce.interns.model.UserDetails;

public interface AssignTPCDao {
	public void assignTPC(UserDetails user);
	public void insertWork(FacultyUser fuser);
	public FacultyUser getFacultyUser(FacultyUser fuser);
	public RMUser getUserRole(String role_id);
	public List<FacultyUser> viewFacultyTasks();
	public List<UserDetails> viewUsers();
	public void removeTPC(UserDetails user);
	public UserDetails getUser(UserDetails checkUser);

}
