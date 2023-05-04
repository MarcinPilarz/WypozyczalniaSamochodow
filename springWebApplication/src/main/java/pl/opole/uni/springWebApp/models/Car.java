package pl.opole.uni.springWebApp.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cars")
public class Car {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String year;
	private String weight; 
	
	//@JsonIgonreProperties(value= {"pracownikList"})
	@ManyToOne
	@JoinColumn(name="id_model")
	private Model id_model;

//	@ManyToMany
//	@JoinTable(name="car_part", joinColumns = {@JoinColumn(name="id_car")},
//	inverseJoinColumns = {@JoinColumn(name="id_part")})
//	private List<Part> partList;
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}


	public Model getId_model() {
		return id_model;
	}


	public void setId_model(Model id_model) {
		this.id_model = id_model;
	}


//	public List<Part> getPartList() {
//		return partList;
//	}
//
//
//	public void setPartList(List<Part> partList) {
//		this.partList = partList;
//	}


	
	
	
}
