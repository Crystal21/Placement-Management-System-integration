package org.crce.interns.beans;

import org.crce.interns.model.Criteria;

public class CompanyBean {

	
	private Integer company_id;
	private String company_name;
	private String company_address;
	private Integer criteria_id;
	//private Criteria criteria;
	
	public Integer getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}
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
	/* **
	public Criteria getCriteria() {
		return criteria;
	}
	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}
	** */	
	
	public Integer getCriteria_id() {
		return criteria_id;
	}
	public void setCriteria_id(Integer criteria_id) {
		this.criteria_id = criteria_id;
	}
	
	
	
}
