package pl.opole.uni.springWebApp.services;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.opole.uni.springWebApp.models.Klient;
import pl.opole.uni.springWebApp.models.OkresWypozyczenia;
import pl.opole.uni.springWebApp.models.Samochod;
import pl.opole.uni.springWebApp.repositories.KlientRepository;
import pl.opole.uni.springWebApp.repositories.SamochodRepository;
import pl.opole.uni.springWebApp.repositories.WypozyczenieRepository;

@Service
@Transactional
public class WypozyczeniaService {
	private KlientRepository klientRepo;
	private SamochodRepository samochodRepo;
	private WypozyczenieRepository wypozyczenieRepo;
	
	@Autowired
   public WypozyczeniaService(KlientRepository klientRepo, SamochodRepository samochodRepo,WypozyczenieRepository wypozyczenieRepo) {
		this.klientRepo=klientRepo;
		this.samochodRepo=samochodRepo;
		this.wypozyczenieRepo=wypozyczenieRepo;
	}
	
	public List<OkresWypozyczenia> getWypozyczenie() {
	    return wypozyczenieRepo.findAll();
	}
	
	public void wypozyczSamochod(Long idKlienta, Long idSamochodu, LocalDate terminWypozyczenia, LocalDate terminOddania) {
		Klient klient= klientRepo.findById(idKlienta).orElseThrow(() -> new RuntimeException("Nie znaleziono klienta o id: "+ idKlienta));
		Samochod samochod = samochodRepo.findById(idSamochodu).orElseThrow(() -> new RuntimeException ("Nie znaleziono samochodu o id: " + idSamochodu));
	
	if(samochod.isCzyWypozyczony()) {
		throw new RuntimeException("Ten samochod jest juz wypożyczony.");
	}
	
	samochod.setCzyWypozyczony(true);
	
	OkresWypozyczenia wypozyczenia = new OkresWypozyczenia();
	wypozyczenia.setKlient(klient);
	wypozyczenia.setSamochod(samochod);
	wypozyczenia.setTerminWypozyczenia(terminWypozyczenia);
	wypozyczenia.setTerminOddania(terminOddania);
	
	wypozyczenieRepo.save(wypozyczenia);
	}
	
	
}
