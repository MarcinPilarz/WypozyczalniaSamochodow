package pl.opole.uni.springWebApp.models;
import javax.persistence.*;

@Entity
public class StudentType {

	@Id

	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private String svmbol;
	
	@ManyToOne
	@JoinColumn(name="idtype")
	private StudentType type;
}
