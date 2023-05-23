package pl.opole.uni.springWebApp.models;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Entity
@Table(name = "klient")
public class Klient {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_klient")
    private Long idKlienta;

	@NotNull
    @Column(name = "imie_klient")
    private String imie_klient;

	@NotNull
    @Column(name = "nazwisko_klient")
    private String nazwisko_klient;

	@NotNull
    @Column(name = "email")
    private String email;
	
	@NotNull
    @Column(name = "nr_telefonu")
    private String nrTelefonu_klient;

    @ManyToMany
    @JoinTable(name = "wypozyczenia",
            joinColumns = @JoinColumn(name = "id_klient"),
            		 inverseJoinColumns = {
            		 @JoinColumn(name = "id_samochod"),
//            		 @JoinColumn(name = "id_okres_wypozyczenia")
             })
    private List<Samochod> samochody;

    
//    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

//    @ManyToOne
//    @JoinColumn(name = "id_okres_wypozyczenia")
//    private OkresWypozyczenia okres_wypozyczenia;
    
    @JsonIgnore
    //Properties(value={"klient", "samochod"})
    @OneToMany(fetch= FetchType.LAZY, mappedBy="klient")
    private List<OkresWypozyczenia> wypozyczenia;
    //sda


	public Long getIdKlienta() {
		return idKlienta;
	}


	public void setIdKlienta(Long idKlienta) {
		this.idKlienta = idKlienta;
	}


	public String getImie_klient() {
		return imie_klient;
	}


	public void setImie_klient(String imie_klient) {
		this.imie_klient = imie_klient;
	}


	public String getNazwisko_klient() {
		return nazwisko_klient;
	}


	public void setNazwisko_klient(String nazwisko_klient) {
		this.nazwisko_klient = nazwisko_klient;
	}


	public String getNrTelefonu_klient() {
		return nrTelefonu_klient;
	}


	public void setNrTelefonu_klient(String nrTelefonu_klient) {
		this.nrTelefonu_klient = nrTelefonu_klient;
	}


	public List<Samochod> getSamochody() {
		return samochody;
	}


	public void setSamochody(List<Samochod> samochody) {
		this.samochody = samochody;
	}


	public List<OkresWypozyczenia> getWypozyczenia() {
		return wypozyczenia;
	}


	public void setWypozyczenia(List<OkresWypozyczenia> wypozyczenia) {
		this.wypozyczenia = wypozyczenia;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	

	
	
    //ccccccccccccccccccccccccccccccccccccc
//	public Long getId_klient() {
//		return idKlienta;
//	}
//
//	public void setId_klient(Long id_klient) {
//		this.idKlienta = id_klient;
//	}
//
//	public String getImie_klient() {
//		return imie_klient;
//	}
//
//	public void setImie_klient(String imie_klient) {
//		this.imie_klient = imie_klient;
//	}
//
//	public String getNazwisko_klient() {
//		return nazwisko_klient;
//	}
//
//	public void setNazwisko_klient(String nazwisko_klient) {
//		this.nazwisko_klient = nazwisko_klient;
//	}
//
//	public String getNrTelefonu_klient() {
//		return nrTelefonu_klient;
//	}
//
//	public void setNrTelefonu_klient(String nrTelefonu_klient) {
//		this.nrTelefonu_klient = nrTelefonu_klient;
//	}
//
////	public OkresWypozyczenia getOkres_wypozyczenia() {
////		return okres_wypozyczenia;
////	}
////
////	public void setOkres_wypozyczenia(OkresWypozyczenia okres_wypozyczenia) {
////		this.okres_wypozyczenia = okres_wypozyczenia;
////	}
//
//	public Long getId() {
//		return idKlienta;
//	}
//
//	public void setId(Long id) {
//		this.id_klient= id;
//	}
//
//	public String getImie() {
//		return imie_klient;
//	}
//
//	public void setImie(String imie) {
//		this.imie_klient = imie;
//	}
//
//	public String getNazwisko() {
//		return nazwisko_klient;
//	}
//
//	public void setNazwisko(String nazwisko) {
//		this.nazwisko_klient = nazwisko;
//	}
//
//	public String getNrTelefonu() {
//		return nrTelefonu_klient;
//	}
//
//	public void setNrTelefonu(String nrTelefonu) {
//		this.nrTelefonu_klient = nrTelefonu;
//	}
//
//	public List<Samochod> getSamochody() {
//		return samochody;
//	}
//
//	public void setSamochody(List<Samochod> samochody) {
//		this.samochody = samochody;
//	}
//
//	public List<OkresWypozyczenia> getWypozyczenia() {
//		return wypozyczenia;
//	}
//
//	public void setWypozyczenia(List<OkresWypozyczenia> wypozyczenia) {
//		this.wypozyczenia = wypozyczenia;
//	}
	
}
