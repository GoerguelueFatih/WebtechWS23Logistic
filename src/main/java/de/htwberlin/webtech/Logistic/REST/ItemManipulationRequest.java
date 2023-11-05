package de.htwberlin.webtech.Logistic.REST;

public class ItemManipulationRequest {

    private Long abteilung;
    private Long anzahl;
    private String name;

    public ItemManipulationRequest(Long abteilung, Long anzahl, String name) {
        this.abteilung = abteilung;
        this.anzahl = anzahl;
        this.name = name;
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
