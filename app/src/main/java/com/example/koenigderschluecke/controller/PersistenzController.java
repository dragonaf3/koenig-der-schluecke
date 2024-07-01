package com.example.koenigderschluecke.controller;

/**
 * Das Interface PersistenzController bietet Methoden zum Speichern und Laden von Statistiken.
 */
public interface PersistenzController {

    /**
     * Speichert die aktuelle Statistik.
     *
     * @param anzahlGezogeneKartenImAktuellenSpiel Die Anzahl der gezogenen Karten im aktuellen Spiel.
     */
    void speichereStatistik(int anzahlGezogeneKartenImAktuellenSpiel);

    /**
     * Lädt die gespeicherte Statistik.
     */
    void ladeStatistik();

    /**
     * Lädt die Statistik am Ende des Spiels, wie viele Spiele insgesamt gespielt wurden.
     *
     * @return Anzahl der gespielten Spiele
     */
    String ladeSpielendeStatistik();

    /**
     * Lädt die gezogenen Karten seit App-Start oder Statistik Reset.
     *
     * @return Anzahl der gezogenen Karten
     */
    String ladeGezogeneKarten();

    /**
     * Resettet die Statistik.
     */
    void resetStatistik();
}