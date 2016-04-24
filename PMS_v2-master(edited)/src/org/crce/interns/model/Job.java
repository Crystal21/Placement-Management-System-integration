package org.crce.interns.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "job_schema.job")

public class Job implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2839297082326753121L;

	@Id
	@Column(name="job_id")
	private String job_id;
	
	@Column(name="event_id")
	private String event_id;
	
	@Column(name="job_description")
	private String job_description;
	
	@Column(name="job_category")
	private String job_category;
	
	@Column(name="ctc")
	private String ctc;
	
	@Column(name="skills_required")
	private String skills_required;
	
	@Column(name="docs_required")
	private String docs_required;
	
	@Column(name="drive_date")
	private Date drive_date;
	
	@Column(name="created_date")
	private Date created_date;
	
	@Column(name="created_by")
	private String created_by;
	
	@Column(name="modified_date")
	private Date modified_date;
	
	@Column(name="modified_by")
	private String modified_by;
	
	
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public String getEvent_id() {
		return event_id;
	}
	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}
	public String getJob_description() {
		return job_description;
	}
	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}
	public String getJob_category() {
		return job_category;
	}
	public void setJob_category(String job_category) {
		this.job_category = job_category;
	}
	public String getCtc() {
		return ctc;
	}
	public void setCtc(String ctc) {
		this.ctc = ctc;
	}
	public String getSkills_required() {
		return skills_required;
	}
	public void setSkills_required(String skills_required) {
		this.skills_required = skills_required;
	}
	public String getDocs_required() {
		return docs_required;
	}
	public void setDocs_required(String docs_required) {
		this.docs_required = docs_required;
	}
	
	public Date getDrive_date() {
		return drive_date;
	}
	public void setDrive_date(Date drive_date) {
		this.drive_date = drive_date;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public Date getModified_date() {
		return modified_date;
	}
	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}
	public String getModified_by() {
		return modified_by;
	}
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	
		
}
