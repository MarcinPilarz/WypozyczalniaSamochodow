package pl.opole.uni.springWebApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.opole.uni.springWebApp.models.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
	
	
	
}
