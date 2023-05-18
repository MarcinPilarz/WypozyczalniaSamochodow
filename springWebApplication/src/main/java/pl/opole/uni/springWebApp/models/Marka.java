package pl.opole.uni.springWebApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="marka_samochodu")
public class Marka {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marka_samochodu")
    private Long idMarka;

	@NotNull
    @Column(name = "nazwa_marki_samochodu")
    private String nazwaMarka;

	public Long getIdMarka() {
		return idMarka;
	}

	public void setIdMarka(Long idMarka) {
		this.idMarka = idMarka;
	}

	public String getNazwaMarka() {
		return nazwaMarka;
	}

	public void setNazwaMarka(String nazwaMarka) {
		this.nazwaMarka = nazwaMarka;
	}

    
    
    
}
