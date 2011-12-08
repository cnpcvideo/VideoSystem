package com.contact.session;

import java.util.Iterator;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.contact.entity.Company;

@Stateful
public class TestCompany {
	
	@PersistenceContext
	private EntityManager em;
	
	public void createNewCompany(String name, String abbre){
		try {
            Company company = new Company(name,abbre);
            em.persist(company);
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
	}
	
	public List<Company> getAllCompanys(){
		List<Company> companys = (List<Company>) em.createNamedQuery("findAllCompanys").getResultList();
		return companys;
	}
	
	public Company getCompanyByName(String name){
		List companys = em.createNamedQuery("findCompanyByName")
                .setParameter("name", name)
                .getResultList();
		
		Iterator iterator = companys.iterator();
		Company company = null;
		
		if(iterator.hasNext()){
			company = (Company) iterator.next();
		}
		
		return company;
	}
}
