package org.cnpc.system.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;
@Entity public class PartyRole implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "partyrole_id", updatable = false, nullable = false)
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

	@ManyToOne
	@JoinColumn(name="roletype_id")
	private RoleType roleType = new RoleType();

	public RoleType getRoleType() {
		return this.roleType;
	}

	public void setRoleType(final RoleType roleType) {
		this.roleType = roleType;
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<ContactMechanism> partyContactMechanisms = new HashSet<ContactMechanism>();

	public Set<ContactMechanism> getPartyContactMechanisms() {
		return this.partyContactMechanisms;
	}

	public void setPartyContactMechanisms(
			final Set<ContactMechanism> partyContactMechanisms) {
		this.partyContactMechanisms = partyContactMechanisms;
	}
	

//	@ManyToOne
//	private Party party = new Party();
//
//	public Party getParty() {
//		return this.party;
//	}
//
//	public void setParty(final Party party) {
//		this.party = party;
//	}
//
//	@OneToMany(cascade = CascadeType.ALL, mappedBy="partyRoleFrom")
//	private Set<PartyRelationship> partyRelationshipFrom = new HashSet<PartyRelationship>();
//
//	public Set<PartyRelationship> getPartyRelationshipFrom() {
//		return this.partyRelationshipFrom;
//	}
//
//	public void setPartyRelationshipFrom(
//			final Set<PartyRelationship> partyRelationshipFrom) {
//		this.partyRelationshipFrom = partyRelationshipFrom;
//	}
//
//	@OneToMany(cascade = CascadeType.ALL, mappedBy="partyRoleTo")
//	private Set<PartyRelationship> partyRelationshipTo = new HashSet<PartyRelationship>();
//
//	public Set<PartyRelationship> getPartyRelationshipTo() {
//		return this.partyRelationshipTo;
//	}
//
//	public void setPartyRelationshipTo(
//			final Set<PartyRelationship> partyRelationshipTo) {
//		this.partyRelationshipTo = partyRelationshipTo;
//	} 
	
}