package com.example.koenigderschluecke.controller;

import java.util.List;

/**
 * Dieses Interface definiert die Methoden, die ein LobbyController implementieren muss.
 * Ein LobbyController ist verantwortlich für die Erstellung und Verwaltung der Spiellobby.
 */
public interface LobbyController {

    /**
     * Setzt die Anzahl der Spieler*innen für das Spiel.
     *
     * @param anzahlSpieler Die Anzahl der Spieler*innen.
     */
    void setAnzahlSpieler(int anzahlSpieler);

    /**
     * Gibt die aktuell eingestellte Anzahl der Spieler*innen zurück.
     *
     * @return int Anzahl der Spieler*innen.
     */
    int getAnzahlSpieler();

    /**
     * Fügt einen neuen Spieler*in zur Lobby hinzu.
     *
     * @param spielerName Name des/der Spieler*in.
     */
    void addSpieler(String spielerName);

    /**
     * Entfernt einen Spieler*in aus der Lobby.
     *
     * @param spielerName Name des/der Spieler*in.
     */
    void removeSpieler(String spielerName);

    /**
     * Gibt eine Liste aller Spieler*innen in der Lobby zurück.
     *
     * @return List<String> Liste der Spieler*innen.
     */
    List<String> getSpielerListe();

    /**
     * Wählt ein Regelset für das Spiel aus.
     *
     * @param regelsetId ID des Regelsets.
     */
    void waehleRegelset(int regelsetId);

    /**
     * Gibt die ID des aktuell ausgewählten Regelsets zurück.
     *
     * @return int ID des Regelsets.
     */
    int getAktuellesRegelset();

    /**
     * Startet das Spiel mit den aktuellen Einstellungen der Lobby.
     */
    void starteSpiel();

    /**
     * Beendet die Lobby und führt notwendige Aufräumarbeiten durch.
     */
    void beendeLobby();
}
