package be.ehb.klassen;

import java.time.LocalDate;

/**
 * @author Walid Oumass
 * Klasse die een passagier vertegenwoordigt in het systeem
 */

public class Passagier extends Persoon{

    public Passagier(String naam, String achternaam, String rijkregisternummer, LocalDate geboortedatum) {
        super(naam, achternaam, rijkregisternummer, geboortedatum);
    }
}
