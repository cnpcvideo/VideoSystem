package org.cnpc.system.model;


import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity 
public class PartyRelationship implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "partyrelationship_id", updatable = false, nullable = false)
	Long id = null;
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

	@ManyToOne(cascade = CascadeType.ALL) 
	private StatusType statusType = new StatusType();

	public StatusType getStatusType() {
		return this.statusType;
	}

	public void setStatusType(final StatusType statusType) {
		this.statusType = statusType;
	}
	
	@ManyToOne(cascade = CascadeType.ALL) 
	private PriorityType priorityType = new PriorityType();

	public PriorityType getPriorityType() {
		return this.priorityType;
	}

	public void setPriorityType(final PriorityType priorityType) {
		this.priorityType = priorityType;
	}
	

	@ManyToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name="partyrelationshiptype_id")
	private PartyRelationshipType partyRelationshipType = new PartyRelationshipType();

	public PartyRelationshipType getPartyRelationshipType() {
		return this.partyRelationshipType;
	}

	public void setPartyRelationshipType(
			final PartyRelationshipType partyRelationshipType) {
		this.partyRelationshipType = partyRelationshipType;
	}

	@Column
	private Date dateFrom;

	public Date getDateFrom() {
		return this.dateFrom;
	}

	public void setDateFrom(final Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	@Column
	private Date dateTo;

	public Date getDateTo() {
		return this.dateTo;
	}

	public void setDateTo(final Date dateTo) {
		this.dateTo = dateTo;
	}

	@Column
	private String comment;

	public String getComment() {
		return this.comment;
	}

	public void setComment(final String comment) {
		this.comment = comment;
	}

	@ManyToOne
	@JoinColumn(name="partyrolefrom_id")
	private PartyRole partyRoleFrom = new PartyRole();

	public PartyRole getPartyRoleFrom() {
		return this.partyRoleFrom;
	}

	public void setPartyRoleFrom(final PartyRole partyRoleFrom) {
		this.partyRoleFrom = partyRoleFrom;
	}

	@ManyToOne
	@JoinColumn(name="partyroleto_id")
	private PartyRole partyRoleTo = new PartyRole();

	public PartyRole getPartyRoleTo() {
		return this.partyRoleTo;
	}

	public void setPartyRoleTo(final PartyRole partyRoleTo) {
		this.partyRoleTo = partyRoleTo;
	} }