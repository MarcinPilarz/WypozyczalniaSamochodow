package pl.opole.uni.springWebApp.models;
import java.util.Objects;
import javax.persistence.*;


@Entity
@Table(name="studenci")
public class Student extends Person {
    
	//Zawsze musi byc pusty konstruktor 
	public Student() {
		
	}
	
	public Student(String name) {
		this.name=name;
	}
	@Id
	
	@GeneratedValue(strategy=GenerationType.AUTO)
   private long id;
	private String name;
	private String surname;
	private String pesel;
	private String indexNumber;
	
	
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

	public String getIndexNumber() {
		return indexNumber;
	}

	public void setIndexNumber(String indexNumber) {
		this.indexNumber = indexNumber;
	}
@Transient
		private String test;
  

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
	

    public String getTest() {
	return test;
}

public void setTest(String test) {
	this.test = test;
}

public String getPesel() {
	return pesel;
}

public void setPesel(String pesel) {
	this.pesel = pesel;
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
	Student other = (Student) obj;
	return id == other.id;
}

@Override
public String toString() {
	return surname+ " " + name;
}
}
