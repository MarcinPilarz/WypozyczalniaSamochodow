package pl.opole.uni.springWebApp.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.opole.uni.springWebApp.models.Konto;
import pl.opole.uni.springWebApp.models.Przelew;
import pl.opole.uni.springWebApp.repositories.KontoRepository;
import pl.opole.uni.springWebApp.repositories.PrzelewRepository;

@Service
public class KontoService {

	
	@Autowired 
	private KontoRepository kontoRepo;
	@Autowired
	private PrzelewRepository przelewRepo;
	
	public List<Konto> getKonta(){
		return kontoRepo.findAll();
	}
	
	public void dodajKonto(Konto noweKonto) {
		kontoRepo.save(noweKonto);
	}
	
	public List<Przelew> getPrzelewy(){
		return przelewRepo.findAll();
	}
	
//	@Transactional
//	public void przelew(Przelew przelew) {
//		Konto kontoZ=kontoRepo.getById(przelew.getKontoZ().getId()).get();
//		kontoZ.setKonto(kontoZ.getKonto()- przelew.getKonto());
//		
//		Konto kontoDo=kontoRepo.getById(przelew.getKontoDo().getId()).get();
//		kontoDo.setKonto(kontoDo.getKonto()+ przelew.getKonto);
//		
//		przelewRepo.save(przelew);
//	}
}
