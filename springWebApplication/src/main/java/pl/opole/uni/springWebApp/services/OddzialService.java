package pl.opole.uni.springWebApp.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.opole.uni.springWebApp.models.ModelSamochodu;
import pl.opole.uni.springWebApp.models.Oddzial;
import pl.opole.uni.springWebApp.repositories.OddzialRepository;

@Service
public class OddzialService implements MainService<Oddzial> {

	
	@Autowired
	OddzialRepository oddzialRepo;
	
	@Override
	public List<Oddzial> findAllItems() {
		// TODO Auto-generated method stub
		return oddzialRepo.findAll();
	}

	
	 
//	public List<Oddzial> findNazwaModelu(String nazwaOddzial){
//		return oddzialRepo.findByNazwaModelu(nazwaOddzial);
//	}
	
	
	
	@Override
	public void addItem(Oddzial nowyOddzial) {
		// TODO Auto-generated method stub
		oddzialRepo.save(nowyOddzial);
	}

	@Override
	public void deleteItem(Oddzial oddzial) {
		// TODO Auto-generated method stub
		oddzialRepo.delete(oddzial);
	}

	@Override
	public void updateItem(Oddzial oddzial) {
		// TODO Auto-generated method stub
		oddzialRepo.save(oddzial);
	}

	@Override
	public Oddzial findById(Long id) {
		// TODO Auto-generated method stub
		return oddzialRepo.findById(id).orElse(null);
	}
}
