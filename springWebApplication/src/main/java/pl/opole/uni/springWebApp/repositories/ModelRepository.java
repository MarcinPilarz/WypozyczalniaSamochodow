package pl.opole.uni.springWebApp.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.opole.uni.springWebApp.models.ModelSamochodu;

@Repository
public interface ModelRepository extends  JpaRepository<ModelSamochodu,Long>{

	//List<ModelSamochodu> 
}
