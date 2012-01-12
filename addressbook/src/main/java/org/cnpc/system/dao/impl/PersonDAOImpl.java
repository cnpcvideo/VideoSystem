package org.cnpc.system.dao.impl;

import java.util.List;

import javax.ejb.Stateless;

import org.cnpc.system.dao.PersonDAO;
import org.cnpc.system.model.Person;


@Stateless
public class PersonDAOImpl extends BaseDAO implements PersonDAO {
	@Override
	public void savePerson(Person person) {
		this.getEm().persist(person);
	}

	@Override
	public void removePerson(Person person) {
		this.getEm().remove(person);
	}

	@Override
	public void updatePerson(Person person) {
		this.getEm().merge(person);
	}

	@Override
	public Person findPersonById(Long id) {
		return this.getEm().find(Person.class, id);
	}

	@Override
	public List<Person> findAllPersons() {
		return (List<Person>) this.getEm().createNamedQuery("findAllPersons")
				.getResultList();
	}

	@Override
	public List<Person> findPersonsByName(String name) {
		return (List<Person>) this.getEm().createNamedQuery("findPersonsByName")
				.setParameter("name", name).getResultList();
	}

	@Override
	public List<Person> findPersonsByGender(int gender) {
		return (List<Person>) this.getEm()
				.createNamedQuery("findPersonsByGender")
				.setParameter("gender", gender).getResultList();
	}

	@Override
	public List<Person> findPersonsByWorkYears(int workYears) {
		return (List<Person>) this.getEm()
				.createNamedQuery("findPersonsByWorkYears")
				.setParameter("workYears", workYears).getResultList();
	}

	@Override
	public List<Person> findPersonsByOrganizationId(Long organizationId) {
		return (List<Person>) this.getEm()
				.createNamedQuery("findPersonsByOrganizationId")
				.setParameter("organization_id", organizationId)
				.getResultList();
	}

}
