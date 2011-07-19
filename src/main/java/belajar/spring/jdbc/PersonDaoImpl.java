package belajar.spring.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import belajar.spring.domain.Person;

@Repository("personDao")
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

	@Override
	public Person findPersonById(Integer id) {
		try {
			Connection conn = dataSource.getConnection();
			
			String sql = "select * from person where id = ?";
			PreparedStatement psFind = conn.prepareStatement(sql);
			psFind.setInt(1, id);
			
			ResultSet rs = psFind.executeQuery();
			if(!rs.next()) return null;
			
			Person p = new Person();
			p.setId(rs.getInt("id"));
			p.setNama(rs.getString("nama"));
			p.setTanggalLahir(new Date(rs.getDate("tanggal_lahir").getTime()));
			
			conn.close();
			return p;
		} catch (Exception err){
			err.printStackTrace();
			return null;
		}
	}
}
