package pl.opole.uni.springWebApp.models;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "okres_wypozyczenia")
public class OkresWypozyczenia {

	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "id_okres_wypozyczenia")
	  private Long id_okres_wypozyczenia;
	  
	  //tworzenie transakcji
	  @ManyToOne
	  private Klient klient;
	  
	  
	  @ManyToOne
	  private Samochod samochod;
	  
	  //
	  
	  @Column(name="termin_wypozyczenia")
	  private LocalDate terminWypozyczenia;
	  
	  @Column(name="termin_oddania")
	  private LocalDate terminOddania;
	  
	 // @Column(name="jest_wypozyczony")
	//  private Boolean jestWypozyczony;
	  
	 // @OneToMany(mappedBy = "okres_wypozyczenia")
//	  @JoinColumn(name = "id_oddzialu")
	//  private Wypo;
	  
	  
	  
	public Long getId_okres_wypozyczenia() {
		return id_okres_wypozyczenia;
	}

	public void setId_okres_wypozyczenia(Long id_okres_wypozyczenia) {
		this.id_okres_wypozyczenia = id_okres_wypozyczenia;
	}

	public LocalDate getTerminWypozyczenia() {
		return terminWypozyczenia;
	}

	public void setTerminWypozyczenia(LocalDate terminWypozyczenia) {
		this.terminWypozyczenia = terminWypozyczenia;
	}

	public LocalDate getTerminOddania() {
		return terminOddania;
	}

	public void setTerminOddania(LocalDate terminOddania) {
		this.terminOddania = terminOddania;
	}

//	public Boolean getJestWypozyczony() {
//		return jestWypozyczony;
//	}
//
//	public void setJestWypozyczony(Boolean jestWypozyczony) {
//		this.jestWypozyczony = jestWypozyczony;
//	}
	
	//potrzebne do transakcji

	public Klient getKlient() {
		return klient;
	}

	public void setKlient(Klient klient) {
		this.klient = klient;
	}

	public Samochod getSamochod() {
		return samochod;
	}

	public void setSamochod(Samochod samochod) {
		this.samochod = samochod;
	}
	  
	  
	  
}
