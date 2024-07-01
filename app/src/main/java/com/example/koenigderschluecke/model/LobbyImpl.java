package com.example.koenigderschluecke.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse LobbyImpl implementiert die Lobby-Schnittstelle.
 * Sie verwaltet eine Liste von Spielern und speichert die Anzahl der Spieler und die ID des Regelsets.
 */
public class LobbyImpl implements Lobby {

    // Liste der Spieler in der Lobby
    private List<Spieler> spielerList;
    // Anzahl der Spieler in der Lobby
    private int anzahlSpieler;
    // ID des Regelsets, das in der Lobby verwendet wird
    private int regelsetID;

    /**
     * Konstruktor für LobbyImpl.
     * Initialisiert die Spielerliste und setzt die Anzahl der Spieler und die Regelset-ID auf 0.
     */
    public LobbyImpl() {
        this.spielerList = new ArrayList<>();
        this.anzahlSpieler = 0;
        this.regelsetID = 0;
    }

    /**
     * Gibt die Liste der Spieler in der Lobby zurück.
     *
     * @return Liste der Spieler
     */
    @Override
    public List<Spieler> getSpielerListe() {
        return spielerList;
    }

    /**
     * Fügt einen neuen Spieler zur Spielerliste hinzu und erhöht die Anzahl der Spieler um eins.
     *
     * @param name Der Name des hinzuzufügenden Spielers
     * @throws IllegalArgumentException Wenn der Spielername bereits vergeben ist, leer oder Null.
     */
    @Override
    public void addSpieler(String name) {
        for (Spieler spieler : spielerList) {
            if (spieler.getName().equals(name)) {
                throw new IllegalArgumentException("Name ist bereits vergeben.");
            }
        }

        spielerList.add(new SpielerImpl(name));
        anzahlSpieler++;
    }

    /**
     * Entfernt einen Spieler aus der Spielerliste und verringert die Anzahl der Spieler um eins.
     *
     * @param name Der Name des zu entfernenden Spielers
     * @throws IllegalArgumentException Wenn der Spielername nicht in der Lobby ist. Oder leer/Null
     */
    @Override
    public void removeSpieler(String name) throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name darf nicht leer oder null sein.");
        }
        if (spielerList.stream().noneMatch(spieler -> spieler.getName().equals(name))) {
            throw new IllegalArgumentException("Name ist nicht in der Lobby.");
        }

        spielerList.removeIf(spieler -> spieler.getName().equals(name));
        anzahlSpieler--;
    }

    /**
     * Gibt die Anzahl der Spieler in der Lobby zurück.
     *
     * @return Anzahl der Spieler
     */
    @Override
    public int getAnzahlSpieler() {
        return this.anzahlSpieler;
    }

    /**
     * Gibt die ID des in der Lobby verwendeten Regelsets zurück.
     *
     * @return ID des Regelsets
     */
    @Override
    public int getRegelsetId() {
        return this.regelsetID;
    }

    /**
     * Setzt die ID des in der Lobby zu verwendenden Regelsets.
     *
     * @param regelsetId Die zu setzende Regelset-ID
     */
    @Override
    public void setRegelsetId(int regelsetId) {
        this.regelsetID = regelsetId;
    }
}