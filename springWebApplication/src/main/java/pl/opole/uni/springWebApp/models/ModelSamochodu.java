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
@Table(name = "model_samochodu")
public class ModelSamochodu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_model_samochodu")
    private Long id_model_samochodu;

    @Column(name = "nazwa_model_samochodu")
    private String nazwa_model_samochodu;

    @Column(name = "rok_produkcji")
    private Integer rokProdukcji;

//    @ManyToOne
//    @JoinColumn(name = "id_producenta")
//    private ProducentSamochodow producent;

	public Long getId() {
		return id_model_samochodu;
	}

	public void setId(Long id) {
		this.id_model_samochodu = id;
	}

	public String getNazwa() {
		return nazwa_model_samochodu;
	}

	public void setNazwa(String nazwa) {
		this.nazwa_model_samochodu = nazwa;
	}

	public Integer getRokProdukcji() {
		return rokProdukcji;
	}

	public void setRokProdukcji(Integer rokProdukcji) {
		this.rokProdukcji = rokProdukcji;
	}

//	public ProducentSamochodow getProducent() {
//		return producent;
//	}
//
//	public void setProducent(ProducentSamochodow producent) {
//		this.producent = producent;
//	}
//sdada
    
}
