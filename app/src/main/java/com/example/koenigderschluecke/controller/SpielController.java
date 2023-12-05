package com.example.koenigderschluecke.controller;

import com.example.koenigderschluecke.model.Spieler;

/**
 * Dieses Interface definiert die Methoden, die ein SpielController implementieren muss.
 * Ein SpielController ist verantwortlich für die Verwaltung des Spielablaufs.
 */
public interface SpielController {

    /**
     * Methode die ueberprueft, ob das Spiel beendet ist.
     */
    boolean spielIstBeendet();

    /**
     * Leitet die nächste Runde im Spiel ein.
     *
     * @return String Id des nächsten Spieler*in
     */
    String naechsteRunde();

    /**
     * Zieht eine Karte aus dem Kartenstapel und wendet die entsprechenden Spielregeln an.
     *
     * @return Gibt eine String-Repräsentation der gezogenen Karte zurück.
     * @throws KartenstapelLeerException Diese Ausnahme wird ausgelöst, wenn der Kartenstapel leer ist.
     */
    String karteZiehen() throws KartenstapelLeerException;
}
