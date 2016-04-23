package org.crce.interns.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name="job_schema.feedback")
public class Feedback implements Serializable {
	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@Column(name = "username")
	 @NotNull 
	 
	String username;
	@Column(name="feedback")
	 
	@Size(min=2, max=500)
	
	 String feeback;
	 @Column(name="company_name")
	 
	 @NotNull
	String company;
	 
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFeeback() {
		return feeback;
	}
	public void setFeeback(String feeback) {
		this.feeback = feeback;
	}
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}


}
