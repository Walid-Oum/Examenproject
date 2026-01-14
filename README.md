# Euromoon Examenproject

## Projectbeschrijving
Dit project is een examenopdracht voor het vak Programming Advanced. Het betreft een simulatie voor het **Euromoon** systeem, dat wordt gebruikt door **baliemedewerkers** en **dispatchers** van het bedrijf Euromoon. De applicatie stelt hen in staat om passagiers te registreren, reizen aan te maken, treinen aan reizen te koppelen, tickets te verkopen en boardinglijsten af te drukken.

## Doel van de applicatie
De applicatie richt zich op het eenvoudig beheren van treinen, reizen en passagiers. Door een menu te presenteren, kunnen medewerkers taken uitvoeren zoals het registreren van passagiers, het creëren van reizen, het koppelen van treinen aan deze reizen, en het verkopen van tickets.

## Gebruikers
- **Baliemedewerkers**: Zij kunnen passagiers registreren, reizen aanmaken, en tickets verkopen.
- **Dispatchers**: Zij kunnen reizen koppelen aan treinen en boardinglijsten afdrukken.

## Functionaliteiten
- **Passagier registreren**: Gebruikers kunnen nieuwe passagiers registreren met hun gegevens, zodat ze later tickets kunnen kopen.
- **Reis aanmaken**: Gebruikers kunnen een reis aanmaken door vertrek- en eindstations in te voeren, evenals vertrek- en aankomsttijden.
- **Trein koppelen aan reis**: Na het aanmaken van een reis kan een beschikbare trein gekoppeld worden.
- **Ticketverkoop**: Gebruikers kunnen tickets verkopen aan passagiers op basis van hun voorkeur voor de klasse.
- **Boardinglijst afdrukken**: Een lijst van passagiers wordt geëxporteerd naar een `.txt` bestand.

## Installatie
1. Clone de repository naar je lokale machine:
    ```bash
    git clone https://github.com/Walid-Oum/Examenproject.git
    ```
2. Zorg ervoor dat je **Java 17** of hoger hebt geïnstalleerd.
3. Gebruik **Maven** of **Gradle** om de applicatie te builden en te runnen, afhankelijk van het gebruikte projectbeheer.

## Vereisten
- Java SDK (Temurin 23)
- Een IDE zoals IntelliJ IDEA of Eclipse

## Hulpmiddelen / ondersteuning
- **ChatGPT**: gebruikt voor **code feedback** en voor het idee om in `Menu` **voorbeelddata** te initialiseren (vaste treinen + personeelsleden), zodat de gebruiker dit niet manueel moet aanmaken.
    - In `Menu` worden dus automatisch treinen + personeelsleden toegevoegd.
    - Bij het aanmaken van een reis wordt er automatisch crew gekoppeld als er minstens **1 bestuurder** en **3 stewards** beschikbaar zijn.
- **DeepL**: gebruikt om enkele **taalfouten** te verbeteren.

## Auteur
- **Walid Oumass**: Alle code is door mijzelf geschreven en ik werk alleen aan dit project.

## License
Dit project is gelicenseerd onder de MIT License - zie de [LICENSE](LICENSE) file voor details.
