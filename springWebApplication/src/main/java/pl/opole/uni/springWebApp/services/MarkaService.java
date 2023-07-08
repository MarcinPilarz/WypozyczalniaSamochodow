package pl.opole.uni.springWebApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.opole.uni.springWebApp.models.Marka;
import pl.opole.uni.springWebApp.repositories.MarkaRepository;

@Service
public class MarkaService implements MainService<Marka> {

	@Autowired
	private MarkaRepository markaRepo;

	/**
	 * Pobiera wszystkie elementy typu Marka.
	 *
	 * @return lista wszystkich elementów typu Marka
	 */
	@Override
	public List<Marka> findAllItems() {
		// TODO Auto-generated method stub
		return markaRepo.findAll();
	}

	/**
	 * Dodaje nowy element typu Marka.
	 *
	 * @param object nowy element typu Marka do dodania
	 */
	@Override
	public void addItem(Marka object) {
		// TODO Auto-generated method stub

	}

	/**
	 * Usuwa element typu Marka.
	 *
	 * @param object element typu Marka do usunięcia
	 */

	@Override
	public void deleteItem(Marka object) {
		// TODO Auto-generated method stub

	}

	/**
	 * Aktualizuje element typu Marka.
	 *
	 * @param object element typu Marka do aktualizacji
	 */
	@Override
	public void updateItem(Marka object) {
		// TODO Auto-generated method stub

	}

	/**
	 * Znajduje element typu Marka na podstawie jego identyfikatora.
	 *
	 * @param id identyfikator elementu typu Marka
	 * @return element typu Marka lub null, jeśli nie istnieje
	 */
	@Override
	public Marka findById(Long id) {
		// TODO Auto-generated method stub
		return markaRepo.findById(id).orElse(null);
	}

}
