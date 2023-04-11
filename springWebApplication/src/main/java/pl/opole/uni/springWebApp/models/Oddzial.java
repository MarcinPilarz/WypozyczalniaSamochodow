package pl.opole.uni.springWebApp.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "oddzialy")
public class Oddzial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nazwa")
    private String nazwa;

    @Column(name = "adres")
    private String adres;

    @ManyToOne
    @JoinColumn(name = "id_wypozyczalni")
    private Wypozyczalnia wypozyczalnia;

    @OneToMany(mappedBy = "oddzial")
    private List<Samochod> samochody;

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

	public Wypozyczalnia getWypozyczalnia() {
		return wypozyczalnia;
	}

	public void setWypozyczalnia(Wypozyczalnia wypozyczalnia) {
		this.wypozyczalnia = wypozyczalnia;
	}

	public List<Samochod> getSamochody() {
		return samochody;
	}

	public void setSamochody(List<Samochod> samochody) {
		this.samochody = samochody;
	}

    
}
