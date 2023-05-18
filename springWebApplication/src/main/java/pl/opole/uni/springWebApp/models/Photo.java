package pl.opole.uni.springWebApp.models;

import javax.persistence.*;

@Entity
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nazwa;

    private String sciezka;

    @Lob
    private byte[] zdjecie;

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getSciezka() {
        return sciezka;
    }

    public void setSciezka(String sciezka) {
        this.sciezka = sciezka;
    }

    public byte[] getZdjecie() {
        return zdjecie;
    }

    public void setZdjecie(byte[] zdjecie) {
        this.zdjecie = zdjecie;
    }
}