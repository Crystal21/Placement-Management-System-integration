package org.crce.interns.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
@Table(name = "user_schema.userdetails")
@SecondaryTables({
		@SecondaryTable(name = "user_schema.personal_profile", pkJoinColumns = @PrimaryKeyJoinColumn(name = "username") ),
		@SecondaryTable(name = "user_schema.professional_profile", pkJoinColumns = @PrimaryKeyJoinColumn(name = "username") )
		})
public class Faculty {
	
	@Id
	@Column(name="username")
	private String userId;
	
	@Column(name="name",table="user_schema.personal_profile")
	private String name;
	
	@Column(name="role_id")
	private String role_id;
	
	@Column(name="gender",table="user_schema.personal_profile")
	private String gender;
	
	@Column(name="email_id",table="user_schema.personal_profile")
	private String email;
	
	@Column(name="branch",table="user_schema.professional_profile")
	private String branch;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}


}
