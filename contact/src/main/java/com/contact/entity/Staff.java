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
import javax.validation.constraints.Size;

@Entity
@Table(name = "CONTACT_STAFF")
@NamedQueries({
	@NamedQuery(name = "findAllStaffs", query = "SELECT s FROM Staff s "
			+ "ORDER BY s.staffID")			
	})
public class Staff implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long staffID;
	private String staffName;
	private String staffTell;
	private String staffEmail;
	private String staffPosition;
	private Company company;
	private Department department;
	
	public Staff(){}
	
	public Staff(String staffName, String staffTell, String staffEmail,
			String staffPosition, Company company, Department department) {
		super();
		this.staffName = staffName;
		this.staffTell = staffTell;
		this.staffEmail = staffEmail;
		this.staffPosition = staffPosition;
		this.company = company;
		this.department = department;
	}



	public Staff(long staffID, String staffName, String staffTell,
			String staffEmail, String staffPosition, Company company,
			Department department) {
		super();
		this.staffID = staffID;
		this.staffName = staffName;
		this.staffTell = staffTell;
		this.staffEmail = staffEmail;
		this.staffPosition = staffPosition;
		this.company = company;
		this.department = department;
	}

	@Id
	@GeneratedValue
	@Column(name="staffid", nullable = false)
	public long getStaffID() {
		return staffID;
	}
	
	public void setStaffID(long staffID) {
		this.staffID = staffID;
	}
	
	@Column(name = "staffname")
	@NotNull
	public String getStaffName() {
		return staffName;
	}
	
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	
	@Column(name="stafftell")
	@NotNull
	@Size(min = 11,max = 11)
	public String getStaffTell() {
		return staffTell;
	}
	
	public void setStaffTell(String staffTell) {
		this.staffTell = staffTell;
	}
	
	@Column(name="staffemail")
	@NotNull
	public String getStaffEmail() {
		return staffEmail;
	}
	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}
	
	@Column(name="staffposition")
	@NotNull
	public String getStaffPosition() {
		return staffPosition;
	}
	public void setStaffPosition(String staffPosition) {
		this.staffPosition = staffPosition;
	}
	
	@ManyToOne
	@NotNull
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	@ManyToOne
	@NotNull
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
