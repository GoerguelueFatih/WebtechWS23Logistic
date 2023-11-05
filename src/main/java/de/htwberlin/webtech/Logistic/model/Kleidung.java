package de.htwberlin.webtech.Logistic.model;

import jakarta.persistence.*;

@Entity
public class Kleidung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column (name = "Kleidung")
    private String Kleidung;


    public Kleidung(Long id, String kleidung) {
        this.id = id;
        Kleidung = kleidung;
    }

    protected Kleidung(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKleidung() {
        return Kleidung;
    }

    public void setKleidung(String kleidung) {
        Kleidung = kleidung;
    }
}
