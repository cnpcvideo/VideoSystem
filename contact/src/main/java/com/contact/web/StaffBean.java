package com.contact.web;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import com.contact.annotation.StaffList;
import com.contact.entity.Staff;
import com.contact.session.TestStaff;

@ManagedBean
@SessionScoped
public class StaffBean {

	@EJB
	private TestStaff testStaff;

	private long staffID;
	private String name;
	private String tell;
	private String email;
	private String position;
	private String company_name;
	private String department_name;
	
	@Inject
	@StaffList
	private List<Staff> staffList;

	public long getStaffID() {
		return staffID;
	}

	public void setStaffID(long staffID) {
		this.staffID = staffID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTell() {
		return tell;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public void addStaff() {
		testStaff.createNewStaff(name, tell, email, position, company_name,
				department_name);
	}
	
	@Produces
	@StaffList
	public List<Staff> getStaffList() {
		return testStaff.getAllStaffs();
	}

	public void setStaffList(List<Staff> list) {
		this.staffList = list;
	}

	public void deleteStaff(long staffid) {
		testStaff.removeStaff(staffid);
	}

	public void updateStaffEvent(ActionEvent event) {
		UIParameter param_id = (UIParameter) event.getComponent().findComponent("updateID");
		UIParameter param_name = (UIParameter) event.getComponent().findComponent("updateName");
		UIParameter param_position = (UIParameter) event.getComponent().findComponent("updatePosition");
		UIParameter param_tell = (UIParameter) event.getComponent().findComponent("updateTell");
		UIParameter param_email = (UIParameter) event.getComponent().findComponent("updateEmail");
		UIParameter param_company = (UIParameter) event.getComponent().findComponent("updateCompanyName");
		UIParameter param_depart = (UIParameter) event.getComponent().findComponent("updateDepartName");
		
		long id;
		if(param_id != null)
		{
			id = Long.parseLong(param_id.getValue().toString());
		}else{
			id = 0;
			System.out.println("!111111111111111111111111null");
		}
		String name = param_name.getValue().toString();
		String position = param_position.getValue().toString();
		String tell = param_tell.getValue().toString();
		String email = param_email.getValue().toString();
		String companyName = param_company.getValue().toString();
		String departName = param_depart.getValue().toString();
		
		testStaff.updateStaff(id, name, tell, email, position, companyName, departName);
	}

	public void updateStaff(long staffid, String staffName, String staffTell,
			String staffEmail, String staffPosition, String companyName,
			String departName) {
		System.out.println("staffid:" + staffid);
		System.out.println("staffName:" + staffName);
		System.out.println("stafftell:" + staffTell);
		System.out.println("staffemail:" + staffEmail);
		System.out.println("staffPosition:" + staffPosition);
		System.out.println("staffCompany:" + companyName);
		System.out.println("staffDepart:" + departName);
		testStaff.updateStaff(staffid, staffName, staffTell, staffEmail,
				staffPosition, companyName, departName);
	}
}
