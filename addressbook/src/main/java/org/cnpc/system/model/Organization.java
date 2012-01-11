package org.cnpc.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllOrganizations", query = "SELECT o FROM Organization o "
				+ "ORDER BY o.id"),
		@NamedQuery(name = "findOrganizationById", query = "SELECT o FROM Organization o "
				+ "where o.id = :id"),
		@NamedQuery(name = "findOrganizationsByName", query = "SELECT o FROM Organization o "
				+ "where o.name LIKE :name") })
@NamedNativeQueries({
	@NamedNativeQuery(name="findOrganizationsByPersonId", 
			query="SELECT * FROM Organization o where o.id in (" +
			"select rolefrom.party_id from PartyRelationship relation, PartyRole rolefrom, PartyRole roleto " +
			"where realation.partyrelationshiptype_id = 1 and relation.partyroleto_id = roleto.id " +
			"and roleto.party_id = :person_id and relation.partyrolefrom_id = rolefrom.id)",
			resultClass=Organization.class)
})

public class Organization extends Party implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Column
	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}
}