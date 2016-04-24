package org.crce.interns.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "job_schema.company")

public class Company implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5397675977103455678L;

	@Id
	@Column(name="company_id")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer company_id;
	
	@Column(name="company_name")
	private String company_name;
	
	@Column(name="company_address")
	private String company_address;
	
	/*
	@OneToOne
	@JoinColumn(name="criteria_id")
	private Criteria criteria;
	*/
	
	@Column(name="criteria_id")
	private Integer criteria_id;
	
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
