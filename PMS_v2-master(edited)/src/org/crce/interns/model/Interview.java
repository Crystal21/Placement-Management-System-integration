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
@Table(name="event_schema.interview")
/*@SecondaryTables({
	@SecondaryTable(name = "event_schema.event_id", pkJoinColumns = @PrimaryKeyJoinColumn(name = "event_id"))})
*/
public class Interview {
	@Id //@GeneratedValue
	@Column(name="event_id")
	private String event_id;
	
	@Column(name="interview_type")
	private String interview_type;
	
	public String getInterview_type() {
		return interview_type;
	}

	public void setInterview_type(String interview_type) {
		this.interview_type = interview_type;
	}

	public String getEvent_id() {
		return event_id;
	}

	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}

}
