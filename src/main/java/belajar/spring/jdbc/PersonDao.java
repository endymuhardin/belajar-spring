package belajar.spring.jdbc;

import java.util.List;

import belajar.spring.domain.Person;

public interface PersonDao {
	public void save(Person p);
	public void save(List<Person> personList);
	public Person findPersonById(Integer id);
	public List<Person> findPersonByNama(String nama);
}
