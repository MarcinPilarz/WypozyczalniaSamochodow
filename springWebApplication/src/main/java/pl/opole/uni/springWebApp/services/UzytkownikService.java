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

	private static final String SECRET_KEY = "tajnyKluczDoPodpisuTokena";
	@Autowired
	UzytkownikRepository uzytkownikRepo;

	/**
	 * Ładuje użytkownika na podstawie nazwy użytkownika.
	 *
	 * @param username nazwa użytkownika
	 * @return szczegóły użytkownika (implementujące interfejs UserDetails)
	 * @throws UsernameNotFoundException jeśli użytkownik nie został znaleziony
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = uzytkownikRepo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Uzytkownik nie został znaleziony");
		}
		return user;

	}

	/**
	 * Zapisuje użytkownika.
	 *
	 * @param user użytkownik do zapisania
	 */
	public void saveUser(User user) {

		uzytkownikRepo.save(user);
	}

	/**
	 * Generuje token JWT na podstawie szczegółów użytkownika.
	 *
	 * @param userDetails szczegóły użytkownika
	 * @return wygenerowany token JWT
	 */
	public String generateToken(UserDetails userDetails) {

		SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

		Date now = new Date();
		Date expirationDate = new Date(now.getTime() + 86400000); // Token wygasa po 24 godzinach

		return Jwts.builder().setSubject(userDetails.getUsername()).signWith(key).compact();

	}

	/**
	 * Loguje użytkownika i zwraca wygenerowany token JWT.
	 *
	 * @param username nazwa użytkownika
	 * @param password hasło użytkownika
	 * @return wygenerowany token JWT
	 * @throws BadCredentialsException jeśli podane hasło jest nieprawidłowe
	 */
	public String loginUser(String username, String password) {

		UserDetails userDetails = loadUserByUsername(username);

		if (!passwordMatches(password, userDetails.getPassword())) {
			throw new BadCredentialsException("Nieprawidłowe hasło");
		}

		// Generuj token JWT
		String token = generateToken(userDetails);

		return token;
	}

	/**
	 * Sprawdza, czy podane hasło jest zgodne z zakodowanym hasłem.
	 *
	 * @param rawPassword     podane hasło w formie czystego tekstu
	 * @param encodedPassword zakodowane hasło
	 * @return true, jeśli hasła są zgodne, w przeciwnym razie false
	 */
	private boolean passwordMatches(String rawPassword, String encodedPassword) {

		return passwordEncoder().matches(rawPassword, encodedPassword);
	}

	private PasswordEncoder passwordEncoder() {
		/**
		 * Tworzy nowy PasswordEncoder (BCryptPasswordEncoder).
		 *
		 * @return nowy PasswordEncoder
		 */
		return new BCryptPasswordEncoder();
	}

	public User getUserByUsername(String username) throws UsernameNotFoundException {
		User user = uzytkownikRepo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Użytkownik nie został znaleziony");
		}
		return user;
	}

	/**
	 * Ładuje użytkownika na podstawie nazwy użytkownika jako obiekt typu User.
	 *
	 * @param username nazwa użytkownika
	 * @return użytkownik (obiekt typu User)
	 * @throws UsernameNotFoundException jeśli użytkownik nie został znaleziony
	 */
	public User loadUserByUsernameAsUser(String username) throws UsernameNotFoundException {

		UserDetails userDetails = loadUserByUsername(username);
		if (userDetails instanceof User) {
			return (User) userDetails;
		} else {
			throw new IllegalStateException("Nieprawidłowa implementacja UserDetailsService");
		}
	}
}