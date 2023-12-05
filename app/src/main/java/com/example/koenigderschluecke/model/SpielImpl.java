package com.example.koenigderschluecke.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Diese Klasse repräsentiert das Kings Cup Spiel.
 * Sie verwaltet die Spieler*innen, den Kartenstapel und den Zustand des Spiels.
 * <p>
 * Beim Erstellen einer Instanz dieser Klasse wird ein vollständiger Satz von Spielkarten
 * initialisiert und gemischt, und die Spielrunden sowie die gezogenen Könige werden
 * auf den Anfangszustand gesetzt.
 */
public class SpielImpl implements Spiel {

    private List<Spieler> spielerListe;
    private List<Karte> kartenstapel;
    private int aktuelleRunde;
    private int gezogeneKoenige;
    private int aktuellerSpielerIndex;

    /**
     * Konstruktor für das Kings Cup Spiel.
     * Initialisiert die Spielerliste, den Kartenstapel und setzt die aktuelle Runde
     * sowie die Anzahl der gezogenen Könige auf ihren Anfangswert.
     */
    public SpielImpl() {
        this.spielerListe = new ArrayList<>();
        this.kartenstapel = initialisiereKartenstapel();
        this.aktuelleRunde = 0;
        this.gezogeneKoenige = 0;
        this.aktuellerSpielerIndex = 0;
    }

    @Override
    public List<Spieler> getSpielerListe() {
        return spielerListe;
    }

    @Override
    public List<Karte> getKartenstapel() {
        return kartenstapel;
    }

    @Override
    public int getAktuelleRunde() {
        return aktuelleRunde;
    }

    @Override
    public void setAktuelleRunde(int aktuelleRunde) {
        this.aktuelleRunde = aktuelleRunde;
    }

    @Override
    public int getGezogeneKoenige() {
        return gezogeneKoenige;
    }

    @Override
    public void setGezogeneKoenige(int gezogeneKoenige) {
        this.gezogeneKoenige = gezogeneKoenige;
    }

    @Override
    public int getAktuellerSpielerIndex() {
        return aktuellerSpielerIndex;
    }

    @Override
    public void setAktuellerSpielerIndex(int aktuellerSpielerIndex) {
        this.aktuellerSpielerIndex = aktuellerSpielerIndex;
    }

    private List<Karte> initialisiereKartenstapel() {
        List<Karte> stapel = new ArrayList<>();
        for (Kartensymbol symbol : Kartensymbol.values()) {
            for (Kartenwert wert : Kartenwert.values()) {
                stapel.add(new KarteImpl(wert, symbol));
            }
        }
        Collections.shuffle(stapel); // Mischen des Kartenstapels
        return stapel;
    }
}
