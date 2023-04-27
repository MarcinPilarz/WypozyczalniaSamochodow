package pl.opole.uni.springWebApp.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "klient")
public class Klient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_klient")
    private Long id_klient;

    @Column(name = "imie_klient")
    private String imie_klient;

    @Column(name = "nazwisko_klient")
    private String nazwisko_klient;

    @Column(name = "nr_telefonu")
    private String nrTelefonu_klient;

    @ManyToMany
    @JoinTable(name = "wypozyczenia",
            joinColumns = @JoinColumn(name = "id_klient"),
            inverseJoinColumns = @JoinColumn(name = "id_samochod"))
    private List<Samochod> samochody;

	public Long getId() {
		return id_klient;
	}

	public void setId(Long id) {
		this.id_klient= id;
	}

	public String getImie() {
		return imie_klient;
	}

	public void setImie(String imie) {
		this.imie_klient = imie;
	}

	public String getNazwisko() {
		return nazwisko_klient;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko_klient = nazwisko;
	}

	public String getNrTelefonu() {
		return nrTelefonu_klient;
	}

	public void setNrTelefonu(String nrTelefonu) {
		this.nrTelefonu_klient = nrTelefonu;
	}

	public List<Samochod> getSamochody() {
		return samochody;
	}

	public void setSamochody(List<Samochod> samochody) {
		this.samochody = samochody;
	}

    
}
