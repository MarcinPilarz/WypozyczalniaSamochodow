package pl.opole.uni.springWebApp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.opole.uni.springWebApp.models.Student;

@Service
public interface MainService <T>{

	 List<T> finAllStudent();
		void addStudent(T object);
		
		void editStudent(T object);
		
		void deleteStudent(T object);
}
// klasa generyczna i klasa ktora będzie dziedziczyć