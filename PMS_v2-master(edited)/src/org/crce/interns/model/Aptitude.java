package org.crce.interns.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
@Table(name="event_schema.aptitude_test")
/*@SecondaryTables({
	@SecondaryTable(name = "event_schema.event_details", pkJoinColumns = @PrimaryKeyJoinColumn(name = "event_id"))})
*/
public class Aptitude {
	@Id //@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="event_id")
	private String event_id; 
	
	@Column(name="test_duration")
	private String test_duration;
	
	@Column(name="subjects_to_be_prepared")
	private String subjects_to_be_prepared;
	
	@Column(name="test_sections")
	private String test_section;
	
	public String getEvent_id() {
		return event_id;
	}
	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}
	public String getTest_duration() {
		return test_duration;
	}
	public void setTest_duration(String test_duration) {
		this.test_duration = test_duration;
	}
	public String getSubjects_to_be_prepared() {
		return subjects_to_be_prepared;
	}
	public void setSubjects_to_be_prepared(String subjects_to_be_prepared) {
		this.subjects_to_be_prepared = subjects_to_be_prepared;
	}
	public String getTest_section() {
		return test_section;
	}
	public void setTest_section(String test_section) {
		this.test_section = test_section;
	}
}
