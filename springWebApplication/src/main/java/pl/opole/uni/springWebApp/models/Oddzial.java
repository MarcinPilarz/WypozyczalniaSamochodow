package pl.opole.uni.springWebApp.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "oddzial")
public class Oddzial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oddzial")
    private Long id_oddzial;

    @Column(name = "nazwa_oddzial")
    private String nazwa_oddzial;

    @Column(name = "adres")
    private String adres_oddzial;

//    @ManyToOne
//    @JoinColumn(name = "id_wypozyczalni")
//    private Wypozyczalnia wypozyczalnia;

    @OneToMany(mappedBy = "oddzial")
    private List<Samochod> samochody;

	public Long getId() {
		return id_oddzial;
	}

	public void setId(Long id) {
		this.id_oddzial = id;
	}

	public String getNazwa() {
		return nazwa_oddzial;
	}

	public void setNazwa(String nazwa) {
		this.nazwa_oddzial = nazwa;
	}

	public String getAdres() {
		return adres_oddzial;
	}

	public void setAdres(String adres) {
		this.adres_oddzial = adres;
	}

//	public Wypozyczalnia getWypozyczalnia() {
//		return wypozyczalnia;
//	}
//
//	public void setWypozyczalnia(Wypozyczalnia wypozyczalnia) {
//		this.wypozyczalnia = wypozyczalnia;
//	}

	public List<Samochod> getSamochody() {
		return samochody;
	}

	public void setSamochody(List<Samochod> samochody) {
		this.samochody = samochody;
	}

    
}
