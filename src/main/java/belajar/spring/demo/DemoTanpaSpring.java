package belajar.spring.demo;

import java.util.Date;

import belajar.spring.domain.Address;
import belajar.spring.domain.Person;

public class DemoTanpaSpring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person endy = new Person();
		endy.setNama("Endy Muhardin");
		endy.setTanggalLahir(new Date());
		
		Address kantor = new Address();
		kantor.setJalan("Jl. Pangkalan Jati");
		kantor.setKota("Jakarta");
		kantor.setKodepos("13600");
		
		endy.setAlamat(kantor);
		
		// tampilkan
		System.out.println("Nama : "+endy.getNama());
		System.out.println("Alamat : "+endy.getAlamat().getJalan());
	}

}
