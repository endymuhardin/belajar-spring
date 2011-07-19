package belajar.spring.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import belajar.spring.domain.Person;

public class TransactionTest {
	private static PersonDao personDao;
	private static DataSource dataSource;
	
	@BeforeClass
	public static void init() throws Exception {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("classpath:jdbc.xml");
		personDao = (PersonDao) ctx.getBean("personDao");
		dataSource = (DataSource) ctx.getBean("dataSource");
		
		resetDatabase();
	}
	
	public static void resetDatabase() throws Exception {
		Connection conn = dataSource.getConnection();
		conn.createStatement().executeUpdate("truncate person");
		conn.close();
	}
	
	@Test
	public void testNoTransaction() throws Exception {
		personDao.save(sampleDataNormal());
		checkIsiTabel(3);
		personDao.save(sampleDataAbnormal());
		checkIsiTabel(5); // kalau terjadi rollback, harusnya tetap 3
	}
	
	private void checkIsiTabel(int numRows) throws Exception {
		Connection conn = dataSource.getConnection();
		ResultSet rs = conn.createStatement()
				.executeQuery("select count(*) from person");
		assertTrue(rs.next());
		assertEquals(numRows, rs.getInt(1));
	}

	private List<Person> sampleDataNormal(){
		List<Person> hasil = new ArrayList<Person>();
		
		Person p = new Person();
		p.setNama("Endy Muhardin");
		p.setTanggalLahir(new Date());
		hasil.add(p);
		
		Person p1 = new Person();
		p1.setNama("Martinus Ady");
		p1.setTanggalLahir(new Date());
		hasil.add(p1);
		
		Person p2 = new Person();
		p2.setNama("Jimmy Rengga");
		p2.setTanggalLahir(new Date());
		hasil.add(p2);
		
		return hasil;
	}
	
	private List<Person> sampleDataAbnormal(){
		List<Person> hasil = new ArrayList<Person>();
		
		Person p = new Person();
		p.setNama("Adi Sulistiono");
		p.setTanggalLahir(new Date());
		hasil.add(p);

		// p2 tidak ada namanya, akan error saat diinsert
		Person p1 = new Person();
		p1.setTanggalLahir(new Date());
		hasil.add(p1);
		
		Person p2 = new Person();
		p2.setNama("Feldy Yusuf");
		p2.setTanggalLahir(new Date());
		hasil.add(p2);
		
		return hasil;
	}
}
