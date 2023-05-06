package pl.opole.uni.springWebApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.opole.uni.springWebApp.models.Samochod;
import pl.opole.uni.springWebApp.services.SamochodService;

@RestController
public class SamochodController {

	@Autowired
	private SamochodService samochodService;
	
//	@GetMapping("/samochod")
//	public List<Samochod> getSamochod(){
//		return samochodService.findAllItems();
//	}
	
	@GetMapping("/samochod")
	public List<Samochod> getSamochod(@RequestParam(required = false) String marka){
		
		if(marka==null) 
			return samochodService.findAllItems();
		else
			return samochodService.findSamochody(marka);
		
		
//		if (marka == null)
//			{d
//			if (rokProdukcji== null)
//				return samochodService.findAllItems();
//			else 
//				return samochodService.findRokProduckji(rokProdukcji);
//
//			}
//		else
//			return samochodService.findSamochody(marka);
//		
		}
	
	@GetMapping("sortowanieCena")
	public List<Samochod> sortByPriceAsc(){
		return samochodService.sortByPriceAsc();
	}

	@PostMapping(value="/samochod")
	public ResponseEntity<Samochod> editSamochod(@RequestBody Samochod nowySamochow){
		samochodService.addItem(nowySamochow);
		return ResponseEntity.ok(nowySamochow);
	}
	
	@PutMapping(value="/samochod")
	public ResponseEntity<Samochod> editSamochod(@RequestParam Long id, @RequestBody Samochod updateSamochod){
		
		Samochod samochod = samochodService.findById(id);
		if(samochod ==null) {
			return ResponseEntity.notFound().build();
		}
		updateSamochod.setId(samochod.getId());
		samochodService.updateItem(updateSamochod);
		return ResponseEntity.ok(updateSamochod);
	}
	
	@DeleteMapping(value= "/samochod")
	public ResponseEntity<Samochod> deleteSamochod(@RequestParam Long id){
		
		samochodService.deleteItem(samochodService.findById(id));
		return ResponseEntity.noContent().build();
	}
	
	
}
