package pl.opole.uni.springWebApp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.opole.uni.springWebApp.models.ModelSamochodu;
import pl.opole.uni.springWebApp.models.Oddzial;
import pl.opole.uni.springWebApp.services.OddzialService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class OddzialController {

	@Autowired
	OddzialService oddzialService;
	
	
	/**
     * Pobiera listę oddziałów lub oddział o podanej nazwie.
     *
     * @param nazwaOddzial Opcjonalna nazwa oddziału do filtrowania.
     * @return ResponseEntity z listą oddziałów lub oddziałem o podanej nazwie i statusem HTTP 200 OK.
     */
	@GetMapping("/oddzial")
	public List<Oddzial> getModelSamochodu(@RequestParam(required = false) String nazwaOddzial) {

			return oddzialService.findAllItems();
		
	}
	
	
	/**
     * Dodaje nowy oddział.
     *
     * @param nowyOddzial Nowy obiekt oddziału do dodania.
     * @return ResponseEntity z dodanym oddziałem i statusem HTTP 200 OK.
     */
	@PostMapping(value = "/oddzial")
	public ResponseEntity<Oddzial> editModelSamochodu(@Valid @RequestBody Oddzial nowyOddzial) {
		oddzialService.addItem(nowyOddzial);
		return ResponseEntity.ok(nowyOddzial);
	}
	
	
	/**
     * Edytuje istniejący oddział.
     *
     * @param id           ID oddziału do edycji.
     * @param updateOddzial Obiekt oddziału zawierający zaktualizowane dane.
     * @return ResponseEntity z zaktualizowanym oddziałem i statusem HTTP 200 OK lub statusem HTTP 404 Not Found, jeśli oddział o podanym ID nie istnieje.
     */
	@PutMapping(value = "/oddzial")
	public ResponseEntity<Oddzial> editOddzialSamochodu(@Valid @RequestParam Long id,
			@RequestBody Oddzial updateOddzial) {
		Oddzial oddzial= oddzialService.findById(id);
		if (oddzial == null) {
			return ResponseEntity.notFound().build();
		}

		updateOddzial.setIdOddzial(oddzial.getIdOddzial());
		oddzialService.updateItem(updateOddzial);
		return ResponseEntity.ok(updateOddzial);
	}

	
	 /**
     * Usuwa oddział o podanym ID.
     *
     * @param id ID oddziału do usunięcia.
     * @return ResponseEntity z pustą treścią i statusem HTTP 204 No Content.
     */
	@DeleteMapping(value = "/oddzial")
	public ResponseEntity<Oddzial> deleteModelSamochodu(@RequestParam Long id) {
		oddzialService.deleteItem(oddzialService.findById(id));
		return ResponseEntity.noContent().build();
	}
}


