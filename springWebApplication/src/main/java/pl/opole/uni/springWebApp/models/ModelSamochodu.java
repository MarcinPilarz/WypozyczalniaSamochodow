package pl.opole.uni.springWebApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "modele_samochodow")
public class ModelSamochodu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nazwa")
    private String nazwa;

    @Column(name = "rok_produkcji")
    private Integer rokProdukcji;

    @ManyToOne
    @JoinColumn(name = "id_producenta")
    private ProducentSamochodow producent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Integer getRokProdukcji() {
		return rokProdukcji;
	}

	public void setRokProdukcji(Integer rokProdukcji) {
		this.rokProdukcji = rokProdukcji;
	}

	public ProducentSamochodow getProducent() {
		return producent;
	}

	public void setProducent(ProducentSamochodow producent) {
		this.producent = producent;
	}

    
}
