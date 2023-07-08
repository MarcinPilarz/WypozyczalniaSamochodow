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
	
	/**
	 * Pobiera wszystkie elementy typu Klient.
	 *
	 * @return lista wszystkich elementów typu Klient
	 */
	@Override
	public List<Klient> findAllItems() {
		// TODO Auto-generated method stub
		return klientRepo.findAll();
	}

	
	/**
	 * Dodaje nowy element typu Klient.
	 *
	 * @param klient nowy element typu Klient do dodania
	 */
	@Override
	public void addItem(Klient klient) {
		// TODO Auto-generated method stub
		klientRepo.save(klient);
	}

	
	/**
	 * Usuwa element typu Klient.
	 *
	 * @param klient element typu Klient do usunięcia
	 */
	
	@Override
	public void deleteItem(Klient klient) {
		// TODO Auto-generated method stub
		klientRepo.delete(klient);
	}

	/**
	 * Aktualizuje element typu Klient.
	 *
	 * @param klient element typu Klient do aktualizacji
	 */
	
	@Override
	public void updateItem(Klient klient) {
		// TODO Auto-generated method stub
		klientRepo.save(klient);
	}

	
	/**
	 * Znajduje element typu Klient na podstawie jego identyfikatora.
	 *
	 * @param id identyfikator elementu typu Klient
	 * @return element typu Klient lub null, jeśli nie istnieje
	 */
	@Override
	public Klient findById(Long id) {
		// TODO Auto-generated method stub
		return klientRepo.findById(id).orElse(null);
	}

}
