package com.example.koenigderschluecke.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Diese Klasse repräsentiert das Kings Cup Spiel.
 * Sie verwaltet die Spieler, den Kartenstapel und den Zustand des Spiels.
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
    public void addSpieler(Spieler spieler) {
        spielerListe.add(spieler);
    }

    @Override
    public void entferneSpieler(Spieler spieler) {
        spielerListe.remove(spieler);
    }

    @Override
    public List<Spieler> getSpielerListe() {
        return new ArrayList<>(spielerListe);
    }

    @Override
    public Spieler getAktuellerSpieler() throws IllegalStateException {
        if (spielerListe.isEmpty()) {
            throw new IllegalStateException("Es sind keine Spieler im Spiel.");
        }
        return spielerListe.get(aktuellerSpielerIndex);
    }

    @Override
    public Karte holeNaechsteKarte() throws KartenstapelLeerException {
        if (!kartenstapel.isEmpty()) {
            return kartenstapel.remove(0); // Entfernt und gibt die oberste Karte zurück
        } else {
            throw new KartenstapelLeerException();
        }
    }

    @Override
    public void wechsleZuNaechstemSpieler() {
        if (spielerListe.isEmpty()) {
            throw new IllegalStateException("Es sind keine Spieler im Spiel.");
        }

        //Durch die Verwendung des modulo-Operators wird sichergestellt,
        //dass die Spielerreihenfolge zyklisch ist,
        //also nach dem letzten Spieler wieder beim ersten Spieler fortgesetzt wird.
        aktuellerSpielerIndex = (aktuellerSpielerIndex + 1) % spielerListe.size();
    }

    @Override
    public int getAktuelleRunde() {
        return aktuelleRunde;
    }

    @Override
    public List<Karte> getVerbleibendeKarten() {
        return new ArrayList<>(kartenstapel);
    }

    @Override
    public int getAnzahlGezogenerKoenige() {
        return gezogeneKoenige;
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
