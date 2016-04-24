package org.crce.interns.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room_allotment.allotment")

public class Allotment implements Serializable{

	
	private static final long serialVersionUID = 3924163780669412934L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="allotment_id")
	private Integer allotment_id;
	
	@Column(name="company_name")
	private String company_name;
	
	@Column(name="round_no")
	private String round_no;
	
	@Column(name="room_no")
	private String room_no;
	
	@Column(name="job_description")
	private String job_description;
	
	@Column(name="drive_date")
	private Date drive_date;
	
	
	@Column(name="room_path")
	private String fileUpload;
	
	
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getRound_no() {
		return round_no;
	}
	public void setRound_no(String round_no) {
		this.round_no = round_no;
	}
	public String getRoom_no() {
		return room_no;
	}
	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}
	public String getJob_description() {
		return job_description;
	}
	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}
	
	public Date getDrive_date() {
		return drive_date;
	}
	public void setDrive_date(Date drive_date) {
		this.drive_date = drive_date;
	}
	public Integer getAllotment_id() {
		return allotment_id;
	}
	public void setAllotment_id(Integer allotment_id) {
		this.allotment_id = allotment_id;
	}
	public String getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(String fileUpload) {
		this.fileUpload = fileUpload;
	}
	

}
