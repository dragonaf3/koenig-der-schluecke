package com.example.koenigderschluecke.controller;

import com.example.koenigderschluecke.model.Spieler;

import java.util.List;

/**
 * Dieses Interface definiert die Methoden, die ein LobbyController implementieren muss.
 * Ein LobbyController ist verantwortlich für die Erstellung und Verwaltung der Spiellobby.
 */
public interface LobbyController {

    /**
     * Fügt einen neuen Spieler*in zur Lobby hinzu.
     *
     * @param spielerName Name des/der Spieler*in.
     * @throws IllegalArgumentException Wenn der Spielername bereits vergeben ist, leer oder Null.
     */
    void addSpieler(String spielerName) throws IllegalArgumentException;

    /**
     * Entfernt einen Spieler*in aus der Lobby.
     *
     * @param name Name des/der Spieler*in.
     * @throws IllegalArgumentException Wenn der Spielername nicht in der Lobby ist. Oder leer/Null
     */
    void removeSpieler(String name) throws IllegalArgumentException;

    /**
     * Gibt eine Liste aller Spieler*innen in der Lobby zurück.
     *
     * @return List<Spieler> Liste der Spieler*innen.
     */
    List<Spieler> getSpielerListe();

    /**
     * Wählt ein Regelset für das Spiel aus.
     *
     * @param regelsetId ID des Regelsets.
     */
    void waehleRegelset(int regelsetId);

    /**
     * Gibt die ID des aktuell ausgewählten Regelsets zurück.
     *
     * @return String Name des Regelsets.
     */
    String getAktuellesRegelset();

    /**
     * Startet das Spiel mit den aktuellen Einstellungen der Lobby.
     *
     * @throws IllegalArgumentException Wenn nicht genügend Spieler*innen in der Lobby sind.
     */
    void starteSpiel() throws IllegalArgumentException;

    /**
     * Beendet die Lobby und führt notwendige Aufräumarbeiten durch.
     */
    void beendeLobby();
}
