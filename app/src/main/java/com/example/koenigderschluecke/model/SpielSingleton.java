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
public class SpielSingleton implements Spiel {
    private static Spiel instance;
    private List<Spieler> spielerListe;
    private List<Karte> kartenstapel;
    private int anzahlGezogenerKarten;
    private int gezogeneKoenige;
    private int aktuellerSpielerIndex;
    private Karte aktuelleKarte;

    /**
     * Diese Methode liefert eine Instanz des Spiels zurück. Wenn noch keine Instanz existiert,
     * wird eine neue erstellt.
     *
     * @return Eine Instanz des Spiels.
     */
    public static Spiel getSpielInstance(String regelSet, List<Spieler> spielerListe) {
        if (SpielSingleton.instance == null) {
            SpielSingleton.instance = new SpielSingleton(regelSet, spielerListe);
        }
        return SpielSingleton.instance;
    }

    /**
     * Diese Methode liefert eine Instanz des Spiels zurück. Ohne eine neue zu erstellen.
     *
     * @return Eine Instanz des Spiels.
     * @throws Exception Wenn keine Instanz existiert.
     */
    public static Spiel getInstanceOhneErstellen() throws Exception {
        if (SpielSingleton.instance == null) {
            throw new Exception(); //TODO: Exception verbessern
        }

        return SpielSingleton.instance;
    }

    /**
     * Diese Methode löscht die Instanz des Spiels.
     */
    public static void deleteInstance() {
        SpielSingleton.instance = null;
    }

    /**
     * Konstruktor für das Kings Cup Spiel.
     * Initialisiert die Spielerliste, den Kartenstapel und setzt die aktuelle Runde
     * sowie die Anzahl der gezogenen Könige auf ihren Anfangswert.
     */
    private SpielSingleton(String regelSet, List<Spieler> spielerListe) {
        this.spielerListe = spielerListe;
        this.anzahlGezogenerKarten = 0;
        this.gezogeneKoenige = 0;
        this.aktuellerSpielerIndex = 0;
        initialisiereKartenstapelMitBestimmtenRegelSet(regelSet);
    }

    /**
     * Dient ausschließlich zu Testzwecken, sollte nach dem testen entfernt werden!
     * @param instance Die Instanz des Spiels, die gesetzt werden soll.
     */
    public static void setInstance(Spiel instance) {
        SpielSingleton.instance = instance;
    }

    /**
     * Diese Methode liefert die Instanz des Spiels zurück. Sie dient dem Testen!
     * @return Die Instanz des Spiels.
     */
    public static Spiel getInstance() {
        return instance;
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
    public Karte getAktuelleKarte() {
        return aktuelleKarte;
    }

    @Override
    public void setAktuelleKarte(Karte aktuelleKarte) {
        this.aktuelleKarte = aktuelleKarte;
    }

    @Override
    public int getAnzahlGezogenerKarten() {
        return anzahlGezogenerKarten;
    }

    @Override
    public void setAnzahlGezogenerKarten(int aktuelleRunde) {
        this.anzahlGezogenerKarten = aktuelleRunde;
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

    //TODO: Abstract-Fabric Muster?
    @Override
    public void initialisiereKartenstapelMitBestimmtenRegelSet(String regelSet) throws IllegalArgumentException {
        switch (regelSet) {
            case "RauschRitter" -> this.kartenstapel = initialisiereKartenstapelRauschRitter();
            case "Hopfenhacker" -> this.kartenstapel = initialisiereKartenstapelHopfenhacker();
            case "KuebelKoenig" -> this.kartenstapel = initialisiereKartenstapelKuebelKoenig();
            default -> throw new IllegalArgumentException("Regelset nicht gefunden.");
        }

    }

    private List<Karte> initialisiereKartenstapelRauschRitter() {
        List<Karte> stapel = new ArrayList<>();
        for (Kartensymbol symbol : Kartensymbol.values()) {
            for (RauschRitter wert : RauschRitter.values()) {
                stapel.add(new KarteImpl(wert, symbol));
            }
        }
        Collections.shuffle(stapel); // Mischen des Kartenstapels
        return stapel;
    }

    private List<Karte> initialisiereKartenstapelHopfenhacker() {
        List<Karte> stapel = new ArrayList<>();
        for (Kartensymbol symbol : Kartensymbol.values()) {
            for (Hopfenhacker wert : Hopfenhacker.values()) {
                stapel.add(new KarteImpl(wert, symbol));
            }
        }
        Collections.shuffle(stapel); // Mischen des Kartenstapels
        return stapel;
    }

    private List<Karte> initialisiereKartenstapelKuebelKoenig() {
        List<Karte> stapel = new ArrayList<>();
        for (Kartensymbol symbol : Kartensymbol.values()) {
            for (KuebelKoenig wert : KuebelKoenig.values()) {
                stapel.add(new KarteImpl(wert, symbol));
            }
        }
        Collections.shuffle(stapel); // Mischen des Kartenstapels
        return stapel;
    }
}
