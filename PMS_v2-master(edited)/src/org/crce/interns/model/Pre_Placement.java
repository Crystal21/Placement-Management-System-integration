package org.crce.interns.model;

import java.io.Serializable;

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
@Table(name="event_schema.pre_placement_talk_or_other")
/*@SecondaryTables({
	@SecondaryTable(name = "event_schema.event_details", pkJoinColumns = @PrimaryKeyJoinColumn(name = "event_id"))})
*/
public class Pre_Placement implements Serializable{
	@Id //@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="event_id")
	private String event_id;
	//private int company_id;
	@Column(name="conducted_by")
	private String conducted_by;
	
	@Column(name="agenda")
	private String agenda;
	
	public String getEvent_id() {
		return event_id;
	}
	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}
	public String getConducted_by() {
		return conducted_by;
	}
	public void setConducted_by(String conducted_by) {
		this.conducted_by = conducted_by;
	}
	public String getAgenda() {
		return agenda;
	}
	public void setAgenda(String agenda) {
		this.agenda = agenda;
	}

}
