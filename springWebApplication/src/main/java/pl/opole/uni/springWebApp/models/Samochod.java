package pl.opole.uni.springWebApp.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "samochod")
public class Samochod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name="marka")
    private String marka;
    
    @Column(name="pojemnosc_baterii")
    private int pojemnosc_baterii;
    
    @Column(name="iloscDrzwi")
    private String ilosc_drzwi;
    
    @Column(name="kolor_samochodu")
    private String kolor_samochodu;
    
    @Column(name="moc_silnika")
    private int moc_silnika;
    

    @Column(name = "rok_produkcji")
    private int rokProdukcji;
    
    @Column(name="cena_samochodu")
    private double cenaSamochodu;

//    @Column(name="model")
//    private String model;
//    @Column(name="marka")
//    private String marka;
    @ManyToMany(mappedBy = "samochody")
    private List<Klient> klienci;
    
    @ManyToOne
    @JoinColumn(name = "id_oddzialu")
    private Oddzial oddzial;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "samochody_ubezpieczenia", joinColumns = @JoinColumn(name = "id_samochodu"), inverseJoinColumns = @JoinColumn(name = "id_ubezpieczenia"))
    private List<Ubezpieczenie> ubezpieczenia;
    
//    @ManyToOne
//    @JoinColumn(name = "id_producenta")
//    private ProducentSamochodow producent;
    
    @ManyToOne
    @JoinColumn(name = "id_modelu")
    private ModelSamochodu modelSamochodu;
    
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRokProdukcji() {
		return rokProdukcji;
	}

	public void setRokProdukcji(int rokProdukcji) {
		this.rokProdukcji = rokProdukcji;
	}

	public List<Klient> getKlienci() {
		return klienci;
	}

	public void setKlienci(List<Klient> klienci) {
		this.klienci = klienci;
	}

	public Oddzial getOddzial() {
		return oddzial;
	}

	public void setOddzial(Oddzial oddzial) {
		this.oddzial = oddzial;
	}

	public List<Ubezpieczenie> getUbezpieczenia() {
		return ubezpieczenia;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public void setUbezpieczenia(List<Ubezpieczenie> ubezpieczenia) {
		this.ubezpieczenia = ubezpieczenia;
	}

//	public ProducentSamochodow getProducent() {
//		return producent;
//	}
//
//	public void setProducent(ProducentSamochodow producent) {
//		this.producent = producent;
//	}

	public ModelSamochodu getModelSamochodu() {
		return modelSamochodu;
	}

	public void setModelSamochodu(ModelSamochodu modelSamochodu) {
		this.modelSamochodu = modelSamochodu;
	}

	public int getPojemnosc_baterii() {
		return pojemnosc_baterii;
	}

	public void setPojemnosc_baterii(int pojemnosc_baterii) {
		this.pojemnosc_baterii = pojemnosc_baterii;
	}

	public String getIlosc_drzwi() {
		return ilosc_drzwi;
	}

	public void setIlosc_drzwi(String ilosc_drzwi) {
		this.ilosc_drzwi = ilosc_drzwi;
	}

	public String getKolor_samochodu() {
		return kolor_samochodu;
	}

	public void setKolor_samochodu(String kolor_samochodu) {
		this.kolor_samochodu = kolor_samochodu;
	}

	public int getMoc_silnika() {
		return moc_silnika;
	}

	public void setMoc_silnika(int moc_silnika) {
		this.moc_silnika = moc_silnika;
	}

	public double getCenaSamochodu() {
		return cenaSamochodu;
	}

	public void setCenaSamochodu(double cenaSamochodu) {
		this.cenaSamochodu = cenaSamochodu;
	}

	
//	public String getModel() {
//		return model;
//	}
//
//	public void setModel(String model) {
//		this.model = model;
//	}
//
//	public String getMarka() {
//		return marka;
//	}
//
//	public void setMarka(String marka) {
//		this.marka = marka;
//	}

    
    
    
    
}