package pl.opole.uni.springWebApp.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="rodzaj_znizki")
public class RodzajZnizki extends Znizka {

	
	private String indexZnizki;
	private String opisZnizki;
	public String getIndexZnizki() {
		return indexZnizki;
	}
	public void setIndexZnizki(String indexZnizki) {
		this.indexZnizki = indexZnizki;
	}
	public String getOpisZnizki() {
		return opisZnizki;
	}
	public void setOpisZnizki(String opisZnizki) {
		this.opisZnizki = opisZnizki;
	}
	
	
	
}
