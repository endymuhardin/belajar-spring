package belajar.spring.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import belajar.spring.domain.Person;

public class PersonDaoImpl implements PersonDao {
	@Autowired private DataSource dataSource;
	
	@Override 
	public void save(Person p){
		try {
			Connection conn = dataSource.getConnection();
			String sql = "INSERT INTO person (nama, tanggal_lahir) VALUES (?,?)";
			PreparedStatement psInsert = conn.prepareStatement(sql);
			psInsert.setString(1, p.getNama());
			psInsert.setDate(2, new java.sql.Date(p.getTanggalLahir().getTime()));
			psInsert.executeUpdate();
			conn.close();
		} catch (Exception err){
			err.printStackTrace();
		}
	}
}