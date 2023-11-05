package de.htwberlin.webtech.Logistic.model;

import jakarta.persistence.*;

@Entity
public class Kleidung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column (name = "kleidung")
    private String kleidung;


    public Kleidung(Long id, String kleidung) {
        this.id = id;
        kleidung = kleidung;
    }

    protected Kleidung(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKleidung() {
        return kleidung;
    }

    public void setKleidung(String kleidung) {
        kleidung = kleidung;
    }
}
