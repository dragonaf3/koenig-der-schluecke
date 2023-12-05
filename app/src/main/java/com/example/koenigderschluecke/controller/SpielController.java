package com.example.koenigderschluecke.controller;

import com.example.koenigderschluecke.model.Spieler;

/**
 * Dieses Interface definiert die Methoden, die ein SpielController implementieren muss.
 * Ein SpielController ist verantwortlich für die Verwaltung des Spielablaufs.
 */
public interface SpielController {

    /**
     * Startet das Spiel.
     */
    void starteSpiel();

    /**
     * Beendet das Spiel.
     */
    void beendeSpiel();

    /**
     * Fügt einen neuen Spieler zum Spiel hinzu.
     *
     * @param spieler Der hinzuzufügende Spieler.
     */
    void addSpieler(Spieler spieler);

    /**
     * Entfernt einen Spieler aus dem Spiel.
     *
     * @param spieler Der zu entfernende Spieler.
     */
    void entferneSpieler(Spieler spieler);

    /**
     * Leitet die nächste Runde im Spiel ein.
     */
    void naechsteRunde();

    /**
     * Zieht eine Karte aus dem Kartenstapel und wendet die entsprechenden Spielregeln an.
     *
     * @return Gibt eine String-Repräsentation der gezogenen Karte zurück.
     * @throws KartenstapelLeerException Diese Ausnahme wird ausgelöst, wenn der Kartenstapel leer ist.
     */
    String karteZiehen() throws KartenstapelLeerException;
}
