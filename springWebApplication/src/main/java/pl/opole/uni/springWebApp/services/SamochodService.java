package pl.opole.uni.springWebApp.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import pl.opole.uni.springWebApp.models.OkresWypozyczenia;
import pl.opole.uni.springWebApp.models.Samochod;
import pl.opole.uni.springWebApp.repositories.SamochodRepository;
import pl.opole.uni.springWebApp.repositories.WypozyczenieRepository;

@Service
public class SamochodService implements MainService<Samochod> {

	@Autowired
	private SamochodRepository samochodRepo;
	@Autowired
	private WypozyczenieRepository okresWypozyczenia;

	@Override
	public List<Samochod> findAllItems() {
		// TODO Auto-generated method stub
		return samochodRepo.findAll();
	}

	/**
	 * Pobiera listę samochodów na podstawie marki.
	 *
	 * @param marka marka samochodu
	 * @return lista samochodów pasujących do podanej marki
	 */
	public List<Samochod> findSamochody(String marka) {

		return samochodRepo.findByMarkaNative(marka);
	}

	/**
	 * Dodaje nowy samochód.
	 *
	 * @param samochod samochód do dodania
	 * @throws IOException w przypadku błędu podczas konwersji obrazka samochodu
	 */
	@Override
	public void addItem(Samochod samochod) {

		if (samochod.getZdjecie() != null) {
			try {
				String zdjecieBase64 = new String(samochod.getZdjecie());
				byte[] zdjecieBytes = Base64.getDecoder().decode(zdjecieBase64);
				samochod.setZdjecie(zdjecieBytes);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.print("additem error");
			}
		}
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

	/**
	 * Sortuje samochody w kolejności rosnącej według ceny.
	 *
	 * @return lista samochodów posortowana rosnąco według ceny
	 */
	public List<Samochod> sortByPriceAsc() {
		return samochodRepo.findByOrderByCenaSamochodu();
	}

	/**
	 * Sortuje samochody w kolejności malejącej według ceny.
	 *
	 * @return lista samochodów posortowana malejąco według ceny
	 */
	public List<Samochod> sortByPriceDesc() {
		return samochodRepo.findByOrderByCenaSamochoduDesc();
	}

}
