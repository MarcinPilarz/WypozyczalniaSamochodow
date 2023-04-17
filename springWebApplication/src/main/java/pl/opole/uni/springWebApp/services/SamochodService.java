package pl.opole.uni.springWebApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.opole.uni.springWebApp.models.Samochod;
import pl.opole.uni.springWebApp.repositories.SamochodRepository;

@Service
public class SamochodService implements MainService<Samochod>{

	
	@Autowired
	private SamochodRepository samochodRepo;
	
	@Override
	public List<Samochod> findAllItems() {
		// TODO Auto-generated method stub
		return samochodRepo.findAll();
	}

	@Override
	public void addItem(Samochod samochod) {
		// TODO Auto-generated method stub
		samochodRepo.save(samochod);
		
	}

	@Override
	public void deleteItem(Samochod samochod) {
		// TODO Auto-generated method stub
		samochodRepo.delete(samochod);
	}

	@Override
	public void updateItem(Samochod samochod) {
		// TODO Auto-generated method stub
		samochodRepo.save(samochod);
	}

	@Override
	public Samochod findById(Long id) {
		// TODO Auto-generated method stub
		return samochodRepo.findById(id).orElse(null);
	}

}
