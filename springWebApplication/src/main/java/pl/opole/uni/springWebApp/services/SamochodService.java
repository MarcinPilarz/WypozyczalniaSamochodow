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

	public List<Samochod> findSamochody(String marka) {
		// TODO Auto-generated method stub
		return samochodRepo.findByMarkaNative(marka);
	}
//	
//	public List<Samochod> findRokProduckji(Integer rok_Produkcji) {
//		// TODO Auto-generated method stub
//		return samochodRepo.findByRokProdukcjiGreaterThan(rok_Produkcji);
//	}

	@Override
	public void addItem(Samochod samochod) {
		// TODO Auto-generated method stub
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

	public List<Samochod> sortByPriceAsc() {
		return samochodRepo.findByOrderByCenaSamochodu();
	}

//	 public void dodajZdjecie(Long id, MultipartFile zdjecie) throws IOException {
//	        Optional<Samochod> optionalSamochod = samochodRepo.findById(id);
//	        if (optionalSamochod.isPresent()) {
//	            Samochod samochod = optionalSamochod.get();
//	            samochod.setZdjecie(zdjecie.getBytes());
//	            samochodRepo.save(samochod);
//	        } else {
//	            throw new IllegalArgumentException("Samochod o podanym ID nie istnieje.");
//	        }
//	    }

//	public SamochodDTO dodajZdjecie(SamochodDTO samochod) {
//		Samochod samochod = new Samochod();
//		
//	}
}
