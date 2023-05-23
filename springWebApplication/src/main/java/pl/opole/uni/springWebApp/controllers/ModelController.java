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
import pl.opole.uni.springWebApp.services.ModelService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ModelController {

	@Autowired
	private ModelService modelService;
	
//	@GetMapping("/model")
//	public List<ModelSamochodu> getModelSamochodu(){
//		return modelService.findAllItems();
//	}
	
	@GetMapping("/model")
	public List<ModelSamochodu> getModelSamochodu(@RequestParam(required=false) String nazwaModelu){
		
		if(nazwaModelu==null)
		return modelService.findAllItems();
		else
		return modelService.findNazwaModelu(nazwaModelu);
	}
	
	@PostMapping(value="/model")
	public ResponseEntity<ModelSamochodu> editModelSamochodu(@Valid @RequestBody ModelSamochodu nowyModel){
		modelService.addItem(nowyModel);
		return ResponseEntity.ok(nowyModel);
	}
	
	@PutMapping(value="/model")
	public ResponseEntity<ModelSamochodu> editModelSamochodu( @Valid @RequestParam Long id, @RequestBody ModelSamochodu updateModel){
		ModelSamochodu modelSamochodu= modelService.findById(id);
		if(modelSamochodu == null) {
			return ResponseEntity.notFound().build();
		}
		
		updateModel.setId(modelSamochodu.getId());
		modelService.updateItem(updateModel);
		return ResponseEntity.ok(updateModel);
	}
	
	@DeleteMapping(value="/model")
	public ResponseEntity<ModelSamochodu> deleteModelSamochodu(@RequestParam Long id){
		modelService.deleteItem(modelService.findById(id));
		return ResponseEntity.noContent().build();
	}
}
