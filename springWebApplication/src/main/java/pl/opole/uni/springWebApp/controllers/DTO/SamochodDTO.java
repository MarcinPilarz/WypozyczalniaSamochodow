package pl.opole.uni.springWebApp.controllers.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record SamochodDTO(
		
		
		
	@NotNull(message="IdSamochodu nie może być pusta")	Long id, 
	
		
	@NotBlank(message="CenaSamochodu nie może być pusta")double cenaSamochodu,
		
		boolean czyWypozyczony,
		
	@NotNull(message = "NazwaModelu nie może być pusta ")	String nazwaModelu, 
		
		String adresOddzial,
		
		@NotBlank(message="NazwaMarka nie może być pusta")	String nazwaMarka) {


}
