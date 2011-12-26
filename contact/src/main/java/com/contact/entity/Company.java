package com.contact.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="CONTACT_COMPANY",
	uniqueConstraints = @UniqueConstraint(columnNames = "companyname"))
@NamedQueries({
	@NamedQuery(name = "findAllCompanys", query = "SELECT c FROM Company c "
			+ "ORDER BY c.companyID") ,
	@NamedQuery(name = "findCompanyByName", query = "SELECT c FROM Company c "
			+ "WHERE c.companyName = :name")
	})
public class Company implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private long companyID;
	private String companyName;
	private String companyAbbre;
	
	public Company(){}
	
	public Company(String companyName, String companyAbbre) {
		super();
		this.companyName = companyName;
		this.companyAbbre = companyAbbre;
	}

	public Company(long companyID, String companyName, String companyAbbre) {
		super();
		this.companyID = companyID;
		this.companyName = companyName;
		this.companyAbbre = companyAbbre;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="companyid", updatable=false, nullable=false)
	public long getCompanyID() {
		return companyID;
	}
	
	public void setCompanyID(long companyID) {
		this.companyID = companyID;
	}
	
	@Column(name="companyname")
	@NotNull
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Column(name="companyabbre")
	public String getCompanyAbbre() {
		return companyAbbre;
	}
	
	public void setCompanyAbbre(String companyAbbre) {
		this.companyAbbre = companyAbbre;
	}

}