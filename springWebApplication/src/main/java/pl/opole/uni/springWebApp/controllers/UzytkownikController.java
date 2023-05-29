package pl.opole.uni.springWebApp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.opole.uni.springWebApp.models.User;
import pl.opole.uni.springWebApp.services.UzytkownikService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UzytkownikController {

	private UzytkownikService uzytkownikService;

	private PasswordEncoder passwordEncoder;

	public UzytkownikController(UzytkownikService uzytkownikService, PasswordEncoder passwordEncoder) {
		this.uzytkownikService = uzytkownikService;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping(value = "/rejestracjaUzytkownika")
	public ResponseEntity<String> createUser(@RequestBody User user) {
		try {
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			uzytkownikService.saveUser(user);
			return ResponseEntity.ok("Użytkownik został pomyślnie zapisany.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Wystąpił błąd podczas zapisywania użytkownika.");
		}
	}
}
