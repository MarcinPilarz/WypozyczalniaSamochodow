package pl.opole.uni.springWebApp.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "samochody")
public class Samochod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "rok_produkcji")
    private Integer rokProdukcji;

    @ManyToMany(mappedBy = "samochody")
    private List<Klient> klienci;
    
    @ManyToOne
    @JoinColumn(name = "id_oddzialu")
    private Oddzial oddzial;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "samochody_ubezpieczenia", joinColumns = @JoinColumn(name = "id_samochodu"), inverseJoinColumns = @JoinColumn(name = "id_ubezpieczenia"))
    private List<Ubezpieczenie> ubezpieczenia;
    
    @ManyToOne
    @JoinColumn(name = "id_producenta")
    private ProducentSamochodow producent;
    
    @ManyToOne
    @JoinColumn(name = "id_modelu")
    private ModelSamochodu modelSamochodu;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRokProdukcji() {
		return rokProdukcji;
	}

	public void setRokProdukcji(Integer rokProdukcji) {
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

	public void setUbezpieczenia(List<Ubezpieczenie> ubezpieczenia) {
		this.ubezpieczenia = ubezpieczenia;
	}

	public ProducentSamochodow getProducent() {
		return producent;
	}

	public void setProducent(ProducentSamochodow producent) {
		this.producent = producent;
	}

	public ModelSamochodu getModelSamochodu() {
		return modelSamochodu;
	}

	public void setModelSamochodu(ModelSamochodu modelSamochodu) {
		this.modelSamochodu = modelSamochodu;
	}

    
    
    
    
}