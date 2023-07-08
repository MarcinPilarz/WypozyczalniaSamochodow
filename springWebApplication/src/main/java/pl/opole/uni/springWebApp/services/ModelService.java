package pl.opole.uni.springWebApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.opole.uni.springWebApp.models.ModelSamochodu;
import pl.opole.uni.springWebApp.repositories.ModelRepository;

@Service
public class ModelService implements MainService<ModelSamochodu> {

	@Autowired
	private ModelRepository modelRepo;

	/**
	 * Pobiera wszystkie elementy typu ModelSamochodu.
	 *
	 * @return lista wszystkich elementów typu ModelSamochodu
	 */
	@Override
	public List<ModelSamochodu> findAllItems() {
		// TODO Auto-generated method stub
		return modelRepo.findAll();
	}

	/**
	 * Pobiera listę elementów typu ModelSamochodu na podstawie nazwy modelu.
	 *
	 * @param nazwaModelu nazwa modelu
	 * @return lista elementów typu ModelSamochodu pasujących do podanej nazwy
	 *         modelu
	 */

	public List<ModelSamochodu> findNazwaModelu(String nazwaModelu) {
		return modelRepo.findByNazwaModelu(nazwaModelu);
	}

	/**
	 * Dodaje nowy element typu ModelSamochodu.
	 *
	 * @param modelSamochodu nowy element typu ModelSamochodu do dodania
	 */
	@Override
	public void addItem(ModelSamochodu modelSamochodu) {
		// TODO Auto-generated method stub
		modelRepo.save(modelSamochodu);
	}

	/**
	 * Usuwa element typu ModelSamochodu.
	 *
	 * @param modelSamochodu element typu ModelSamochodu do usunięcia
	 */
	@Override
	public void deleteItem(ModelSamochodu modelSamochodu) {
		// TODO Auto-generated method stub
		modelRepo.delete(modelSamochodu);
	}

	/**
	 * Aktualizuje element typu ModelSamochodu.
	 *
	 * @param modelSamochodu element typu ModelSamochodu do aktualizacji
	 */
	@Override
	public void updateItem(ModelSamochodu modelSamochodu) {
		// TODO Auto-generated method stub
		modelRepo.save(modelSamochodu);
	}

	/**
	 * Znajduje element typu ModelSamochodu na podstawie jego identyfikatora.
	 *
	 * @param id identyfikator elementu typu ModelSamochodu
	 * @return element typu ModelSamochodu lub null, jeśli nie istnieje
	 */
	@Override
	public ModelSamochodu findById(Long id) {
		// TODO Auto-generated method stub
		return modelRepo.findById(id).orElse(null);
	}

}
