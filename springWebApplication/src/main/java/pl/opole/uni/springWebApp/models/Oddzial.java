package pl.opole.uni.springWebApp.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "oddzial")
public  class Oddzial {
	//abstract
//	protected String nazwa_oddzialu;
//	protected String adres;
//	protected String numer_telefonu;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oddzial")
    private Long idOddzial;

    @Column(name = "nazwa_oddzial")
    private String nazwaOddzial;

    @Column(name = "adres")
    private String adresOddzial;
//
//    @ManyToOne
//    @JoinColumn(name = "id_wypozyczalni")
//    private Wypozyczalnia wypozyczalnia;

	public Long getIdOddzial() {
		return idOddzial;
	}

	public void setIdOddzial(Long idOddzial) {
		this.idOddzial = idOddzial;
	}

	public String getNazwaOddzial() {
		return nazwaOddzial;
	}

	public void setNazwaOddzial(String nazwaOddzial) {
		this.nazwaOddzial = nazwaOddzial;
	}

	public String getAdresOddzial() {
		return adresOddzial;
	}

	public void setAdresOddzial(String adresOddzial) {
		this.adresOddzial = adresOddzial;
	}

   
//    @OneToMany(mappedBy = "oddzial")
//    private List<Samochod> samochody;



//	public Wypozyczalnia getWypozyczalnia() {
//		return wypozyczalnia;
//	}
//
//	public void setWypozyczalnia(Wypozyczalnia wypozyczalnia) {
//		this.wypozyczalnia = wypozyczalnia;
//	}

//	public List<Samochod> getSamochody() {
//		return samochody;
//	}
//
//	public void setSamochody(List<Samochod> samochody) {
//		this.samochody = samochody;
//	}

    
}
