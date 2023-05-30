package pl.opole.uni.springWebApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.opole.uni.springWebApp.models.Marka;
import pl.opole.uni.springWebApp.models.ModelSamochodu;
import pl.opole.uni.springWebApp.services.MarkaService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MarkaController {

	@Autowired
	private MarkaService markaService;
	
	@GetMapping("/marka")
	public List<Marka> getModelSamochodu(@RequestParam(required = false) String nazwaMarka) {

		
			return markaService.findAllItems();
	
		
	}
	
}
