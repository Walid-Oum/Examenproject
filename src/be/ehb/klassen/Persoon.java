package be.ehb.klassen;

import java.time.LocalDate;

/**
 * @author Walid Oumass
 * Abstracte klasse voor een persoon
 * Wordt gebruikt als basis voor passagiers en personeelsleden
 */

public abstract class Persoon {

    private final String naam, achternaam, rijkregisternummer;
    private final LocalDate geboortedatum;

    public Persoon(String naam, String achternaam, String rijkregisternummer, LocalDate geboortedatum) {
        this.naam = naam;
        this.achternaam = achternaam;
        this.rijkregisternummer = rijkregisternummer;
        this.geboortedatum = geboortedatum;
    }


    public String getRijkregisternummer() {
        return rijkregisternummer;
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }


    public String getNaam() {
        return naam;
    }


    public String getAchternaam() {
        return achternaam;
    }

    @Override
    public String toString() {
        return "Persoon{" +
                "naam='" + naam + '\'' +
                ", achternaam='" + achternaam + '\'' +
                ", rijkregisternummer='" + rijkregisternummer + '\'' +
                ", geboortedatum=" + geboortedatum +
                '}';
    }


}
