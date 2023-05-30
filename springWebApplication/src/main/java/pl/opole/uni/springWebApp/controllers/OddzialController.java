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
	
	@GetMapping("/oddzial")
	public List<Oddzial> getModelSamochodu(@RequestParam(required = false) String nazwaOddzial) {

			return oddzialService.findAllItems();
		
	}
	
	@PostMapping(value = "/oddzial")
	public ResponseEntity<Oddzial> editModelSamochodu(@Valid @RequestBody Oddzial nowyOddzial) {
		oddzialService.addItem(nowyOddzial);
		return ResponseEntity.ok(nowyOddzial);
	}

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

	@DeleteMapping(value = "/oddzial")
	public ResponseEntity<Oddzial> deleteModelSamochodu(@RequestParam Long id) {
		oddzialService.deleteItem(oddzialService.findById(id));
		return ResponseEntity.noContent().build();
	}
}


