package belajar.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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

	@Override
	public Person findPersonById(Integer id) {
		String sql = "select * from person where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{id}, 
				new PersonRowMapper());
	}
	
	private class PersonRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet rs, int arg1) throws SQLException {
			Person p = new Person();
			p.setId(rs.getInt("id"));
			p.setNama(rs.getString("nama"));
			p.setTanggalLahir(new Date(rs.getDate("tanggal_lahir").getTime()));
			return p;
		}
		
	}

	@Override
	public List<Person> findPersonByNama(String nama) {
		String sql = "select * from person where nama like ?";
		return jdbcTemplate
				.query(sql, new Object[]{"%"+nama+"%"}, new PersonRowMapper());
	}

	@Override
	public void save(List<Person> personList) {
		for (Person person : personList) {
			save(person);
		}
	}
	
}
