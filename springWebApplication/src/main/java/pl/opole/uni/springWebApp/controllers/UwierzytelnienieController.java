package pl.opole.uni.springWebApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pl.opole.uni.springWebApp.models.User;
import pl.opole.uni.springWebApp.services.UzytkownikService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UwierzytelnienieController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UzytkownikService uzytkownikService;

	@PostMapping("/login")
	@ResponseBody
	public String login(@RequestBody User user) {
		try {
			// Uwierzytelnianie użytkownika
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);

			// Generowanie tokena JWT
			UserDetails userDetails = uzytkownikService.loadUserByUsername(user.getUsername());
			String token = uzytkownikService.generateToken(userDetails);

			return token;
		} catch (AuthenticationException e) {
			// Obsłuż błędy uwierzytelniania
			return "Błąd uwierzytelniania: " + e.getMessage();
		}
	}

}
