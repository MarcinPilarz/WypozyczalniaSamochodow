package pl.opole.uni.springWebApp.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

import pl.opole.uni.springWebApp.controllers.DTO.PostDTO;
import pl.opole.uni.springWebApp.controllers.DTO.SamochodDTO;
import pl.opole.uni.springWebApp.models.Samochod;
import pl.opole.uni.springWebApp.services.SamochodService;

import static pl.opole.uni.springWebApp.controllers.mapper.SamochodDTOMapper.mapSamochodToSamochodDTO;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
	
	
	@GetMapping("/samochod/samochoddto")
	public List<SamochodDTO> getSamochodDto() {
		return mapSamochodToSamochodDTO(samochodService.findAllItems());
				
	}
	
	
	@GetMapping("/sortow/anieCena")
	public List<Samochod> sortByPriceAsc(){
		return samochodService.sortByPriceAsc();
	}

	@PostMapping(value="/samochod/dto")
	public ResponseEntity<Samochod> editSamochodDTO(@RequestBody @Valid PostDTO postDto){
		
		Samochod samochod = new Samochod();

		samochod.setPojemnosc_baterii(postDto.pojemnoscBaterii());
		samochod.setIlosc_drzwi(postDto.ilosc_Drzwi());
		samochod.setKolor_samochodu(postDto.kolor_samochodu());
		samochod.setMoc_silnika(postDto.moc_silnika());
		samochod.setRokProdukcji(postDto.rokProdukcji());
		samochod.setCenaSamochodu(postDto.cenaSamochodu());
		samochod.setCzyWypozyczony(postDto.czyWypozyczony());
		samochodService.addItem(samochod);
		return ResponseEntity.ok(samochod);
	}
	
	@PostMapping(value="/samochod")
	public ResponseEntity<Samochod> editSamochod(@RequestBody @Valid Samochod nowySamochod){
		samochodService.addItem(nowySamochod);
		return ResponseEntity.ok(nowySamochod);
	}
	
	
	@PutMapping(value="/samochod/dto/{id}")
	public ResponseEntity<Samochod> editSamochodDTO(@RequestParam Long id, @RequestBody @Valid PostDTO postDto){
		Samochod samochod = new Samochod();
		samochod.setIdSamochodu(id);
		samochod.setPojemnosc_baterii(postDto.pojemnoscBaterii());
		samochod.setIlosc_drzwi(postDto.ilosc_Drzwi());
		samochod.setKolor_samochodu(postDto.kolor_samochodu());
		samochod.setMoc_silnika(postDto.moc_silnika());
		samochod.setRokProdukcji(postDto.rokProdukcji());
		samochod.setCenaSamochodu(postDto.cenaSamochodu());
		samochod.setCzyWypozyczony(postDto.czyWypozyczony());
		return ResponseEntity.ok(samochod);
//		Samochod samochod = samochodService.findById(id);
//		if(samochod ==null) {
//			return ResponseEntity.notFound().build();
//		}
//		updateSamochod.setIdSamochodu(samochod.getIdSamochodu());
//		samochodService.updateItem(updateSamochod);
//		return ResponseEntity.ok(updateSamochod);
	}
	
	@PutMapping(value="/samochod{id}")
	public ResponseEntity<Samochod> editSamochod(@RequestParam Long id, @RequestBody Samochod updateSamochod){
		
		Samochod samochod = samochodService.findById(id);
		if(samochod ==null) {
			return ResponseEntity.notFound().build();
		}
		updateSamochod.setIdSamochodu(samochod.getIdSamochodu());
		samochodService.updateItem(updateSamochod);
		return ResponseEntity.ok(updateSamochod);
	}
	
	@DeleteMapping(value= "/samochod")
	public ResponseEntity<Samochod> deleteSamochod(@RequestParam Long id){
		
		
		Samochod samochod = samochodService.findById(id);
	    
	    if (samochod != null) {
	        samochodService.deleteItem(samochod);
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
		
//		samochodService.deleteItem(samochodService.findById(id));
//		return ResponseEntity.noContent().build();
	}
	
	
//	public String dodanieZdjecia() {
//		return "Udało się!";
//	}
	
}
