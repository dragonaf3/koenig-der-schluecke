package com.example.koenigderschluecke.controller;

import com.example.koenigderschluecke.exceptions.KartenstapelLeerException;
import com.example.koenigderschluecke.model.Karte;

import java.util.List;

/**
 * Dieses Interface definiert die Methoden, die ein SpielController implementieren muss.
 * Ein SpielController ist verantwortlich für die Verwaltung des Spielablaufs.
 */
public interface SpielController {

    /**
     * Methode die ueberprueft, ob das Spiel beendet ist.
     *
     * @return boolean true, wenn das Spiel beendet ist, sonst false.
     */
    boolean spielIstBeendet();

    /**
     * Methode, die den Kartenstapel zurückgibt.
     *
     * @return List<Karte> Der Kartenstapel.
     */
    List<Karte> getKartenstapel();

    /**
     * Gibt die Anzahl der gezogenen Könige zurück.
     *
     * @return Die Anzahl der gezogenen Könige.
     */
    int getGezogeneKoenige();

    /**
     * Zieht eine Karte aus dem Kartenstapel und setzt damit die aktuelle Karte.
     *
     */
    void karteZiehen();

    /**
     * Methode, die den Namen der aktuellen Spieler*in zurückgibt.
     *
     * @return String Name der aktuellen Spieler*in.
     */
    String getNameAktuellerSpieler();

    /**
     * Methode, die die aktuelle Karte als String zurückgibt.
     *
     * @return String Die aktuelle Karte.
     */
    String getAktuelleKarte();

    /**
     * Methode, die die Regel der aktuellen Karte zurückgibt.
     *
     * @return String Regel der aktuellen Karte.
     */
    String getRegelAktuelleKarte();

    /**
     * Leitet die nächste Runde im Spiel ein.
     *
     */
    void naechsteRunde();

    /**
     * Gibt die Anzahl der gezogenen Karten zurück.
     *
     * @return int Anzahl der gezogenen Karten.
     */
    int getAnzahlGezogenerKarten();

    /**
     * Beendet das aktuelle Spiel und räumt auf.
     */
    void beendeSpiel();

}
