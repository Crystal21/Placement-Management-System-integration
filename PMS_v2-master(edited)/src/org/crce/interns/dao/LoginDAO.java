package org.crce.interns.dao;


public interface LoginDAO{    
	public String checkLogin(String userName, String userPassword);
	public int getStudentById(String userName);
	public boolean getNotification(String userName);
}