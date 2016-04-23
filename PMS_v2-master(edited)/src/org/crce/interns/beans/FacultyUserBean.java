package org.crce.interns.beans;

import java.io.Serializable;

public class FacultyUserBean implements Serializable {
	private String userName;
	private String userWork;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserWork() {
		return userWork;
	}
	public void setUserWork(String userWork) {
		this.userWork = userWork;
	}
	
}
