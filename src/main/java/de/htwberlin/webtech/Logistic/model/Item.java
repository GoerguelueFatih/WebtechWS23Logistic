package de.htwberlin.webtech.Logistic.model;

import jakarta.persistence.*;

@Entity(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "abteilung")
    private Long abteilung;

    @Column(name = "anzahl")
    private Long anzahl;

    @Column(name = "name")
    private String name;

    public Item(Long abteilung, Long anzahl, String name) {
        this.abteilung = abteilung;
        this.anzahl = anzahl;
        this.name = name;
    }

    protected Item(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(Long abteilung) {
        this.abteilung = abteilung;
    }

    public Long getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(Long anzahl) {
        this.anzahl = anzahl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}