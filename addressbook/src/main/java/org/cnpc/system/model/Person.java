package org.cnpc.system.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllPersons", query = "SELECT p FROM Person p "
				+ "ORDER BY p.id"),
		@NamedQuery(name = "findPersonById", query = "SELECT p FROM Person p "
				+ "where p.id=:id"),
		@NamedQuery(name = "findPersonsByName", query = "SELECT p FROM Person p "
				+ "where p.currentLastName LIKE :name or p.currentFirstName LIKE :name"),
		@NamedQuery(name = "findPersonsByGender", query = "SELECT p FROM Person p "
				+ "where p.gender = :gender"),
		@NamedQuery(name = "findPersonsByWorkYears", query = "SELECT p FROM Person p "
				+ "where p.totalYearsWorkExperience = :workYears")})
@NamedNativeQueries({
	@NamedNativeQuery(name="findPersonsByOrganizationId", 
			query="SELECT * FROM Person p where p.id in (" +
			"select roleto.party_id from PartyRelationship relation, PartyRole rolefrom, PartyRole roleto " +
			"where realation.partyrelationshiptype_id = 1 and relation.partyrolefrom_id = rolefrom.id " +
			"and rolefrom.party_id = :organization_id and relation.partyroleto_id = roleto.id)",
			resultClass=Person.class)
})
public class Person extends Party implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Column
	private String currentLastName;

	@Column
	private String currentFirstName;

	@Column
	private Date birthDate;

	@Column
	private int gender;

	@Column
	private int socialSecurityNumber;

	@Column
	private int totalYearsWorkExperience;

	public String getCurrentLastName() {
		return this.currentLastName;
	}

	public void setCurrentLastName(final String currentLastName) {
		this.currentLastName = currentLastName;
	}

	public String getCurrentFirstName() {
		return currentFirstName;
	}

	public void setCurrentFirstName(String currentFirstName) {
		this.currentFirstName = currentFirstName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(int socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public int getTotalYearsWorkExperience() {
		return totalYearsWorkExperience;
	}

	public void setTotalYearsWorkExperience(int totalYearsWorkExperience) {
		this.totalYearsWorkExperience = totalYearsWorkExperience;
	}

}