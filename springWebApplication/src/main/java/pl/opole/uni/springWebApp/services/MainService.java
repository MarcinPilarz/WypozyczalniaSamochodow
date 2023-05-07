package pl.opole.uni.springWebApp.services;

import java.util.List;

import pl.opole.uni.springWebApp.models.Klient;
import pl.opole.uni.springWebApp.models.Samochod;

public interface MainService<T> {

	List<T> findAllItems();
	void addItem (T object);
	void deleteItem (T object);
	void updateItem(T object);
	
	T findById(Long id);
	// Klient zapiszKlienta(Klient klient);
}
