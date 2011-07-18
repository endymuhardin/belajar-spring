package belajar.spring.aop;

public class TargetObject {
	public String halo(String nama){
		System.out.println("Menjalankan method halo");
		return "Halo "+nama;
	}
}
