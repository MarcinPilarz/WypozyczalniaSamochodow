package pl.opole.uni.springWebApp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Konto {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	
	private String Konto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKonto() {
		return Konto;
	}

	public void setKonto(String konto) {
		Konto = konto;
	}
	
	
	
	
	
}
