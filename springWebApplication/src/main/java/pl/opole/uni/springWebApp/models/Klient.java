package pl.opole.uni.springWebApp.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "klienci")
public class Klient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "imie")
    private String imie;

    @Column(name = "nazwisko")
    private String nazwisko;

    @Column(name = "nr_telefonu")
    private String nrTelefonu;

    @ManyToMany
    @JoinTable(name = "wypozyczenia",
            joinColumns = @JoinColumn(name = "id_klienta"),
            inverseJoinColumns = @JoinColumn(name = "id_samochodu"))
    private List<Samochod> samochody;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getNrTelefonu() {
		return nrTelefonu;
	}

	public void setNrTelefonu(String nrTelefonu) {
		this.nrTelefonu = nrTelefonu;
	}

	public List<Samochod> getSamochody() {
		return samochody;
	}

	public void setSamochody(List<Samochod> samochody) {
		this.samochody = samochody;
	}

    
}
