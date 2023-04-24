package pl.opole.uni.springWebApp.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="model")
public class Model {

	



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String symbol;
	private String name;

	@ManyToOne
	@JoinColumn(name="id_brand")
	private Brand id_brand;

	@OneToMany(mappedBy="id_model")
	private List<Car> carList;



	public long getId() {
	return id;
	}


	public void setId(long id) {
	this.id = id;
	}


	public String getSymbol() {
	return symbol;
	}


	public void setSymbol(String symbol) {
	this.symbol = symbol;
	}


	public String getName() {
	return name;
	}


	public void setName(String name) {
	this.name = name;
	}	


	public Brand getId_brand() {
	return id_brand;
	}


	public void setId_brand(Brand id_brand) {
	this.id_brand = id_brand;
	}


}
