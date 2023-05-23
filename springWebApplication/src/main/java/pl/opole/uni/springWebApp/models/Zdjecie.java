package pl.opole.uni.springWebApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="zdjecie")
public class Zdjecie {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
	 @Lob
	    @Column(name="zdjecie")
	    private byte[] zdjecie;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getZdjecie() {
		return zdjecie;
	}

	public void setZdjecie(byte[] zdjecie) {
		this.zdjecie = zdjecie;
	}
	 
	 
}
