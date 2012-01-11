package org.cnpc.system.dao;

import java.util.Set;

import org.cnpc.system.model.Person;


public interface PersonDAO {
	public void savePerson(Person person);

	public void removePerson(Person person);

	public void updatePerson(Person person);

	public Person findPersonById(Long id);

	public Set<Person> findAllPersons();

	public Set<Person> findPersonsByName(String name);
	
	public Set<Person> findPersonsByGender(String gender);
	
	public Set<Person> findPersonsByWorkYears(int workYears);
	
	public Set<Person> findPersonsByOrganizationId(Long organizationId);
}
