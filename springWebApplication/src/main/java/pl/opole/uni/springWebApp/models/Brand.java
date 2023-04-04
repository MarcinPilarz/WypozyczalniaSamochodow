package pl.opole.uni.springWebApp.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.*;
@Entity
@Table(name="brand")
public class Brand {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long id;
private String symbol;

@Column(nullable=false)
private String name;

@OneToMany(mappedBy="id_brand")
private List<Model> modelList;

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
@Override
public int hashCode() {
	return Objects.hash(id);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Brand other = (Brand) obj;
	return id == other.id;
}



}
