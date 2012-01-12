package org.cnpc.system.dao;

import java.util.List;

import org.cnpc.system.model.Organization;


public interface OrganizationDAO {
	public void saveOrganization(Organization o);

	public void removeOrganization(Organization o);

	public void updateOrganization(Organization o);

	public Organization findOrganizationById(Long id);

	public List<Organization> findOrganizationByName(String name) ;
	
	public List<Organization> findAllOrganizations();
	
	public List<Organization> findOrganizationsByPersonId(Long id);
}
