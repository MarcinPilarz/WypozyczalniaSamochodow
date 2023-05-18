package pl.opole.uni.springWebApp.controllers.DTO;

public record PostDTO(
		int pojemnoscBaterii,
		String ilosc_Drzwi, 
		String kolor_samochodu, 
		int moc_silnika,int rokProdukcji, 
		double cenaSamochodu,
		boolean czyWypozyczony ) {

}
