package pl.opole.uni.springWebApp.models;

public class BladAtrybutu {

	 private String atrybut;
	    private String wiadomosc;

	    public BladAtrybutu(String atrybut, String wiadomosc) {
	        this.atrybut = atrybut;
	        this.wiadomosc = wiadomosc;
	    }

	    public String getAtrybut() {
	        return atrybut;
	    }

	    public void setAtrybut(String atrybut) {
	        this.atrybut = atrybut;
	    }

	    public String getWiadomosc() {
	        return wiadomosc;
	    }

	    public void setWiadomosc(String wiadomosc) {
	        this.wiadomosc = wiadomosc;
	    }
}
