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

    
    
   @ManyToOne
   @JoinColumn(name="id_klient")
   private Klient klient;
    
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

	public Long getId_pracownik() {
		return id_pracownik;
	}

	public void setId_pracownik(Long id_pracownik) {
		this.id_pracownik = id_pracownik;
	}

	public String getImie_pracownik() {
		return imie_pracownik;
	}

	public void setImie_pracownik(String imie_pracownik) {
		this.imie_pracownik = imie_pracownik;
	}

	public String getNazwisko_pracownik() {
		return nazwisko_pracownik;
	}

	public void setNazwisko_pracownik(String nazwisko_pracownik) {
		this.nazwisko_pracownik = nazwisko_pracownik;
	}

	public Klient getKlient() {
		return klient;
	}

	public void setKlient(Klient klient) {
		this.klient = klient;
	}

    
}
