package org.cnpc.system.dao.impl;

import java.util.Set;

import javax.ejb.Stateless;

import org.cnpc.system.dao.OrganizationDAO;
import org.cnpc.system.model.Organization;


@Stateless
public class OrganizationDAOImpl extends BaseDAO implements OrganizationDAO {

	@Override
	public void saveOrganization(Organization o) {
		this.getEm().persist(o);
	}

	@Override
	public void removeOrganization(Organization o) {
		this.getEm().remove(o);
	}

	@Override
	public void updateOrganization(Organization o) {
		this.getEm().merge(o);
	}

	@Override
	public Organization findOrganizationById(Long id) {
		return this.getEm().find(Organization.class, id);
	}

	@Override
	public Set<Organization> findOrganizationByName(String name) {
		return (Set<Organization>) this.getEm()
				.createNamedQuery("findOrganizationsByName")
				.setParameter("name", name).getResultList();
	}

	@Override
	public Set<Organization> findAllOrganizations() {
		return (Set<Organization>) this.getEm()
				.createNamedQuery("findAllOrganizations").getResultList();
	}

	@Override
	public Set<Organization> findOrganizationsByPersonId(Long id) {
		return (Set<Organization>) this.getEm()
				.createNamedQuery("findOrganizationsByPersonId")
				.setParameter("person_id", id).getResultList();
	}

}
