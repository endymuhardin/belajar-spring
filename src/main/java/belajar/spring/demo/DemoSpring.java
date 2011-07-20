package belajar.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
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
		System.out.println("ID : "+p.getId());
		System.out.println("Nama : "+p.getNama());
		System.out.println("Tanggal Lahir : "+p.getTanggalLahir());
		System.out.println("Alamat : "+p.getAlamat().getJalan());
		
		MessageSource messageSource = (MessageSource) ctx.getBean("messageSource");
		System.out.println("Versi buildnumber : "+ messageSource.getMessage("app.version", null, "tidak terdefinisi", null));
		System.out.println("Versi gmaven : "+ messageSource.getMessage("scm.version", null, "tidak terdefinisi", null));
	}

}
