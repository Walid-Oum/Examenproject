package be.ehb.klassen;

import be.ehb.enums.Certificatie;
import be.ehb.enums.Personeelsrol;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Walid Oumass
 * Klasse die een personeelslid vertegenwoordigt
 * Kunnen verschillende rollen hebben, zoals bestuurder, steward, etc.
 */

public class Personeelslid extends Persoon {
    private Personeelsrol personeelsrol;
    private HashSet<Certificatie>  certificaties;


    public Personeelslid(String naam, String achternaam, String rijkregisternummer, LocalDate geboortedatum, Personeelsrol personeelsrol) {
        super(naam, achternaam, rijkregisternummer, geboortedatum);
        this.personeelsrol = personeelsrol;
        this.certificaties = new HashSet<>();
    }


    /**
     * Voegt een certificatie toe aan de certificaties van een personeelslid
     * @param certificatie certificaat dat we toevoegen
     */

    public void addCertificatie(Certificatie certificatie){
        certificaties.add(certificatie);
    }

    /**
     * Verwijdert een gegeven certificatie van de set certificaties van een personeelslid
     * @param certificatie het certificaat dat verwijderd wordt
     */

    public void removeCertificatie(Certificatie certificatie){
        certificaties.remove(certificatie);
    }


    /**
     * Methode om de verschillende certificaties te printen
     */

    public void printCertificaties(){
        for(Certificatie c: certificaties){
            System.out.println(c);
        }
    }
    public Set<Certificatie> getCertificaties() {
        return Set.copyOf(certificaties);
    }

    public Personeelsrol getPersoneelsrol() {
        return personeelsrol;
    }


}
