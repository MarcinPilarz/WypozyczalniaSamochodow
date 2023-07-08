package pl.opole.uni.springWebApp.models; 

import java.util.ArrayList;
import java.util.List;

public class BladOdpowiedz {
	 private String wiadomosc;
	    private List<BladAtrybutu> atrybutyBledow;

	    
	    
	    public BladOdpowiedz(String string, String string2) {
	        this.atrybutyBledow = new ArrayList<>();
	    }

	    public BladOdpowiedz(String wiadomosc) {
	        this.wiadomosc = wiadomosc;
	        this.atrybutyBledow = new ArrayList<>();
	    }

	    public String getWiadomosc() {
	        return wiadomosc;
	    }

	    public void setWiadomosc(String wiadomosc) {
	        this.wiadomosc = wiadomosc;
	    }

	    public List<BladAtrybutu> getFieldErrors() {
	        return atrybutyBledow;
	    }

	    public void setFieldErrors(List<BladAtrybutu> atrybutyBledow) {
	        this.atrybutyBledow = atrybutyBledow;
	    }

	    public void addFieldError(String atrybut, String wiadomosc) {
	        BladAtrybutu bladAtrybutu = new BladAtrybutu(atrybut, wiadomosc);
	        atrybutyBledow.add(bladAtrybutu);
	    }

		public void addValidationError(String field, String defaultMessage) {
			// TODO Auto-generated method stub
			
		}
}
