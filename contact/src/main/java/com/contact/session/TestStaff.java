package com.contact.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.contact.entity.Company;
import com.contact.entity.Department;
import com.contact.entity.Staff;

@Stateful
public class TestStaff {
	
	@PersistenceContext
	private EntityManager em;
	
	@EJB
	private TestCompany testCompany;
	
	@EJB
	private TestDepart testDepart;
	
	public void createNewStaff(String staffName, String staffTell, String staffEmail,
			String staffPosition, String companyname, String departmentname){
		try {
			Company company = testCompany.getCompanyByName(companyname);
			Department depart = testDepart.getUniqueDepartment(departmentname, companyname);
            Staff staff = new Staff(staffName, staffTell, staffEmail, staffPosition, company, depart);
            em.persist(staff);
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
	}
	
	public List<Staff> getAllStaffs(){
		List<Staff> staffs = (List<Staff>) em.createNamedQuery("findAllStaffs").getResultList();
		return staffs;
	}
	
	 public void removeStaff(long staffid) {
	        try {
	            Staff staff = em.find(Staff.class, staffid);
	            em.remove(staff);
	        } catch (Exception e) {
	            throw new EJBException(e.getMessage());
	        }
	 }
	 
	 public void updateStaff(long staffid,String staffName, String staffTell, String staffEmail,
				String staffPosition, String companyName, String departName){
		 	try {
	            Staff staff = em.find(Staff.class, staffid);
	            staff.setStaffName(staffName);
	            staff.setStaffTell(staffTell);
	            staff.setStaffEmail(staffEmail);
	            staff.setStaffPosition(staffPosition);
	            //em.persist(staff);
	            Company company = testCompany.getCompanyByName(companyName);
				Department depart = testDepart.getUniqueDepartment(departName, companyName);
	            staff.setCompany(company);
	            staff.setDepartment(depart);
	        } catch (Exception e) {
	            throw new EJBException(e.getMessage());
	        }
	 }
}
