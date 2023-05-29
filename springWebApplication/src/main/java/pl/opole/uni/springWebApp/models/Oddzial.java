package pl.opole.uni.springWebApp.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "oddzial")
public class Oddzial {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_oddzial")
	private Long idOddzial;

	@NotNull
	@Column(name = "nazwa_oddzial")
	private String nazwaOddzial;

	@NotNull
	@Column(name = "adres")
	private String adresOddzial;

	public Long getIdOddzial() {
		return idOddzial;
	}

	public void setIdOddzial(Long idOddzial) {
		this.idOddzial = idOddzial;
	}

	public String getNazwaOddzial() {
		return nazwaOddzial;
	}

	public void setNazwaOddzial(String nazwaOddzial) {
		this.nazwaOddzial = nazwaOddzial;
	}

	public String getAdresOddzial() {
		return adresOddzial;
	}

	public void setAdresOddzial(String adresOddzial) {
		this.adresOddzial = adresOddzial;
	}

}
