package org.crce.interns.model;

import java.io.Serializable;

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
		@SecondaryTable(name = "user_schema.professional_profile", pkJoinColumns = @PrimaryKeyJoinColumn(name = "username") ),
		@SecondaryTable(name = "user_schema.qualification", pkJoinColumns = @PrimaryKeyJoinColumn(name = "username") ) })
public class Student implements Serializable {
	
	private static final long serialVersionUID = -723583058586873479L;
	@Id
	@Column(name="username")
	private String rollno;
	
	@Column(name="name",table="user_schema.personal_profile")
	private String name;
	
	@Column(name="branch",table="user_schema.professional_profile")
	private String branch;
	
	@Column(name="year",table="user_schema.professional_profile")
	private String year;
	
	@Column(name="gender",table="user_schema.personal_profile")
	private String gender;
	
	@Column(name="dob",table="user_schema.personal_profile")
	private String dob;
	
	@Column(name="mobile_no",table="user_schema.personal_profile")
	private String mobile;
	
	@Column(name="email_id",table="user_schema.personal_profile")
	private String email;
	
	@Column(name="ssc_per",table="user_schema.qualification")
	private String ssc_per;
	
	@Column(name="hsc_or_dip",table="user_schema.qualification")
	private String hsc_or_dip;
	
	@Column(name="hsc_or_dip_per",table="user_schema.qualification")
	private String hsc_or_dip_per;
	
	@Column(name="s1_mark",table="user_schema.qualification")
	private String s1_marks;
	
	@Column(name="s1_max",table="user_schema.qualification")
	private String s1_max;
	
	@Column(name="s1_per",table="user_schema.qualification")
	private String s1_percentage;
	
	@Column(name="s1_res",table="user_schema.qualification")
	private String s1_result;
	
	@Column(name="s1_kt",table="user_schema.qualification")
	private String s1_kt;
	
	@Column(name="s2_mark",table="user_schema.qualification")
	private String s2_marks;
	
	@Column(name="s2_max",table="user_schema.qualification")
	private String s2_max;
	
	@Column(name="s2_per",table="user_schema.qualification")
	private String s2_percentage;
	
	@Column(name="s2_res",table="user_schema.qualification")
	private String s2_result;
	
	@Column(name="s2_kt",table="user_schema.qualification")
	private String s2_kt;
	
	@Column(name="s3_mark",table="user_schema.qualification")
	private String s3_marks;
	
	@Column(name="s3_max",table="user_schema.qualification")
	private String s3_max;
	
	@Column(name="s3_per",table="user_schema.qualification")
	private String s3_percentage;
	
	@Column(name="s3_res",table="user_schema.qualification")
	private String s3_result;
	
	@Column(name="s3_kt",table="user_schema.qualification")
	private String s3_kt;
	
	@Column(name="s4_mark",table="user_schema.qualification")
	private String s4_marks;
	
	@Column(name="s4_max",table="user_schema.qualification")
	private String s4_max;
	
	@Column(name="s4_per",table="user_schema.qualification")
	private String s4_percentage;
	
	@Column(name="s4_res",table="user_schema.qualification")
	private String s4_result;
	
	@Column(name="s4_kt",table="user_schema.qualification")
	private String s4_kt;
	
	@Column(name="s5_mark",table="user_schema.qualification")
	private String s5_marks;
	
	@Column(name="s5_max",table="user_schema.qualification")
	private String s5_max;
	
	@Column(name="s5_per",table="user_schema.qualification")
	private String s5_percentage;
	
	@Column(name="s5_res",table="user_schema.qualification")
	private String s5_result;
	
	@Column(name="s5_kt",table="user_schema.qualification")
	private String s5_kt;
	
	@Column(name="s6_mark",table="user_schema.qualification")
	private String s6_marks;
	
	@Column(name="s6_max",table="user_schema.qualification")
	private String s6_max;
	
	@Column(name="s6_per",table="user_schema.qualification")
	private String s6_percentage;
	
	@Column(name="s6_res",table="user_schema.qualification")
	private String s6_result;
	
	@Column(name="s6_kt",table="user_schema.qualification")
	private String s6_kt;
	
