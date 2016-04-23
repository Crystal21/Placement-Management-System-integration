package org.crce.interns.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "role_function_schema.role_master")
@Table(name = "sample.role_master")
public class RMUser implements Serializable {
	@Id
	@Column(name = "role_id", nullable = false)
	private String role_id;
	
	@Column(name = "role_name")
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
