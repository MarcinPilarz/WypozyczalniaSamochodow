package pl.opole.uni.springWebApp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//@Entity
public class Teacher  extends Person{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
   private long id;
	private String name;
	private String surname;
	private String pesel;
	private String title;
	
	
	
	//@ManyToOne
	//@JoinColumn(name="id_type")
	//private Student type;

	public String getSurname() {
		return surname;
	}

	//public Student getType() {
	//	return type;
//	}

	//public void setType(Student type) {
	//	this.type = type;
//	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	

  

public long getId() {
	   return id;
   }
   
   public void setId(long id) {
	   this.id=id;
   }
   
   public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

 

public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

public String getPesel() {
	return pesel;
}

public void setPesel(String pesel) {
	this.pesel = pesel;
}

}
