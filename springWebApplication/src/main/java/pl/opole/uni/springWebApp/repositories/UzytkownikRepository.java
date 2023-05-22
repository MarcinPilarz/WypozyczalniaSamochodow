package pl.opole.uni.springWebApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import pl.opole.uni.springWebApp.models.User;

@Repository
public interface UzytkownikRepository extends JpaRepository<User,Long> {

	User findByUsername(String username);
}
