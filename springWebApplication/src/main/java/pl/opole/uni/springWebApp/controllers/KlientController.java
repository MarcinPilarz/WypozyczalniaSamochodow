package pl.opole.uni.springWebApp.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.opole.uni.springWebApp.controllers.DTO.TworzenieKlientazUzytkownikiemDTO;
import pl.opole.uni.springWebApp.models.Klient;
import pl.opole.uni.springWebApp.models.User;
import pl.opole.uni.springWebApp.services.KlientService;
import pl.opole.uni.springWebApp.services.UzytkownikService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class KlientController {

	@Autowired
	private UzytkownikService uzytkownikService;

	@Autowired
	private KlientService klientService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public KlientController(UzytkownikService uzytkownikService, KlientService klientService,
			PasswordEncoder passwordEncoder) {
		this.uzytkownikService = uzytkownikService;
		this.klientService = klientService;
		this.passwordEncoder = passwordEncoder;
	}

	// @PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/klienci")
	public List<Klient> getKlient() {
		return klientService.findAllItems();
	}

	@GetMapping(value = "/kliencit/{idKlienta}")
	public ResponseEntity<Klient> getKlientById(@PathVariable("idKlienta") Long idKlienta) {
	    Klient klient = klientService.findById(idKlienta);
	    if (klient != null) {
	        return ResponseEntity.ok(klient);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	

	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping(value = "/klienci/{id}")
	public ResponseEntity<Klient> editKlient(@PathVariable Long id, @Valid @RequestBody Klient updateKlient) {
	    Klient klient = klientService.findById(id);
	    if (klient == null) {
	        return ResponseEntity.notFound().build();
	    }
	    if (updateKlient.getEmail() != null) {
	        klient.setEmail(updateKlient.getEmail());
	    }
	    if (updateKlient.getNrTelefonu_klient() != null) {
	        klient.setNrTelefonu_klient(updateKlient.getNrTelefonu_klient());
	    }
	    klientService.updateItem(klient);
	    return ResponseEntity.ok(klient);
	}
	
	@DeleteMapping(value = "/klienci")
	public ResponseEntity<Klient> deleteKlient(@RequestParam Long id) {
		klientService.deleteItem(klientService.findById(id));
		return ResponseEntity.noContent().build();
	}
	

}
