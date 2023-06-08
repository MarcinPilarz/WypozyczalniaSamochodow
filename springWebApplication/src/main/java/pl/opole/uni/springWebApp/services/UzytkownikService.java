package pl.opole.uni.springWebApp.services;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import pl.opole.uni.springWebApp.models.User;
import pl.opole.uni.springWebApp.repositories.UzytkownikRepository;

@Service
public class UzytkownikService implements UserDetailsService {

	private static final String SECRET_KEY = "tajnyKluczDoPodpisuTokena"; // Klucz do podpisu tokena (możesz wygenerować
																			// losowy klucz)
	@Autowired
	UzytkownikRepository uzytkownikRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		User user = uzytkownikRepo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Uzytkownik nie został znaleziony");
		}
		return user;

		// return uzytkownikRepo.findByUsername(username);
	}

	public void saveUser(User user) {
		uzytkownikRepo.save(user);
	}

	// Generowanie tokena
	public String generateToken(UserDetails userDetails) {
		SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

		Date now = new Date();
		Date expirationDate = new Date(now.getTime() + 86400000); // Token wygasa po 24 godzinach

		return Jwts.builder().setSubject(userDetails.getUsername()).signWith(key).compact();

	}

	public String loginUser(String username, String password) {
		UserDetails userDetails = loadUserByUsername(username);
		// Sprawdź poprawność hasła (może być potrzebna dodatkowa logika weryfikacji
		// hasła)
		//System.out.print(userDetails);
		
		
		if (!passwordMatches(password, userDetails.getPassword())) {
			throw new BadCredentialsException("Nieprawidłowe hasło");
		}

		
		// Generuj token JWT
		String token = generateToken(userDetails);

		return token;
	}
	
	 

	private boolean passwordMatches(String rawPassword, String encodedPassword) {
		return passwordEncoder().matches(rawPassword, encodedPassword);
	}

	private PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	 public User getUserByUsername(String username) throws UsernameNotFoundException {
	        User user = uzytkownikRepo.findByUsername(username);
	        if (user == null) {
	            throw new UsernameNotFoundException("Użytkownik nie został znaleziony");
	        }
	        return user;
	    }
	 public User loadUserByUsernameAsUser(String username) throws UsernameNotFoundException {
		    UserDetails userDetails = loadUserByUsername(username);
		    if (userDetails instanceof User) {
		        return (User) userDetails;
		    } else {
		        throw new IllegalStateException("Nieprawidłowa implementacja UserDetailsService");
		    }
		}
}