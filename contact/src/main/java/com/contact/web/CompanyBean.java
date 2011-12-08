package com.contact.web;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.contact.entity.Company;
import com.contact.session.TestCompany;

@ManagedBean
@SessionScoped
public class CompanyBean {

	@EJB
	private TestCompany testCompany;
	private String name;
	private String abbre;
	private List<Company> companyList;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAbbre() {
		return abbre;
	}
	public void setAbbre(String abbre) {
		this.abbre = abbre;
	}
	
	public void addCompany(){
		testCompany.createNewCompany(name, abbre);
	}
	
	public List<Company> getCompanyList(){
		return testCompany.getAllCompanys();
	}
	
	public void setCompanyList(List<Company> list){
		this.companyList = list;
	}
}
