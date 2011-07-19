package belajar.spring.jdbc;

import belajar.spring.domain.Person;

public interface PersonDao {
	public void save(Person p);
	public Person findPersonById(Integer id);
}
