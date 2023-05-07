package pl.opole.uni.springWebApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.opole.uni.springWebApp.models.Konto;
import pl.opole.uni.springWebApp.models.Samochod;

@Repository
public interface KontoRepository extends JpaRepository<Konto, Long> {

}
