package be.ehb.klassen;

import be.ehb.enums.Klasse;

/**
 * Klasse die een ticket vertegenwoordigt
 */

public class Ticket {

    private Passagier passagier;
    private Klasse klasse;
    private Reis reis;

    public Ticket(Passagier passagier, Klasse klasse, Reis reis) {
        this.passagier = passagier;
        this.klasse = klasse;
        this.reis = reis;
    }

    public Passagier getPassagier() {
        return passagier;
    }

    public Klasse getKlasse() {
        return klasse;
    }


    public Reis getReis() {
        return reis;
    }
}