	@Column(name="s7_mark",table="user_schema.qualification")
	private String s7_marks;
	
	@Column(name="s7_max",table="user_schema.qualification")
	private String s7_max;
	
	@Column(name="s7_per",table="user_schema.qualification")
	private String s7_percentage;
	
	@Column(name="s7_res",table="user_schema.qualification")
	private String s7_result;
	
	@Column(name="s7_kt",table="user_schema.qualification")
	private String s7_kt;
	
	@Column(name="s8_mark",table="user_schema.qualification")
	private String s8_marks;
	
	@Column(name="s8_max",table="user_schema.qualification")
	private String s8_max;
	
	@Column(name="s8_per",table="user_schema.qualification")
	private String s8_percentage;
	
	@Column(name="s8_res",table="user_schema.qualification")
	private String s8_result;
	
	@Column(name="s8_kt",table="user_schema.qualification")
	private String s8_kt;
	
	@Column(name="deg_per",table="user_schema.qualification")
	private String degree_percentage;
	
	@Column(name="deg_kt",table="user_schema.qualification")
	private String degree_kt;
	
	@Column(name="drops",table="user_schema.qualification")
	private String drops;

	@Column(name="role_id")
	private String role_id;
	
	
	
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSsc_per() {
		return ssc_per;
	}

	public void setSsc_per(String ssc_per) {
		this.ssc_per = ssc_per;
	}

	public String getHsc_or_dip() {
		return hsc_or_dip;
	}

	public void setHsc_or_dip(String hsc_or_dip) {
		this.hsc_or_dip = hsc_or_dip;
	}

	public String getHsc_or_dip_per() {
		return hsc_or_dip_per;
	}

	public void setHsc_or_dip_per(String hsc_or_dip_per) {
		this.hsc_or_dip_per = hsc_or_dip_per;
	}

	public String getS1_marks() {
		return s1_marks;
	}

	public void setS1_marks(String s1_marks) {
		this.s1_marks = s1_marks;
	}

	public String getS1_max() {
		return s1_max;
	}

	public void setS1_max(String s1_max) {
		this.s1_max = s1_max;
	}

	public String getS1_percentage() {
		return s1_percentage;
	}

	public void setS1_percentage(String s1_percentage) {
		this.s1_percentage = s1_percentage;
	}

	public String getS1_result() {
		return s1_result;
	}

	public void setS1_result(String s1_result) {
		this.s1_result = s1_result;
	}

	public String getS1_kt() {
		return s1_kt;
	}

	public void setS1_kt(String s1_kt) {
		this.s1_kt = s1_kt;
	}

	public String getS2_marks() {
		return s2_marks;
	}

	public void setS2_marks(String s2_marks) {
		this.s2_marks = s2_marks;
	}

	public String getS2_max() {
		return s2_max;
	}

	public void setS2_max(String s2_max) {
		this.s2_max = s2_max;
	}

	public String getS2_percentage() {
		return s2_percentage;
	}

	public void setS2_percentage(String s2_percentage) {
		this.s2_percentage = s2_percentage;
	}

	public String getS2_result() {
		return s2_result;
	}

	public void setS2_result(String s2_result) {
		this.s2_result = s2_result;
	}

	public String getS2_kt() {
		return s2_kt;
	}

	public void setS2_kt(String s2_kt) {
		this.s2_kt = s2_kt;
	}

	public String getS3_marks() {
		return s3_marks;
	}

	public void setS3_marks(String s3_marks) {
		this.s3_marks = s3_marks;
	}

	public String getS3_max() {
		return s3_max;
	}

	public void setS3_max(String s3_max) {
		this.s3_max = s3_max;
	}

	public String getS3_percentage() {
		return s3_percentage;
	}

	public void setS3_percentage(String s3_percentage) {
		this.s3_percentage = s3_percentage;
	}

	public String getS3_result() {
		return s3_result;
	}

	public void setS3_result(String s3_result) {
		this.s3_result = s3_result;
	}

	public String getS3_kt() {
		return s3_kt;
	}

	public void setS3_kt(String s3_kt) {
		this.s3_kt = s3_kt;
	}

	public String getS4_marks() {
		return s4_marks;
	}

