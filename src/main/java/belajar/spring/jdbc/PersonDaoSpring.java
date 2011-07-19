package belajar.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import belajar.spring.domain.Person;

@Repository("personDaoSpring")
public class PersonDaoSpring implements PersonDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void save(Person p) {
		String sql = "INSERT INTO person (nama, tanggal_lahir) VALUES (?,?)";
		jdbcTemplate.update(sql, 
				new Object[]{
				p.getNama(), p.getTanggalLahir()
		});
	}
	
}
