package belajar.spring.demo;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import belajar.spring.domain.Person;
import belajar.spring.jdbc.PersonDao;

public class SpringJdbcDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("classpath:jdbc.xml");
		
		
		PersonDao personDao = (PersonDao) ctx.getBean("personDaoSpring");
		
		Person p = new Person();
		p.setNama("Endy Muhardin");
		p.setTanggalLahir(new Date());
		
		personDao.save(p);
		System.out.println("Id : "+p.getId());
	}

}
