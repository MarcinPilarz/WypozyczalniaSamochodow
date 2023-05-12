package pl.opole.uni.springWebApp.models;

import java.math.BigDecimal; 
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ubezpieczenie")
public class Ubezpieczenie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ubezpieczenie")
    private Long id;

    @Column(name = "typ_ubezpieczenie")
    private String typ;

    @Column(name = "cena")
    private Double cena;

    @ManyToMany(fetch=FetchType.LAZY,mappedBy = "ubezpieczenia")
    private List<Samochod> samochody;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public List<Samochod> getSamochody() {
        return samochody;
    }

    public void setSamochody(List<Samochod> samochody) {
        this.samochody = samochody;
    }
}