package pl.opole.uni.springWebApp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.opole.uni.springWebApp.models.Klient;
import pl.opole.uni.springWebApp.services.KlientService;

@RestController
public class KlientController {

	@Autowired
	private KlientService klientService;
	
	@GetMapping(value="/klienci")
	public List<Klient> getKlient(){
		return klientService.findAllItems();
	}
	
	
	@PostMapping(value="/klienci")
	public ResponseEntity<Klient> editKlient(@Valid @RequestBody Klient nowyKlient){
		klientService.addItem(nowyKlient);
		return ResponseEntity.ok(nowyKlient);
	}
	
	@PutMapping(value="/klienci")
	public ResponseEntity<Klient> editKlient(@Valid @RequestParam Long id, @RequestBody Klient updateKlient){
		Klient klient=klientService.findById(id);
		if(klient == null) {
			return ResponseEntity.notFound().build();
		}
		updateKlient.setIdKlienta(klient.getIdKlienta());
		klientService.updateItem(updateKlient);
		return ResponseEntity.ok(updateKlient);
	}
	
	@DeleteMapping(value="/klienci")
	public ResponseEntity<Klient> deleteKlient(@RequestParam Long id){
		klientService.deleteItem(klientService.findById(id));
		return ResponseEntity.noContent().build();
	}
}
