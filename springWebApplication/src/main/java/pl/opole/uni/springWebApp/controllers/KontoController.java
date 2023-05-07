package pl.opole.uni.springWebApp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.opole.uni.springWebApp.models.Konto;
import pl.opole.uni.springWebApp.models.Przelew;
import pl.opole.uni.springWebApp.services.KontoService;

@RestController
public class KontoController {

	private KontoService kontoService;
	@GetMapping("/konta")
	public List<Konto> getKonta(){
		return kontoService.getKonta();
	}
	
	@PostMapping("/konta")
	public void dodajKonto(@RequestBody Konto noweKonto) {
	
		kontoService.dodajKonto(noweKonto);
	}
	
	@GetMapping("/przelewy")
	public List<Konto> getPrzelewy(){
		return kontoService.getKonta();
		
	}
	
	@PostMapping("/przelewy")
	public void przelew(@RequestBody Przelew przelew) {
	
		//kontoService.przelew(przelew);
	}
}
