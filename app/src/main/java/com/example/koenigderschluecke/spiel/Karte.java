package com.example.koenigderschluecke.spiel;

/**
 * Die Klasse Karte stellt eine Karte dar.
 */
public class Karte {

    private FarbeDerKarte farbe;
    private RangDerKarte rang;

    /**
     * Konstruktor der Klasse Karte.
     *
     * @param farbe Die farbe der Karte (Herz, Karo, Pik oder Kreuz)
     * @param rang Der Rang der Karte (2, 3, 4, 5, 6, 7, 8, 9, 10, Bube, Dame, König, Ass)
     */
    public Karte(FarbeDerKarte farbe, RangDerKarte rang) {
        this.farbe = farbe;
        this.rang = rang;
    }

    public FarbeDerKarte getFarbe() {
        return farbe;
    }

    public RangDerKarte getRang() {
        return rang;
    }

    @Override
    public String toString() {
        return getFarbe().toString() + " " + getRang().toString();
    }
}
