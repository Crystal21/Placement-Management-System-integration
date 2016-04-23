
package org.crce.interns.beans;

import java.io.Serializable;

public class UserDetailsBean implements Serializable {
	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	private String roleId;
	
	
}

