package be.ehb.enums;


/**
 * @author Walid Oumass
 * Type locomotief dat bepaalt hoeveel wagons een trein maximaal kan hebben
 */

public enum Locomotief {



    C373(12),
    C374(14);

    private final int maxAantalWagons;


    Locomotief(int maxAantalWagons) {
        this.maxAantalWagons = maxAantalWagons;
    }

    public int getMaxAantalWagons() {
        return maxAantalWagons;
    }
}
