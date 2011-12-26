package com.contact.web;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.contact.entity.Department;
import com.contact.session.TestDepart;

@ManagedBean
@SessionScoped
public class DepartmentBean {

	@EJB
	private TestDepart testDepart;
	private String name;
	private String company_name;
	private List<Department> departmentList;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public void addDepartment(){
		testDepart.createNewDepart(name, company_name);
	}
	
	public List<Department> getDepartmentList(){
		return testDepart.getAllDepartments();
	}
	
	public void setDepartmentList(List<Department> list){
		this.departmentList = list;
	}
}
