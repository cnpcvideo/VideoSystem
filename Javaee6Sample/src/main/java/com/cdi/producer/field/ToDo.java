package com.cdi.producer.field;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
public class ToDo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	Long id = null;
	
	@Column
	protected String taskText;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	protected Date timeCreated;
	
	
	@Version
	private @Column(name = "version")
	int version = 0;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	@Column
	private String exit;

	public String getExit() {
		return this.exit;
	}

	public void setExit(final String exit) {
		this.exit = exit;
	}
	
	public Date getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Date timeCreated) {
		this.timeCreated = timeCreated;
	}

	public String getTaskText() {
		return this.taskText;
	}

	public void setTaskText(final String taskText) {
		this.taskText = taskText;
	}
}