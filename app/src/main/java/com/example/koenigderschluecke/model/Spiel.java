package com.example.koenigderschluecke.model;

import java.util.List;

/**
 * Dies ist eine Schnittstelle für ein Spiel.
 * Sie bietet Methoden zum Hinzufügen und Entfernen von Spielern, zum Abrufen von Spielinformationen und zum Durchführen von Spielaktionen.
 */
public interface Spiel {

    /**
     * Fügt einen neuen Spieler zum Spiel hinzu.
     *
     * @param spieler Der Spieler, der zum Spiel hinzugefügt wird.
     */
    void addSpieler(Spieler spieler);

    /**
     * Entfernt einen Spieler aus dem Spiel.
     *
     * @param spieler Der Spieler, der aus dem Spiel entfernt wird.
     */
    void entferneSpieler(Spieler spieler);

    /**
     * Gibt eine Liste aller Spieler im Spiel zurück.
     *
     * @return Eine Liste der Spieler.
     */
    List<Spieler> getSpielerListe();

    /**
     * Gibt den aktuellen Spieler zurück.
     *
     * @return Der Spieler, der aktuell an der Reihe ist.
     * @throws IllegalStateException wenn keine Spieler im Spiel sind.
     */
    public Spieler getAktuellerSpieler() throws IllegalStateException;

    /**
     * Holt die nächste Karte vom Stapel. Diese Methode verändert den Zustand
     * des Kartenstapels, indem sie die oberste Karte entfernt.
     *
     * @return Die nächste Spielkarte vom Stapel.
     * @throws KartenstapelLeerException Diese Ausnahme wird ausgelöst, wenn der Kartenstapel leer ist.
     */
    Karte holeNaechsteKarte() throws KartenstapelLeerException;

    /**
     * Wechselt zum nächsten Spieler in der Reihenfolge. Diese Methode aktualisiert
     * die Information, welcher Spieler aktuell an der Reihe ist.
     */
    void wechsleZuNaechstemSpieler();

    /**
     * Gibt die aktuelle Runde des Spiels zurück.
     *
     * @return Die Nummer der aktuellen Runde.
     */
    int getAktuelleRunde();

    /**
     * Gibt eine Liste der verbleibenden Karten im Spiel zurück.
     *
     * @return Eine Liste der noch nicht gezogenen Karten.
     */
    List<Karte> getVerbleibendeKarten();

    /**
     * Gibt die Anzahl der bereits gezogenen Könige zurück.
     *
     * @return Die Anzahl der gezogenen Könige.
     */
    int getAnzahlGezogenerKoenige();
}
