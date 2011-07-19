package belajar.spring.jdbc;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import belajar.spring.domain.Person;

@Repository("personDaoSpring")
public class PersonDaoSpring implements PersonDao {

	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert insertPerson;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
		insertPerson = new SimpleJdbcInsert(dataSource)
		.withTableName("person")
		.usingColumns("nama", "tanggal_lahir")
		.usingGeneratedKeyColumns("id");
	}
	
	@Override
	public void save(Person p) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("nama", p.getNama());
		parameters.put("tanggal_lahir", p.getTanggalLahir());
		Number id = insertPerson.executeAndReturnKey(parameters);
		p.setId(id.intValue());
	}
	
}
