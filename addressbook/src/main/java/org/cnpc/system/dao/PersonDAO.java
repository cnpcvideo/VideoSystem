package org.cnpc.system.dao;

import java.util.List;

import org.cnpc.system.model.Person;


public interface PersonDAO {
	public void savePerson(Person person);

	public void removePerson(Person person);

	public void updatePerson(Person person);

	public Person findPersonById(Long id);

	public List<Person> findAllPersons();

	public List<Person> findPersonsByName(String name);
	
	public List<Person> findPersonsByGender(int gender);
	
	public List<Person> findPersonsByWorkYears(int workYears);
	
	public List<Person> findPersonsByOrganizationId(Long organizationId);
}
