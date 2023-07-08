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

	/**
	 * Pobiera wszystkie elementy typu Oddzial.
	 *
	 * @return lista wszystkich elementów typu Oddzial
	 */
	@Override
	public List<Oddzial> findAllItems() {
		// TODO Auto-generated method stub
		return oddzialRepo.findAll();
	}

//	public List<Oddzial> findNazwaModelu(String nazwaOddzial){
//		return oddzialRepo.findByNazwaModelu(nazwaOddzial);
//	}

	/**
	 * Dodaje nowy element typu Oddzial.
	 *
	 * @param nowyOddzial nowy element typu Oddzial do dodania
	 */

	@Override
	public void addItem(Oddzial nowyOddzial) {
		// TODO Auto-generated method stub
		oddzialRepo.save(nowyOddzial);
	}

	/**
	 * Usuwa element typu Oddzial.
	 *
	 * @param oddzial element typu Oddzial do usunięcia
	 */
	@Override
	public void deleteItem(Oddzial oddzial) {
		// TODO Auto-generated method stub
		oddzialRepo.delete(oddzial);
	}

	/**
	 * Aktualizuje element typu Oddzial.
	 *
	 * @param oddzial element typu Oddzial do aktualizacji
	 */
	@Override
	public void updateItem(Oddzial oddzial) {
		// TODO Auto-generated method stub
		oddzialRepo.save(oddzial);
	}

	/**
	 * Znajduje element typu Oddzial na podstawie jego identyfikatora.
	 *
	 * @param id identyfikator elementu typu Oddzial
	 * @return element typu Oddzial lub null, jeśli nie istnieje
	 */
	@Override
	public Oddzial findById(Long id) {
		// TODO Auto-generated method stub
		return oddzialRepo.findById(id).orElse(null);
	}
}
