package pl.opole.uni.springWebApp.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "okres_wypozyczenia")
public class OkresWypozyczenia {

	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_okres_wypozyczenia")
	    private Long id_okres_wypozyczenia;
	  
	  @Column(name="termin_wypozyczenia")
	  private Date terminWypozyczenia;
	  
	  @Column(name="termin_oddania")
	  private Date terminOddania;
	  
	  @Column(name="jest_wypozyczony")
	  private Boolean jestWypozyczony;

	public Long getId_okres_wypozyczenia() {
		return id_okres_wypozyczenia;
	}

	public void setId_okres_wypozyczenia(Long id_okres_wypozyczenia) {
		this.id_okres_wypozyczenia = id_okres_wypozyczenia;
	}

	public Date getTerminWypozyczenia() {
		return terminWypozyczenia;
	}

	public void setTerminWypozyczenia(Date terminWypozyczenia) {
		this.terminWypozyczenia = terminWypozyczenia;
	}

	public Date getTerminOddania() {
		return terminOddania;
	}

	public void setTerminOddania(Date terminOddania) {
		this.terminOddania = terminOddania;
	}

	public Boolean getJestWypozyczony() {
		return jestWypozyczony;
	}

	public void setJestWypozyczony(Boolean jestWypozyczony) {
		this.jestWypozyczony = jestWypozyczony;
	}
	  
	  
	  
}
