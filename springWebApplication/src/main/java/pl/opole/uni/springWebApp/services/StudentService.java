package pl.opole.uni.springWebApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.opole.uni.springWebApp.models.Student;
import pl.opole.uni.springWebApp.repositories.StudentRepository;

@Service
public class StudentService implements MainService<Student>{

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public List<Student> finAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		 studentRepository.save(student);
	}

	@Override
	public void editStudent(Student student) {
		// TODO Auto-generated method stub
		//studentRepository.()
	}

	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub
		studentRepository.delete(student);
	}

	
	
}
