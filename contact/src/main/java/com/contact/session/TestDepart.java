package com.contact.session;

import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.contact.entity.Company;
import com.contact.entity.Department;

@Stateful
public class TestDepart {
	
	@PersistenceContext
	private EntityManager em;
	
	@EJB
	private TestCompany testCompany;
	
	public void createNewDepart(String name, String companyname){
		try {
			Company company = testCompany.getCompanyByName(companyname);
            Department department = new Department(name,company);
            em.persist(department);
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
	}
	
	public List<Department> getAllDepartments(){
		List<Department> departs = (List<Department>) em.createNamedQuery("findAllDepartments").getResultList();
		return departs;
	}
	
	public List<Department> getDepartmentByName(String name){
		List departs = em.createNamedQuery("findDepartByName")
                .setParameter("name", name)
                .getResultList();
		
		return departs;
	}
	
	public Department getUniqueDepartment(String name, String companyname){
		Company company = testCompany.getCompanyByName(companyname);
		
		List departs = em.createNamedQuery("findUniqueDepart")
                .setParameter("name", name)
                .setParameter("company", company)
                .getResultList();
		
		Iterator iterator = departs.iterator();
		Department depart = null;
		
		if(iterator.hasNext()){
			depart = (Department) iterator.next();
		}
		
		return depart;
	}
}
