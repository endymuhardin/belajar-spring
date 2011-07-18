package belajar.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import belajar.spring.aop.TargetObject;

public class TanpaAopDemo {
	public static void main(String[] args) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("classpath:aop.xml");
		
		TargetObject to = (TargetObject) ctx.getBean("objectAsli");
		String hasil = to.halo("Endy");
		System.out.println(hasil);
	}
}
