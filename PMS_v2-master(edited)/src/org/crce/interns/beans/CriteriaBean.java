package org.crce.interns.beans;

import java.util.Date;

//import java.util.Date;

public class CriteriaBean {

	
	private Integer criteria_id;
	private String eligible_branches;
	private String year_of_passing;
	private String placed_students_allowed;
	private String percentage;
	private String cgpa;
	private String no_of_live_kts_allowed;
	private String no_of_dead_kts_allowed;
	private String year_gap_allowed;
	private String ssc_percentage;
	private String hsc_or_dip_percentage;
	private Date last_date_to_apply;
	
	public String getEligible_branches() {
		return eligible_branches;
	}
	public Integer getCriteria_id() {
		return criteria_id;
	}
	public void setCriteria_id(Integer criteria_id) {
		this.criteria_id = criteria_id;
	}
	public void setEligible_branches(String eligible_branches) {
		this.eligible_branches = eligible_branches;
	}
	public String getYear_of_passing() {
		return year_of_passing;
	}
	public void setYear_of_passing(String year_of_passing) {
		this.year_of_passing = year_of_passing;
	}
	public String getPlaced_students_allowed() {
		return placed_students_allowed;
	}
	public void setPlaced_students_allowed(String placed_students_allowed) {
		this.placed_students_allowed = placed_students_allowed;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public String getCgpa() {
		return cgpa;
	}
	public void setCgpa(String cgpa) {
		this.cgpa = cgpa;
	}
	public String getNo_of_live_kts_allowed() {
		return no_of_live_kts_allowed;
	}
	public void setNo_of_live_kts_allowed(String no_of_live_kts_allowed) {
		this.no_of_live_kts_allowed = no_of_live_kts_allowed;
	}
	public String getNo_of_dead_kts_allowed() {
		return no_of_dead_kts_allowed;
	}
	public void setNo_of_dead_kts_allowed(String no_of_dead_kts_allowed) {
		this.no_of_dead_kts_allowed = no_of_dead_kts_allowed;
	}
	public String getYear_gap_allowed() {
		return year_gap_allowed;
	}
	public void setYear_gap_allowed(String year_gap_allowed) {
		this.year_gap_allowed = year_gap_allowed;
	}
	public String getSsc_percentage() {
		return ssc_percentage;
	}
	public void setSsc_percentage(String ssc_percentage) {
		this.ssc_percentage = ssc_percentage;
	}
	public String getHsc_or_dip_percentage() {
		return hsc_or_dip_percentage;
	}
	public void setHsc_or_dip_percentage(String hsc_or_dip_percentage) {
		this.hsc_or_dip_percentage = hsc_or_dip_percentage;
	}
	public Date getLast_date_to_apply() {
		return last_date_to_apply;
	}
	public void setLast_date_to_apply(Date last_date_to_apply) {
		this.last_date_to_apply = last_date_to_apply;
	}
	
	
}


