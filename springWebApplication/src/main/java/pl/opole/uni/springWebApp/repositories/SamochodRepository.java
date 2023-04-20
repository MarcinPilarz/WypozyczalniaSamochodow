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
    
    List<Samochod> findByModelAndRokProdukcjiGreaterThanEqual(String model, Integer rokProdukcji);
    
    @Query("SELECT s FROM Samochod s JOIN s.producent p WHERE p.nazwa = :nazwa")
    List<Samochod> znajdzPoNazwieProducenta(@Param("nazwa") String nazwa);
    
    @Query(value = "SELECT * FROM samochody s WHERE s.rok_produkcji >= :rok", nativeQuery = true)
    List<Samochod> znajdzStarszeNiz(@Param("rok") Integer rok);
}