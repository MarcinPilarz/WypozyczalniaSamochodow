package pl.opole.uni.springWebApp.models;
import javax.persistence.*;


@Entity
@Table(name = "pracownik")
public class Pracownik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pracownik")
    private Long id_pracownik;

    @Column(name = "imie_pracownik")
    private String imie_pracownik;

    @Column(name = "nazwisko_pracownik")
    private String nazwisko_pracownik;

	public Long getId() {
		return id_pracownik;
	}

	public void setId(Long id) {
		this.id_pracownik = id;
	}

	public String getImie() {
		return imie_pracownik;
	}

	public void setImie(String imie) {
		this.imie_pracownik = imie;
	}

	public String getNazwisko() {
		return nazwisko_pracownik;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko_pracownik = nazwisko;
	}

    
}
