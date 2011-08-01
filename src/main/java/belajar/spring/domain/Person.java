package belajar.spring.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;

public class Person {
	private Integer id;
	private String nama;
	private Date tanggalLahir;
	private Address alamat;
	private List<String> daftarEmail = new ArrayList<String>();
	
	public void setDaftarEmailString(String emails){
		setDaftarEmail(Arrays.asList(StringUtils.commaDelimitedListToStringArray(emails)));
	}
	
	public List<String> getDaftarEmail() {
		return daftarEmail;
	}
	public void setDaftarEmail(List<String> daftarEmail) {
		this.daftarEmail = daftarEmail;
	}
	public Address getAlamat() {
		return alamat;
	}
	public void setAlamat(Address alamat) {
		this.alamat = alamat;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public Date getTanggalLahir() {
		return tanggalLahir;
	}
	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}
	
	
}
