package pl.opole.uni.springWebApp.services;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.opole.uni.springWebApp.models.Klient;
import pl.opole.uni.springWebApp.models.Oddzial;
import pl.opole.uni.springWebApp.models.OkresWypozyczenia;
import pl.opole.uni.springWebApp.models.Samochod;
import pl.opole.uni.springWebApp.repositories.KlientRepository;
import pl.opole.uni.springWebApp.repositories.OddzialRepository;
import pl.opole.uni.springWebApp.repositories.SamochodRepository;
import pl.opole.uni.springWebApp.repositories.WypozyczenieRepository;

@Service
@Transactional
public class WypozyczeniaService {
	private KlientRepository klientRepo;
	private SamochodRepository samochodRepo;
	private WypozyczenieRepository wypozyczenieRepo;
	private OddzialRepository oddzialRepo;

	@Autowired
	public WypozyczeniaService(KlientRepository klientRepo, SamochodRepository samochodRepo,
			WypozyczenieRepository wypozyczenieRepo, OddzialRepository oddzialRepo) {
		this.klientRepo = klientRepo;
		this.samochodRepo = samochodRepo;
		this.wypozyczenieRepo = wypozyczenieRepo;
		this.oddzialRepo = oddzialRepo;
	}

	public List<OkresWypozyczenia> getWypozyczenie() {
		return wypozyczenieRepo.findAll();
	}

	public void wypozyczSamochod(Long idKlienta, Long idSamochodu, Long idOddzialWypozyczenia, Long idOddzialOddania,
			LocalDate terminWypozyczenia, LocalDate terminOddania) {
		Klient klient = klientRepo.findById(idKlienta)
				.orElseThrow(() -> new RuntimeException("Nie znaleziono klienta o id: " + idKlienta));
		Samochod samochod = samochodRepo.findById(idSamochodu)
				.orElseThrow(() -> new RuntimeException("Nie znaleziono samochodu o id: " + idSamochodu));
		Oddzial oddzialWypozyczenia = oddzialRepo.findById(idOddzialWypozyczenia)
				.orElseThrow(() -> new RuntimeException("Nie znaleziono oddzialu o id: " + idOddzialWypozyczenia));
		Oddzial oddzialOddania = oddzialRepo.findById(idOddzialOddania)
				.orElseThrow(() -> new RuntimeException("Nie znaleziono oddzialu o id: " + idOddzialOddania));

		if (samochod.isCzyWypozyczony()) {
			throw new RuntimeException("Ten samochód jest już wypożyczony.");
		}

		samochod.setCzyWypozyczony(true);

		OkresWypozyczenia wypozyczenia = new OkresWypozyczenia();
		wypozyczenia.setKlient(klient);
		wypozyczenia.setSamochod(samochod);
		wypozyczenia.setTerminWypozyczenia(terminWypozyczenia);
		wypozyczenia.setTerminOddania(terminOddania);
		wypozyczenia.setOddzialWypozyczenia(oddzialWypozyczenia);
		wypozyczenia.setOddzialOddania(oddzialOddania);

		wypozyczenieRepo.save(wypozyczenia);
	}

	public void anulujWypozyczenie(Long idWypozyczenia) {
		OkresWypozyczenia wypozyczenie = wypozyczenieRepo.findById(idWypozyczenia)
				.orElseThrow(() -> new RuntimeException("Nie znaleziono wypożyczenia o id: " + idWypozyczenia));

		if (!wypozyczenie.getSamochod().isCzyWypozyczony()) {
			throw new RuntimeException("To wypożyczenie nie jest aktywne.");
		}

		wypozyczenie.getSamochod().setCzyWypozyczony(false);
		wypozyczenieRepo.delete(wypozyczenie);
	}
}