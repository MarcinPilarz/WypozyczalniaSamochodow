package pl.opole.uni.springWebApp.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.opole.uni.springWebApp.models.OkresWypozyczenia;
import pl.opole.uni.springWebApp.services.WypozyczeniaService;

@RestController
@RequestMapping("/wypozyczenie")
public class WypozyczenieController {

	private WypozyczeniaService wypozyczeniaService;
	
	@Autowired
	public WypozyczenieController(WypozyczeniaService wypozyczeniaService) {
		
		this.wypozyczeniaService=wypozyczeniaService;
	}
	
	@GetMapping("/wypozyczenia")
	public List<OkresWypozyczenia> getWypozyczenie(){
		return wypozyczeniaService.getWypozyczenie();
	}
	@PostMapping("/nowe")
	public void wypozyczSamochod( @Valid @RequestParam Long idKlienta, @Valid @RequestParam Long idSamochodu,@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate terminWypozyczenia, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate terminOddania) {
	
		wypozyczeniaService.wypozyczSamochod(idKlienta, idSamochodu, terminWypozyczenia, terminOddania);
	}
}
//
