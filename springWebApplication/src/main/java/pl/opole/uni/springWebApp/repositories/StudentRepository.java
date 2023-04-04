package pl.opole.uni.springWebApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.opole.uni.springWebApp.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
   
}
