package be.ehb.klassen;

import be.ehb.enums.Klasse;

/**
 * Deze klasse vertegenwoordigt een wagon in een trein
 * Elke wagon heeft een klasse die bepaalt welke klasse ticket je nodig hebt om erin te kunnen boarden
 */

public class Wagon {
    private final Klasse klasse;


    public Wagon(Klasse klasse) {
        this.klasse = klasse;
    }

    public Klasse getKlasse() {
        return klasse;
    }


}
