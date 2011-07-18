package belajar.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import belajar.spring.domain.Person;

public class DemoSpring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("classpath:ioc.xml");
		
		Person p = (Person) ctx.getBean("endy");
		
		// tampilkan
		System.out.println("Nama : "+p.getNama());
		System.out.println("Alamat : "+p.getAlamat().getJalan());
	}

}
