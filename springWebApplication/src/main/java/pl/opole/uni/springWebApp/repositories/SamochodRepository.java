
package pl.opole.uni.springWebApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.opole.uni.springWebApp.models.Samochod;

@Repository
public interface SamochodRepository extends JpaRepository<Samochod, Long> {

	List<Samochod> findByMarka(String marka);
	
	List<Samochod> findByModel(String model);
	
	@Query("SELECT Samochod FROM Samochod Samochod WHERE Samochod.rokProdukcji > :rok_produkcji")
	List<Samochod> findByRokProdukcjiGreaterThan(@Param("rok_produkcji") int rok_produkcji);
	
	@Query(value = "SELECT * FROM samochody WHERE marka = :marka", nativeQuery = true)
    List<Samochod> findByMarkaNative(@Param("marka") String marka);
}

