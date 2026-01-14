package be.ehb.klassen;

import be.ehb.enums.Klasse;
import be.ehb.enums.Locomotief;

import java.util.ArrayList;


/**
 * Deze klasse vertegenwoordigt een trein. Een trein bestaat uit een locomotief en een aantal wagons
 */


public class Trein {
    private Locomotief locomotief;
    private ArrayList<Wagon> wagons;
    private boolean isBezet;


    public Trein(Locomotief locomotief) {
        this.locomotief = locomotief;
        this.wagons = new ArrayList<>();
        this.isBezet = false;
    }


    /**
     *Controleert of een trein al bezet is voor een reis
     * @return boolean: true als bezet, anders false
     */

    public boolean isBezet() {
        return isBezet;
    }

    public void setBezet(boolean bezet) {
        isBezet = bezet;
    }

    public Locomotief getLocomotief() {
        return locomotief;
    }

    /**
     * Methode om wagons te toevoegen aan de lijst van wagons indien we er nog kunnen toevoegen
     * @param wagon die we toevoegen aan de lijst van wagons die behoort tot ons trein
     */

    public void addWagon(Wagon wagon){
        if(wagon == null){
            throw new IllegalArgumentException("Wagon mag niet null zijn");
        }
        else if(this.locomotief.getMaxAantalWagons() > wagons.size()){
            this.wagons.add(wagon);}
        else {
            throw new IllegalStateException("Max aantal wagons bereikt");
        }
    }


    /**
     * Methode die, gegeven een klasse, berekent hoeveel plaats we hebben in de wagons van die klasse
     * @param klasse De klasse waarvoor we het aantal plaatsen willen berekenen
     * @return Het totale aantal plaats voor een klasse
     */
    public int capaciteitVoorKlasse(Klasse klasse){
        int totaal = 0;
        for(Wagon wagon: wagons){
            if (wagon.getKlasse() == klasse){
                totaal += 80;
            }
        }
        return totaal;

    }





}
