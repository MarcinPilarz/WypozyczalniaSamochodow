package pl.opole.uni.springWebApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<User> login(@RequestBody User user) {
        try {
        	
        	System.out.println("1 - " + user.getUsername());
        	
            // Uwierzytelnianie użytkownika
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            
            System.out.println(authentication);
            
            SecurityContextHolder.getContext().setAuthentication(authentication);

            
            System.out.println("2");
            // Generowanie tokena JWT
            UserDetails userDetails = uzytkownikService.loadUserByUsername(user.getUsername());
            String token = uzytkownikService.generateToken(userDetails);

            
            System.out.println("3");
            
            // Pobieranie roli użytkownika
            String role = userDetails.getAuthorities().iterator().next().getAuthority();
            
            
            System.out.println("ROLA:      " + role);
            
            	//String role= "USER";
            // Pobieranie obiektu User na podstawie username
            User loggedInUser = uzytkownikService.getUserByUsername(user.getUsername());

            // Aktualizacja obiektu User
            loggedInUser.setRole(role);
            loggedInUser.setToken(token);

            // Zwracanie odpowiedzi z obiektem loggedInUser i statusem HTTP 200 OK
            return ResponseEntity.ok(loggedInUser);
        } catch (AuthenticationException e) {
            // Obsłuż błędy uwierzytelniania
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/login")
    public ResponseEntity<User> checkLoginStatus() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            // Pobieranie zalogowanego użytkownika
            User loggedInUser = (User) authentication.getPrincipal();

            // Zwracanie odpowiedzi z obiektem loggedInUser i statusem HTTP 200 OK
            return ResponseEntity.ok(loggedInUser);
        } else {
            // Zwracanie pustego obiektu User i statusem HTTP 401 Unauthorized
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new User());
        }
    }
    
    @GetMapping("/user")
    public ResponseEntity<User> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = uzytkownikService.getUserByUsername(username);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
//    @GetMapping("/verify")
//    public ResponseEntity<String> verifyToken() {
//      // Sprawdzanie poprawności tokenu i zwracanie odpowiedzi
//
//    	// Token jest niepoprawny lub nie został dostarczony
//    	
//  }
}

    
    

