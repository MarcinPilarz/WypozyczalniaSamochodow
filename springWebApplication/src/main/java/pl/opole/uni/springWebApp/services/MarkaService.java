package pl.opole.uni.springWebApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.opole.uni.springWebApp.models.Marka;
import pl.opole.uni.springWebApp.repositories.MarkaRepository;

@Service
public class MarkaService implements MainService<Marka>{

	@Autowired
	private MarkaRepository markaRepo;
	@Override
	public List<Marka> findAllItems() {
		// TODO Auto-generated method stub
		return markaRepo.findAll();
	}

	@Override
	public void addItem(Marka object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteItem(Marka object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateItem(Marka object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Marka findById(Long id) {
		// TODO Auto-generated method stub
		return markaRepo.findById(id).orElse(null);
	}

}
