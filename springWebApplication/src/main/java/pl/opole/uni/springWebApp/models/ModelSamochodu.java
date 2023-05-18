package pl.opole.uni.springWebApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "model_samochodu")
public class ModelSamochodu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_model_samochodu")
    private Long id;

    @NotNull
    @Column(name = "nazwa_model_samochodu")
    private String nazwaModelu;

    @NotNull
    @Column(name = "rok_produkcji")
    private Integer rokProdukcji;

//    @ManyToOne
//    @JoinColumn(name = "id_producenta")
//    private ProducentSamochodow producent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id= id;
	}

	public String getNazwa() {
		return nazwaModelu;
	}

	public void setNazwa(String nazwa) {
		this.nazwaModelu = nazwa;
	}

	public Integer getRokProdukcji() {
		return rokProdukcji;
	}

	public void setRokProdukcji(Integer rokProdukcji) {
		this.rokProdukcji = rokProdukcji;
	}

	public String getNazwaModelu() {
		return nazwaModelu;
	}

	public void setNazwaModelu(String nazwaModelu) {
		this.nazwaModelu = nazwaModelu;
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
