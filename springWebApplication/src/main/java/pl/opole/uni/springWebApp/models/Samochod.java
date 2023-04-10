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

    @Column(name = "marka")
    private String marka;

    @Column(name = "model")
    private String model;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
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

    
}