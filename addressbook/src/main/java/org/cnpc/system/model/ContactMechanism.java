package org.cnpc.system.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE", discriminatorType=DiscriminatorType.STRING, length=10)
public abstract class ContactMechanism implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contactmechanism_id", updatable = false, nullable = false)
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

	@Column
	private String description;

	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
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

	@ManyToOne 
	@JoinColumn(name="contactmechanismpurpose_id", nullable=false)
	private ContactMechanismPurpose purpose = new ContactMechanismPurpose();

	public ContactMechanismPurpose getPurpose() {
		return this.purpose;
	}

	public void setPurpose(final ContactMechanismPurpose purpose) {
		this.purpose = purpose;
	}

	@ManyToOne
	@JoinColumn(name="partyrole_id", nullable=false)
	private PartyRole partyRole = new PartyRole();

	public PartyRole getPartyRole() {
		return this.partyRole;
	}

	public void setPartyRole(final PartyRole partyRole) {
		this.partyRole = partyRole;
	}

}