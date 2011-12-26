package com.contact.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="CONTACT_DEPARTMENT")
@NamedQueries({
				@NamedQuery(name = "findAllDepartments", query = "SELECT d FROM Department d "
						+ "ORDER BY d.departID"),
				@NamedQuery(name = "findDepartByName", query = "SELECT d FROM Department d "
						+ "WHERE  d.departName = :name"),
				@NamedQuery(name = "findUniqueDepart", query = "SELECT d FROM Department d "
						+ "WHERE  d.departName = :name and d.company = :company")				
				})
public class Department implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long departID;
	private String departName;
	private Company company;
	
	public Department() {
		
	}

	public Department(String departName, Company company) {
		super();
		this.departName = departName;
		this.company = company;
	}

	public Department(long departID, String departName, Company company) {
		super();
		this.departID = departID;
		this.departName = departName;
		this.company = company;
	}

	@Id
	@GeneratedValue
	@Column(name = "departid", nullable=false)
	public long getDepartID() {
		return departID;
	}
	
	public void setDepartID(long departID) {
		this.departID = departID;
	}
	
	@Column(name = "departname")
	@NotNull
	public String getDepartName() {
		return departName;
	}
	
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	
	@ManyToOne
	@NotNull
	public Company getCompany() {
		return company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}
	
}
