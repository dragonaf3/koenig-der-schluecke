package com.example.koenigderschluecke.model;

import java.util.List;

/**
 * Dies ist eine Schnittstelle für ein Spiel.
 * Sie definiert die Methoden, welche ein Spiel implementieren muss.
 */
public interface Spiel {

    /**
     * Gibt eine Liste aller Spieler im Spiel zurück.
     *
     * @return Eine Liste der Spieler.
     */
    List<Spieler> getSpielerListe();

    /**
     * Gibt den Kartenstapel des Spiels zurück.
     *
     * @return Eine Liste der Karten.
     */
    List<Karte> getKartenstapel();

    /**
     * Gibt die aktuelle Karte zurück.
     *
     * @return Die aktuelle Karte.
     */
    Karte getAktuelleKarte();

    /**
     * Setzt die aktuelle Karte.
     *
     * @param karte Die neue aktuelle Karte.
     */
    void setAktuelleKarte(Karte karte);

    /**
     * Gibt die Anzahl der gezogenen Karten zurück.
     *
     * @return Die Anzahl der gezogenen Karten als Integer.
     */
    int getAnzahlGezogenerKarten();

    /**
     * Setzt die Anzahl der gezogenen Karten.
     *
     * @param anzahlGezogenerKarten Die neue Anzahl der gezogenen Karten als Integer.
     */
    void setAnzahlGezogenerKarten(int anzahlGezogenerKarten);

    /**
     * Gibt die Anzahl der gezogenen Könige zurück.
     *
     * @return Die Anzahl der gezogenen Könige als Integer.
     */
    int getGezogeneKoenige();

    /**
     * Setzt die Anzahl der gezogenen Könige.
     *
     * @param gezogeneKoenige Die neue Anzahl der gezogenen Könige als Integer.
     */
    void setGezogeneKoenige(int gezogeneKoenige);

    /**
     * Gibt den Index des aktuellen Spielers zurück.
     *
     * @return Der Index des aktuellen Spielers als Integer.
     */
    int getAktuellerSpielerIndex();

    /**
     * Setzt den Index des aktuellen Spielers.
     *
     * @param aktuellerSpielerIndex Der neue Index des aktuellen Spielers als Integer.
     */
    void setAktuellerSpielerIndex(int aktuellerSpielerIndex);

    /**
     * Initialisiert den Kartenstapel mit dem gewählten RegelSet.
     *
     * @throws IllegalArgumentException Wenn das RegelSet nicht existiert.
     */
    void initialisiereKartenstapelMitBestimmtenRegelSet(String regelSet) throws IllegalArgumentException;
}