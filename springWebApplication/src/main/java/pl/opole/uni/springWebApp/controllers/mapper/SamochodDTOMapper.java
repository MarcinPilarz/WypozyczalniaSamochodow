package pl.opole.uni.springWebApp.controllers.mapper;

import java.util.List;
import java.util.stream.Collectors;

import pl.opole.uni.springWebApp.controllers.DTO.SamochodDTO;
import pl.opole.uni.springWebApp.models.Samochod;

public class SamochodDTOMapper {
	public static List<SamochodDTO> mapSamochodToSamochodDTO(List<Samochod> samochodmap){
		return samochodmap.stream()
		.map(samochod -> new SamochodDTO(
				samochod.getIdSamochodu(), 
				samochod.getCenaSamochodu(), 
				samochod.isCzyWypozyczony(),
				samochod.getModelSamochodu().getNazwa(),
				samochod.getOddzial().getAdresOddzial(),
				samochod.getMarka().getNazwaMarka()))
		.collect(Collectors.toList());
	}
}
