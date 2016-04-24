package org.crce.interns.model;
import java.io.Serializable;
import java.sql.Time;
//import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
import com.sun.istack.internal.NotNull;

@Entity
@Table(name="event_schema.event_details")
/*@SecondaryTables({
	@SecondaryTable(name = "job_schema.company", pkJoinColumns = @PrimaryKeyJoinColumn(name = "company_id")),
	@SecondaryTable(name = "event_schema.aptitude_test", pkJoinColumns = @PrimaryKeyJoinColumn(name = "event_id"))
	, @SecondaryTable(name = "event_schema.pre_placement_talk_or_other", pkJoinColumns = @PrimaryKeyJoinColumn(name = "event_id")),
	@SecondaryTable(name = "event_schema.interview", pkJoinColumns = @PrimaryKeyJoinColumn(name = "event_id"))
	})
*/	

public class Event implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7075636839311255864L;

	@Id //@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "event_id", nullable = false)
	@NotNull
	private String event_id;
	
	@Column(name="company_id")
	private int company_id;
	
	/*@Column(name="company_id", table="job_schema.company", insertable=false, updatable=false)
	private int company_id_company;
	
	@Column(name="company_id", table="job_schema.company", insertable=false, updatable=false)
	private int company_id_company_job;
*/	
	/*@Column(name="interview_type", table="event_schema.interview",insertable=true, updatable=true)
	private String interview_type;
	
	public String getInterview_type() {
		return interview_type;
	}

	public void setInterview_type(String interview_type) {
		this.interview_type = interview_type;
	}
*/

	@Column(name="approved")
	private String approved;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="time")
	private Date time;
	
	@Column(name="venue")
	private String venue;
	
	@Column(name="event_type")
	private String event_type;
	
	/*@Column(name="company_name",table="job_schema.company")
	private String company_name;
	
	@Column(name="company_address",table="job_schema.company")
	private String company_address;*/
	
	@Column(name="created_by")
	private String created_by;
	
	@Column(name="created_date")
	private Date created_date;
	
	@Column(name="modified_by")
	private String modified_by;
	
	@Column(name="modified_date")
	private Date modified_date;
	
	/*
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCompany_address() {
		return company_address;
	}
	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}
	*/
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public String getModified_by() {
		return modified_by;
	}
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	public Date getModified_date() {
		return modified_date;
	}
	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}
	
	//@OneToOne
	//private Interview interview;
	
	/*public int getCompany_id_company() {
		return company_id_company;
	}
	public void setCompany_id_company(int company_id_company) {
		this.company_id_company = company_id_company;
	}
	public int getCompany_id_company_job() {
		return company_id_company_job;
	}
	public void setCompany_id_company_job(int company_id_company_job) {
		this.company_id_company_job = company_id_company_job;
	}*/
	/*public Interview getInterview() {
		return interview;
	}
	public void setInterview(Interview interview) {
		this.interview = interview;
	}*/
	public String getEvent_id() {
		return event_id;
	}
	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public String getApproved() {
		return approved;
	}
	public void setApproved(String approved) {
		this.approved = approved;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getEvent_type() {
		return event_type;
	}
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
	
	
}