	public void setS4_marks(String s4_marks) {
		this.s4_marks = s4_marks;
	}

	public String getS4_max() {
		return s4_max;
	}

	public void setS4_max(String s4_max) {
		this.s4_max = s4_max;
	}

	public String getS4_percentage() {
		return s4_percentage;
	}

	public void setS4_percentage(String s4_percentage) {
		this.s4_percentage = s4_percentage;
	}

	public String getS4_result() {
		return s4_result;
	}

	public void setS4_result(String s4_result) {
		this.s4_result = s4_result;
	}

	public String getS4_kt() {
		return s4_kt;
	}

	public void setS4_kt(String s4_kt) {
		this.s4_kt = s4_kt;
	}

	public String getS5_marks() {
		return s5_marks;
	}

	public void setS5_marks(String s5_marks) {
		this.s5_marks = s5_marks;
	}

	public String getS5_max() {
		return s5_max;
	}

	public void setS5_max(String s5_max) {
		this.s5_max = s5_max;
	}

	public String getS5_percentage() {
		return s5_percentage;
	}

	public void setS5_percentage(String s5_percentage) {
		this.s5_percentage = s5_percentage;
	}

	public String getS5_result() {
		return s5_result;
	}

	public void setS5_result(String s5_result) {
		this.s5_result = s5_result;
	}

	public String getS5_kt() {
		return s5_kt;
	}

	public void setS5_kt(String s5_kt) {
		this.s5_kt = s5_kt;
	}

	public String getS6_marks() {
		return s6_marks;
	}

	public void setS6_marks(String s6_marks) {
		this.s6_marks = s6_marks;
	}

	public String getS6_max() {
		return s6_max;
	}

	public void setS6_max(String s6_max) {
		this.s6_max = s6_max;
	}

	public String getS6_percentage() {
		return s6_percentage;
	}

	public void setS6_percentage(String s6_percentage) {
		this.s6_percentage = s6_percentage;
	}

	public String getS6_result() {
		return s6_result;
	}

	public void setS6_result(String s6_result) {
		this.s6_result = s6_result;
	}

	public String getS6_kt() {
		return s6_kt;
	}

	public void setS6_kt(String s6_kt) {
		this.s6_kt = s6_kt;
	}

	public String getS7_marks() {
		return s7_marks;
	}

	public void setS7_marks(String s7_marks) {
		this.s7_marks = s7_marks;
	}

	public String getS7_max() {
		return s7_max;
	}

	public void setS7_max(String s7_max) {
		this.s7_max = s7_max;
	}

	public String getS7_percentage() {
		return s7_percentage;
	}

	public void setS7_percentage(String s7_percentage) {
		this.s7_percentage = s7_percentage;
	}

	public String getS7_result() {
		return s7_result;
	}

	public void setS7_result(String s7_result) {
		this.s7_result = s7_result;
	}

	public String getS7_kt() {
		return s7_kt;
	}

	public void setS7_kt(String s7_kt) {
		this.s7_kt = s7_kt;
	}

	public String getS8_marks() {
		return s8_marks;
	}

	public void setS8_marks(String s8_marks) {
		this.s8_marks = s8_marks;
	}

	public String getS8_max() {
		return s8_max;
	}

	public void setS8_max(String s8_max) {
		this.s8_max = s8_max;
	}

	public String getS8_percentage() {
		return s8_percentage;
	}

	public void setS8_percentage(String s8_percentage) {
		this.s8_percentage = s8_percentage;
	}

	public String getS8_result() {
		return s8_result;
	}

	public void setS8_result(String s8_result) {
		this.s8_result = s8_result;
	}

	public String getS8_kt() {
		return s8_kt;
	}

	public void setS8_kt(String s8_kt) {
		this.s8_kt = s8_kt;
	}

	public String getDegree_percentage() {
		return degree_percentage;
	}

	public void setDegree_percentage(String degree_percentage) {
		this.degree_percentage = degree_percentage;
	}

	public String getDegree_kt() {
		return degree_kt;
	}

	public void setDegree_kt(String degree_kt) {
		this.degree_kt = degree_kt;
	}

	public String getDrops() {
		return drops;
	}

	public void setDrops(String drops) {
		this.drops = drops;
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

}
