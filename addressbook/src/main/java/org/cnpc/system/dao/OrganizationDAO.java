package org.cnpc.system.dao;

import java.util.Set;

import org.cnpc.system.model.Organization;


public interface OrganizationDAO {
	public void saveOrganization(Organization o);

	public void removeOrganization(Organization o);

	public void updateOrganization(Organization o);

	public Organization findOrganizationById(Long id);

	public Set<Organization> findOrganizationByName(String name) ;
	
	public Set<Organization> findAllOrganizations();
	
	public Set<Organization> findOrganizationsByPersonId(Long id);
}
