package org.crce.interns.beans;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class NotifyForm {
	@NotEmpty
	@Size(min = 1, max = 50)
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
