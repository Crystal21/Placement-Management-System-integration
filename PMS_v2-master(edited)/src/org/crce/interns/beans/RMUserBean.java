package org.crce.interns.beans;

import java.io.Serializable;

public class RMUserBean implements Serializable {
	private String role_id;
	private String userRole;
	
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
}
