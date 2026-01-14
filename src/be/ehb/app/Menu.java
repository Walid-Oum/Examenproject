package be.ehb.app;

import be.ehb.enums.Klasse;
import be.ehb.enums.Locomotief;
import be.ehb.enums.Personeelsrol;
import be.ehb.enums.Station;
import be.ehb.klassen.*;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {


    public Menu() {
        initTreinen();
        initPersoneel();

    }

    private ArrayList<Passagier> passagiers = new ArrayList<>();
    private ArrayList<Reis> euromoonReizen = new ArrayList<>();
    private ArrayList<Trein> euromoonTreinen = new ArrayList<>();
    private ArrayList<Personeelslid> personeel = new ArrayList<>();


    private Scanner scanner = new Scanner(System.in);



    /**
     * Voegt voorbeeldtreinen toe aan de lijst van beschikbare treinen
     */
    private void initTreinen() {
        euromoonTreinen.add(maakTreinC373());
        euromoonTreinen.add(maakTreinC373());
        euromoonTreinen.add(maakTreinC373());

        euromoonTreinen.add(maakTreinC374());
        euromoonTreinen.add(maakTreinC374());
    }

    /**
     * Methode die een aantal treinen met een C373 locomotief aanmaakt
     * @return trein
     */
    private Trein maakTreinC373() {
        Trein t = new Trein(Locomotief.C373);
        for (int i = 0; i < 4; i++) t.addWagon(new Wagon(Klasse.EERSTE));
        for (int i = 0; i < 8; i++) t.addWagon(new Wagon(Klasse.TWEEDE));
        return t;
    }


    /**
     * Methode die een aantal treinen met een C374 locomotief aanmaakt
     * @return trein
     */

    private Trein maakTreinC374() {
        Trein t = new Trein(Locomotief.C374);
        for (int i = 0; i < 5; i++) t.addWagon(new Wagon(Klasse.EERSTE));
        for (int i = 0; i < 9; i++) t.addWagon(new Wagon(Klasse.TWEEDE));
        return t;
    }

    /**
     * Initisaliseert ons pesoneel met een anantal personeelsleden
     */

    private void initPersoneel() {
        personeel.add(new Personeelslid("Ali", "B.", "900", LocalDate.of(1990, 1, 1), Personeelsrol.BESTUURDER));
        personeel.add(new Personeelslid("Sara", "K.", "901", LocalDate.of(1988, 2, 2), Personeelsrol.BESTUURDER));

        personeel.add(new Personeelslid("Nina", "S.", "910", LocalDate.of(1995, 3, 3), Personeelsrol.STEWARD));
        personeel.add(new Personeelslid("Tom", "D.", "911", LocalDate.of(1994, 4, 4), Personeelsrol.STEWARD));
        personeel.add(new Personeelslid("Lina", "M.", "912", LocalDate.of(1996, 5, 5), Personeelsrol.STEWARD));
        personeel.add(new Personeelslid("Omar", "H.", "913", LocalDate.of(1993, 6, 6), Personeelsrol.STEWARD));
    }


    /**
     * Methode die een bestuurder meoet vinden in ons lijst personeel
     * @return eerste bestuurder dat gevonden wordt in de lijst
     */

    private Personeelslid vindBestuurder() {
        for (Personeelslid p : personeel) {
            if (p.getPersoneelsrol() == Personeelsrol.BESTUURDER) return p;
        }
        return null;
    }



    /**
     * Methode die een aantal n stewards meoet vinden in ons lijst personeel
     * @return sublijst stewards dat gevonden wordt in de lijst
     */
    private ArrayList<Personeelslid> vindStewards(int n) {
        ArrayList<Personeelslid> res = new ArrayList<>();
        for (Personeelslid p : personeel) {
            if (p.getPersoneelsrol() == Personeelsrol.STEWARD) {
                res.add(p);
                if (res.size() == n) return res;
            }
        }
        return res;
    }


    /**
     * Methode om het menu te tonen aan de gebruiker
     */

    public void toonMenu() {
        System.out.println("MENU-Euromoon" + "\n 1.Passagier registreren\n 2.Reis aanmaken\n 3.Koppel trein aan reis\n 4.Ticket aankopen \n 5.Boardinglijst afdrukken \n6.STOP");
    }


    /**
     *Methode om een datum te maken op basis van userinput
     * @return door de gebruiker gemaakte LocalDate
     * @throws NumberFormatException als gebruiker letters gebruikt in plaats van getallen
     * @throws DateTimeException als een slecht datumformaat gebruikt wordt
     */

    public LocalDate nextDatum() {
        while (true) {
            try {
                System.out.println("Dag: ");
                String geboortedag = scanner.nextLine();


                System.out.println("Maand: ");
                String geboortemaand = scanner.nextLine();

                System.out.println("Jaar: ");
                String geboortejaar = scanner.nextLine();

                int dag = Integer.parseInt(geboortedag);
                int maand = Integer.parseInt(geboortemaand);
                int jaar = Integer.parseInt(geboortejaar);
                return LocalDate.of(jaar, maand, dag);
            } catch (NumberFormatException e) {
                System.out.println("Gebruik enkel getallen");
                ;
            } catch (DateTimeException e) {
                System.out.println("Ongeldige datumformaat (dag: 1-29/31, maand: 1-12; jaar: bv. 2010)");
            }
        }

    }




    /**
     *Methode om een tijdstip te maken op basis van userinput
     * @return door de gebruiker gemaakte LocalTime
     * @throws NumberFormatException als gebruiker letters gebruikt in plaats van getallen
     * @throws DateTimeException als een slecht formaat gebruikt wordt
     */

    public LocalTime nextTijdstip() {

        while (true) {
            try {

                System.out.println("Uur: ");
                String uur = scanner.nextLine();


                System.out.println("Minuten: ");
                String minuten = scanner.nextLine();


                int u = Integer.parseInt(uur);
                int m = Integer.parseInt(minuten);
                return LocalTime.of(u, m);
            } catch (NumberFormatException e) {
                System.out.println("Gebruik enkel getallen");
            } catch (DateTimeException e) {
                System.out.println("Ongeldige tijdsformaat (uur: 0-23, minuten: 0-59)");
            }

        }

    }

    /**
     * Methode om een station te laten kiezen door gebruiker op een veilige manier
     * @return een door de gebruiker gekozen station
     * @throws NumberFormatException als gebruiker letters gebruikt in plaats van getallen
     */
    public Station nextStation() {
        Station[] stations = Station.values();
        //eerst keuzes tonen
        for (int i = 0; i < stations.length; i++) {
            System.out.println((i + 1) + ". " + stations[i]);
        }

        //gebruiker laten kiezen;

        while (true) {

            try {
                int keuze;
                do {
                    System.out.println("keuze (" + 1 + "-" + stations.length + "): ");
                    keuze = Integer.parseInt(scanner.nextLine());

                    if (keuze < 1 || keuze > stations.length) {
                        System.out.println("Foutieve keuze, kies een getal tussen 1 en " + stations.length);
                    }

                } while (keuze < 1 || keuze > stations.length);

                return stations[keuze - 1];
            } catch (NumberFormatException e) {
                System.out.println("Gebruik enkel getallen");
            }
        }
    }


    /**
     * Methode die de vrije treinen weergeeft, en de gebruiker er 1 laat kiezen om bijvoorbeeld een trein te koppelen aan een reis
     * @return een door de gebruiker gekozen trein
     * @throws NumberFormatException als gebruiker letters gebruikt in plaats van getallen
     */

    public Trein nextVrijeTrein() {

        //de vrije treinen halen
        ArrayList<Trein> vrijeTreinen = new ArrayList<>();
        int counter = 1;

        for (Trein t : euromoonTreinen) {
            if (!t.isBezet()) {
                vrijeTreinen.add(t);
                System.out.println(counter + "." + t.getLocomotief());
                counter++;
            }
        }
        if (euromoonTreinen.isEmpty() || vrijeTreinen.isEmpty()) {
            return null;
        }
        while (true) {
            try {
                int keuze;
                do {
                    System.out.println("Kies trein (1-" + vrijeTreinen.size() + "): ");
                    keuze = Integer.parseInt(scanner.nextLine());

                    if (keuze < 1 || keuze > vrijeTreinen.size()) {
                        System.out.println("foutieve keuze, kies een getal tussen 1 en " + vrijeTreinen.size());
                    }
                } while (keuze < 1 || keuze > vrijeTreinen.size());
                return vrijeTreinen.get(keuze - 1);
            } catch (NumberFormatException e) {
                System.out.println("Gebruik enkel getallen");
            }
        }
    }

    /**
     * Methode die een reis aanmaakt op een veilig manier
     * @return een nieuw gemaakte reis
     * @throws NumberFormatException als gebruiker letters gebruikt in plaats van getallen
     */

    public Reis nextReis() {

        if (euromoonReizen.isEmpty()) {

            return null;

        }
        int counter = 1;
        for (Reis reis : euromoonReizen) {
            System.out.println(counter + "." + reis.getVertrekpunt().name().charAt(0) + reis.getVertrekpunt().name().substring(1).toLowerCase() + "=>" + reis.getEindpunt().name().charAt(0) + reis.getEindpunt().name().substring(1).toLowerCase());
            counter++;
        }

        while (true) {
            try {


                System.out.println("Kies reis (1-" + euromoonReizen.size() + "): ");
                int keuze;
                do {
                    keuze = Integer.parseInt(scanner.nextLine());
                    if (keuze < 1 || keuze > euromoonReizen.size()) {
                        System.out.println("Foutieve keuze, kies een getal tussen 1 en " + euromoonReizen.size());
                    }
                } while (keuze < 1 || keuze > euromoonReizen.size());
                return euromoonReizen.get(keuze - 1);
            } catch (NumberFormatException e) {
                System.out.println("Gebruik enkel getallen");
            }
        }
    }


    /**
     * Methode om een nieuwe klasse (eerste klasse of tweede klasse) aanmaakt
     * @return nieuwe klasse
     * @throws NumberFormatException als de user letters gebruikt in plaats van een getal voor zijn keuze
     */

    public Klasse nextKlasse() {
        Klasse[] klasses = Klasse.values();
        int counter = 1;
        for (Klasse k : klasses) {
            System.out.println(counter + ". " + k.name().charAt(0) + k.name().substring(1).toLowerCase());
            counter++;

        }

        while (true) {
            try {
                int keuze;
                do {
                    System.out.println("Kies een klasse (1-" + klasses.length + ")");
                    keuze = Integer.parseInt(scanner.nextLine());
                    if (keuze < 1 || keuze > klasses.length) {
                        System.out.println("Foutieve keuze, kies een getal tussen 1 en " + klasses.length);
                    }
                } while (keuze < 1 || keuze > klasses.length);
                return klasses[keuze - 1];
            } catch (NumberFormatException e) {
                System.out.println("Gebruik enkel getallen");
            }
        }
    }

    /**
     * Methode om een passagier te maken met gegevens gegeven door de gebruiker
     * @return een nieuwe passagier
     * @throws NumberFormatException als gebruiker letters gebruikt in plaats van getallen
     */

    public Passagier nextPassagier() {
        if (passagiers.isEmpty()) {
            return null;
        }
        int counter = 1;
        for (Passagier passagier : passagiers) {
            System.out.println(counter + "." + passagier.getNaam() + " " + passagier.getAchternaam());
            counter++;
        }
        while (true) {
            try {
                int keuze;
                do {
                    System.out.println("Kies een passagier (1-" + passagiers.size() + "): ");
                    keuze = Integer.parseInt(scanner.nextLine());
                    if (keuze < 1 || keuze > passagiers.size()) {
                        System.out.println("Foutieve keuze, kies een getal tussen 1 en " + passagiers.size());
                    }
                } while (keuze < 1 || keuze > passagiers.size());
                return passagiers.get(keuze - 1);
            } catch (NumberFormatException e) {
                System.out.println("Gebruik enkel getallen");
            }
        }
    }

    /**
     * Methode die een passagier aanmaakt met de gegevens van de gebruiker, en die toevoegd aan de lijst van onze passagiers
     */
    public void registreerPassagier() {

        System.out.println("Naam: ");
        String naam = scanner.nextLine();
        System.out.println("Achternaam: ");
        String achternaam = scanner.nextLine();

        System.out.println("rijkregisternummer: ");
        String rijkregisternummer = scanner.nextLine();


        System.out.println("Geboortedatum\n");

        LocalDate geboortedatum = nextDatum();
        Passagier nieuwPassagier = new Passagier(naam, achternaam, rijkregisternummer, geboortedatum);
        passagiers.add(nieuwPassagier);
        System.out.println("Welkom " + naam + " " + achternaam);


    }


    /**
     * Methode om een reis te maken, met restricties op gelijkheid van vertrekstation en eindstation
     */
    public void maakReis() {


        System.out.println("Vertrekstation: ");
        Station vertrekstation = nextStation();


        System.out.println("Eindstation: ");
        Station eindstation;
        do {
            eindstation = nextStation();
            if (vertrekstation == eindstation) {
                System.out.println("Vertrekstation en eindstation mogen niet hetzelfde zijn. Kies opnieuw");
            }
        } while (vertrekstation == eindstation);


        System.out.println("Vertrek");
        LocalDate vertrekDatum = nextDatum();
        LocalTime vertrekTijdstip = nextTijdstip();
        LocalDateTime vertrek = LocalDateTime.of(vertrekDatum, vertrekTijdstip);


        System.out.println("Aankomst");
        LocalDate aankomstDatum = nextDatum();
        LocalTime aankomstTijdstip = nextTijdstip();
        LocalDateTime aankomst = LocalDateTime.of(aankomstDatum, aankomstTijdstip);


        Reis nieuwReis = new Reis(vertrekstation, eindstation, vertrek, aankomst);
        euromoonReizen.add(nieuwReis);
        System.out.println("Reis van " + vertrekstation + "=>" + eindstation + " aangemaakt");


        //door chat automatisch gemaakte crew

        Personeelslid bestuurder = vindBestuurder();
        ArrayList<Personeelslid> stewards = vindStewards(3);

        if (bestuurder == null || stewards.size() < 3) {
            System.out.println("Niet genoeg crew beschikbaar.");
        } else {
            nieuwReis.voegBestuurder(bestuurder);
            for (Personeelslid s : stewards) nieuwReis.voegSteward(s);
        }


    }


    /**
     * Methode verantwoordelijk voor het koppelen van een trein aan een reis, na alle checks op valide reizen
     */


    public void koppelTreinAanReis() {

        Reis reis = nextReis();
        if (reis == null) {
            System.out.println("Er zijn geen reizen beschikbaar");
            return;
        }

        Trein trein = nextVrijeTrein();
        if (trein == null) {
            System.out.println("geen vrije trein beschikbaar");
            return;
        }

        reis.koppelTrein(trein);

    }

    /**
     * Methode die eerst checkt of alles klaar is voor een reis, en die dan pas een ticket verkoopt aan de gebruiker
     */
    public void verkoopTicketAanPassagier() {

        Reis reis = nextReis();
        if (reis == null) {
            System.out.println("Geen reis beschikbaar");
            return;
        }
        if (!reis.heeftTrein()) {
            System.out.println("Geen trein voor reis, kies optie 3 om een trein te koppelen aan reis");
            return;
        }

        Passagier passagier = nextPassagier();
        if (passagier == null) {
            System.out.println("Er zijn geen passagiers beschikbaar, druk optie 1 om er een te maken");
            return;
        }

        Klasse klasse = nextKlasse();

        //kan nog een illegalstateexception geven dus catchen


        try {
            reis.verkoopTicket(klasse, passagier);
            System.out.println("Ticket aangekocht");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }


    }


    /**
     * Methode die effectief data van een reis wegschrijft naar een .txt file als de reis bestaat en er tickets als verkocht zijn
     */


    public void drukBoardingLijstAf() {
        Reis reis = nextReis();

        if (reis == null) {
            System.out.println("Geen reis beschikbaar, je kunt er maken via optie 2");
            return;

        }


        if (reis.getTickets().isEmpty()) {
            System.out.println("Nog geen tickets verkocht voor reis");
            return;
        }

        try {
            reis.schrijfBoardinglijstNaarBestand();
            System.out.println("Boardinglijst opgeslagen");
        } catch (IOException e) {
            System.out.println("Kon bestand niet opslaan: " + e.getMessage());
        }


    }


    /**
     * Methode die het hele logica van het Menu voorstelt. Het mapt een keuze van de gebruiker naar de correcte functieoproep
     */

    public void kiesUitMenu() {

        int keuze;

        do {
            toonMenu();
            System.out.println("Kies een optie:");
            keuze = Integer.parseInt(scanner.nextLine());

            switch (keuze) {
                case 1:
                    registreerPassagier();
                    break;
                case 2:
                    maakReis();
                    break;
                case 3:
                    koppelTreinAanReis();
                    break;
                case 4:
                    verkoopTicketAanPassagier();
                    break;
                case 5:
                    drukBoardingLijstAf();
                    break;
                case 6:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Foutieve invoer kies (1-2-3-4-5): ");


            }


        } while (keuze != 6);

    }


}



