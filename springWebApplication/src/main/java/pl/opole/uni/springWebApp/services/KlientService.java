package pl.opole.uni.springWebApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.opole.uni.springWebApp.models.Klient;
import pl.opole.uni.springWebApp.repositories.KlientRepository;

@Service
public class KlientService implements MainService<Klient> {

	
	@Autowired
	private KlientRepository klientRepo;
	
	@Override
	public List<Klient> findAllItems() {
		// TODO Auto-generated method stub
		return klientRepo.findAll();
	}

	@Override
	public void addItem(Klient klient) {
		// TODO Auto-generated method stub
		klientRepo.save(klient);
	}

	@Override
	public void deleteItem(Klient klient) {
		// TODO Auto-generated method stub
		klientRepo.delete(klient);
	}

	@Override
	public void updateItem(Klient klient) {
		// TODO Auto-generated method stub
		klientRepo.save(klient);
	}

	@Override
	public Klient findById(Long id) {
		// TODO Auto-generated method stub
		return klientRepo.findById(id).orElse(null);
	}

}
