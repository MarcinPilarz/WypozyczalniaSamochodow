package pl.opole.uni.springWebApp.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ubezpieczenia")
public class Ubezpieczenie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "typ")
    private String typ;

    @Column(name = "cena")
    private BigDecimal cena;

    @ManyToMany(mappedBy = "ubezpieczenia")
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

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public List<Samochod> getSamochody() {
        return samochody;
    }

    public void setSamochody(List<Samochod> samochody) {
        this.samochody = samochody;
    }
}