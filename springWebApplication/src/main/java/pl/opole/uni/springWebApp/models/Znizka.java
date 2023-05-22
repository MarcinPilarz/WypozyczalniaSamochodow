package pl.opole.uni.springWebApp.models;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Znizka {

	
	@Id
	private Long id;
	
	private String nazwaZnizki;
	
	private double znizka;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazwaZnizki() {
		return nazwaZnizki;
	}

	public void setNazwaZnizki(String nazwaZnizki) {
		this.nazwaZnizki = nazwaZnizki;
	}

	public double getZnizka() {
		return znizka;
	}

	public void setZnizka(double znizka) {
		this.znizka = znizka;
	}
	
	
	
	
	
	
	
}
