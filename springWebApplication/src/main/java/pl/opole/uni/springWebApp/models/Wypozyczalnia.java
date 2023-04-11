package pl.opole.uni.springWebApp.models;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "wypozyczalnie")
public class Wypozyczalnia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nazwa")
    private String nazwa;

    @Column(name = "adres")
    private String adres;

    @OneToMany(mappedBy = "wypozyczalnia")
    private List<Oddzial> oddzialy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public List<Oddzial> getOddzialy() {
		return oddzialy;
	}

	public void setOddzialy(List<Oddzial> oddzialy) {
		this.oddzialy = oddzialy;
	}

    
}

