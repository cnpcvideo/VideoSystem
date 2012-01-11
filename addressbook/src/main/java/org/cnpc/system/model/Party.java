package org.cnpc.system.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@MappedSuperclass
public class Party implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "party_id", updatable = false, nullable = false)
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

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="party_id")
	private Set<PartyRole> partyRoles = new HashSet<PartyRole>();

	public Set<PartyRole> getPartyRoles() {
		return this.partyRoles;
	}

	public void setPartyRoles(final Set<PartyRole> partyRoles) {
		this.partyRoles = partyRoles;
	}

}