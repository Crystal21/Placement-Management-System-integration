package org.crce.interns.service;

public interface LoginService{    
	public String checkLogin(String userName, String userPassword);
	public int getStudentByid(String userName);
	public boolean getNotification(String userName);
}