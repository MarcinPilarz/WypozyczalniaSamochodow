package pl.opole.uni.springWebApp.services;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import pl.opole.uni.springWebApp.models.User;
import pl.opole.uni.springWebApp.repositories.UzytkownikRepository;

@Service
public class UzytkownikService implements UserDetailsService {

	
	private static final String SECRET_KEY = "tajnyKluczDoPodpisuTokena"; // Klucz do podpisu tokena (możesz wygenerować losowy klucz)
	@Autowired
	UzytkownikRepository uzytkownikRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
//		User user=uzytkownikRepo.findByUsername(username);
//		 if (user == null) {
//	            throw new UsernameNotFoundException("Uzytkownik nie został znaleziony");
//	        }
//	        return user;
		
		return uzytkownikRepo.findByUsername(username);
	}

	public void saveUser(User user){
		uzytkownikRepo.save(user);
	}
	
	
	
	//Generowanie tokena
	public String generateToken(UserDetails userDetails) {
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + 86400000); // Token wygasa po 24 godzinach

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
	
}
	
	 public String loginUser(String username, String password) {
	        UserDetails userDetails = loadUserByUsername(username);
	        // Sprawdź poprawność hasła (może być potrzebna dodatkowa logika weryfikacji hasła)

	        // Generuj token JWT
	        String token = generateToken(userDetails);

	        return token;
	    }
}