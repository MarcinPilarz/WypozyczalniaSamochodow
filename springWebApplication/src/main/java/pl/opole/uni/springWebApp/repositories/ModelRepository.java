package pl.opole.uni.springWebApp.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.opole.uni.springWebApp.models.ModelSamochodu;

@Repository
public interface ModelRepository extends  JpaRepository<ModelSamochodu,Long>{

	//List<ModelSamochodu> findByNazwaModelu(String nazwaModelu);
	
	@Query("SELECT nazwaModelu FROM ModelSamochodu nazwaModelu WHERE nazwaModelu.nazwaModelu= :nazwaModelu")
	List<ModelSamochodu> findByNazwaModelu(@Param("nazwaModelu") String nazwaModelu);
}
