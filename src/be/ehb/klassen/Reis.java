package be.ehb.klassen;

import be.ehb.enums.Klasse;
import be.ehb.enums.Personeelsrol;
import be.ehb.enums.Station;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/**
 * @author Walid Oumass
 * Klasse die een reis vertegenwoordigt
 */

public class Reis {

    private Trein trein = null;
    private Station vertrekpunt, eindpunt;
    private LocalDateTime vertrek, aankomst;

    private HashSet<Personeelslid> bestuurders;
    private HashSet<Personeelslid> stewards;

    private ArrayList<Ticket> tickets;



    public Reis(Station vertrekpunt, Station eindpunt, LocalDateTime vertrek, LocalDateTime aankomst) {
        this.vertrekpunt = vertrekpunt;
        this.eindpunt = eindpunt;
        this.vertrek = vertrek;
        this.aankomst = aankomst;


        this.tickets = new ArrayList<>();
        this.bestuurders = new HashSet<>();
        this.stewards = new HashSet<>();


    }

    /**
     * Voegt een bestuurder aan de reis
     * @param bestuurder
     */
    public void voegBestuurder(Personeelslid bestuurder){
        if(bestuurder.getPersoneelsrol() == Personeelsrol.BESTUURDER){
            this.bestuurders.add(bestuurder);
        }
        else{
            throw new IllegalArgumentException("Geen bestuurder");
        }
    }

    /**
     * Voegt een steward toe aan de reis
     * @param steward
     * @throws IllegalArgumentException als ons personeelslid geen steward is
     */

    public void voegSteward(Personeelslid steward){
        if(steward.getPersoneelsrol() == Personeelsrol.STEWARD){
            this.stewards.add(steward);
        }
        else{
            throw new IllegalArgumentException("Geen steward");
        }
    }


    /**
     * Koppelt een trein aan de reis
     * @param trein trein die reist van de ene station naar de andere
     * @throws IllegalArgumentException als trein null is
     * @throws IllegalStateException als de trein al bezet is of als de trein al gekoppeld is aan de reis
     */
    public void koppelTrein(Trein trein){
        if(trein == null){
            throw new IllegalArgumentException("Trein mag niet null zijn");
        }

        else if(trein.isBezet()){
            throw new IllegalStateException("Trein al bezet voor een Reis");
        }
        else if(this.trein != null){
            throw new IllegalStateException("Reis heeft al een trein");
        }

        else {
            this.trein = trein;
            trein.setBezet(true);
        }

    }


    /**
     * @return true als er minstens 1 bestuurder en 3 stewards in de staff zitten
     */
    public boolean isReadyCrew(){
        return(!(this.bestuurders.isEmpty()) && this.stewards.size() >= 3);

    }


    /**
     * Berekent het aantal vrije plaatsen voor een bepaalde klasse
     * @param klasse Klasse waarvoor je het aantal vrije plaatsen berekent
     * @return het aantal vrije plaatsen voor die klasse
     * @throws IllegalStateException als er nog geen trein gekoppeld is aan de reis
     */

    public int vrijePlaatsenKlasse(Klasse klasse){
        if(!(this.heeftTrein())){
            throw new IllegalStateException("Nog geen trein gekoppeld aan reis");
        }



        int capaciteit = trein.capaciteitVoorKlasse(klasse);
        int verkochteTickets = 0;

        for(Ticket verkochteTicket: tickets){
            if (verkochteTicket.getKlasse() == klasse){
                verkochteTickets++;
            }
        }
        int overigeTickets = capaciteit - verkochteTickets;
        return overigeTickets;

    }


    /**
     * Methode die een nieuw ticket verkoopt aan een passagier
     * @param klasse klasse van het ticket
     * @param passagier passagier die het ticket koopt
     */

    public void verkoopTicket(Klasse klasse, Passagier passagier){

        if(klasse == null){
            throw new IllegalArgumentException("Klasse is niet valid"); }
        if(passagier == null){
            throw new IllegalArgumentException("Passagier bestaat niet");
        }


        int overigeTickets = vrijePlaatsenKlasse(klasse);



        if(overigeTickets > 0){
            Ticket nieuwTicket = new Ticket(passagier, klasse, this);
            tickets.add(nieuwTicket);

        }
        else{
            throw new IllegalStateException("Geen tickets voor " + klasse + " klasse");

        }

    }
    //getters voor het overschrijven in aparte file
    public Station getVertrekpunt() {
        return vertrekpunt;
    }

    public Station getEindpunt() {
        return eindpunt;
    }

    public LocalDateTime getVertrek() {
        return vertrek;
    }

    public LocalDateTime getAankomst() {
        return aankomst;
    }

    public List<Ticket> getTickets() {
        return List.copyOf(tickets);
    }

    //check om te vermeiden dat trein null is.
    public boolean heeftTrein(){
        return trein != null;
    }

    public Trein getTrein(){
        return trein;
    }

    /**
     * Methode die informatie over een reis (zoals de passagiers, Stations, vertrek, etc.) wegschrijft naar een .txt file
     * @throws IOException Wanneer er iets mis is gegaan bij het wegschrijft naar een .txt file
     */
    public void schrijfBoardinglijstNaarBestand() throws IOException {



        String fileName = vertrekpunt.name().charAt(0) + vertrekpunt.name().substring(1).toLowerCase() +  "_" + eindpunt.name().charAt(0) + eindpunt.name().substring(1).toLowerCase()+ "_" + vertrek;
        try(FileWriter output = new FileWriter(fileName+".txt")){
            //beschrijving van reis
            output.write("Boarding lijst\n");
            output.write(vertrekpunt + " => " + eindpunt);
            output.write("\nVertrek: " + vertrek + "\n");

            //details van de passagiers

            for(Ticket t: tickets){
                Passagier passagier = t.getPassagier();
                output.write(passagier.getNaam() + " " + passagier.getAchternaam() + "\nrijkregisternummer: " + passagier.getRijkregisternummer() + "\ngeboortedatum: " + passagier.getGeboortedatum() + "\nklasse: " + t.getKlasse() + "\n");
                output.write("\n ********* \n");

            }
        }
    }
}
