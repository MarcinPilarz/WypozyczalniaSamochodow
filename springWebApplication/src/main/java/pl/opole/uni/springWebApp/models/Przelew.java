package pl.opole.uni.springWebApp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Przelew {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 
 @ManyToOne
 @JoinColumn(name="id_kontoZ")
 private Konto kontoZ;
 
 @ManyToOne
 @JoinColumn(name="id_kontoDo")
 private Konto kontoDo;
 
 private Double kwota;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Konto getKontoZ() {
	return kontoZ;
}

public void setKontoZ(Konto kontoZ) {
	this.kontoZ = kontoZ;
}

public Konto getKontoDo() {
	return kontoDo;
}

public void setKontoDo(Konto kontoDo) {
	this.kontoDo = kontoDo;
}

public Double getKwota() {
	return kwota;
}

public void setKwota(Double kwota) {
	this.kwota = kwota;
}

//public Integer getKonto() {
//	// TODO Auto-generated method stub
//	return null;
//}
 
 
 
 
}
