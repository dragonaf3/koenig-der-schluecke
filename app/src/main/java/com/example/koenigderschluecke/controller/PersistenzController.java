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
     * Lädt die Statistik am Ende des Spiels.
     *
     * @return Eine Zeichenkette, die die Statistik am Ende des Spiels darstellt.
     */
    String ladeSpielendeStatistik();
}