package org.cnpc.system.dao.impl;

import java.util.List;

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
	public List<Organization> findOrganizationByName(String name) {
		return (List<Organization>) this.getEm()
				.createNamedQuery("findOrganizationsByName")
				.setParameter("name", name).getResultList();
	}

	@Override
	public List<Organization> findAllOrganizations() {
		return (List<Organization>) this.getEm()
				.createNamedQuery("findAllOrganizations").getResultList();
	}

	@Override
	public List<Organization> findOrganizationsByPersonId(Long id) {
		return (List<Organization>) this.getEm()
				.createNamedQuery("findOrganizationsByPersonId")
				.setParameter("person_id", id).getResultList();
	}

}
