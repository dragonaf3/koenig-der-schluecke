package com.example.koenigderschluecke.model;

import java.util.List;

/**
 * Die Lobby-Schnittstelle definiert die Methoden, die eine Lobby in unserem Spiel haben sollte.
 */
public interface Lobby {

    /**
     * Gibt die Liste der Spieler in der Lobby zurück.
     *
     * @return Eine Liste der Spielernamen.
     */
    public List<Spieler> getSpielerListe();

    /**
     * Fügt einen neuen Spieler zur Lobby hinzu.
     */
    public void addSpieler(String name);

    /**
     * Entfernt einen Spieler aus der Lobby.
     */
    public void removeSpieler();

    /**
     * Gibt die Anzahl der Spieler in der Lobby zurück.
     *
     * @return Die Anzahl der Spieler.
     */
    public int getAnzahlSpieler();

    /**
     * Gibt die ID des Regelsets zurück, das in der Lobby verwendet wird.
     *
     * @return Die ID des Regelsets.
     */
    public int getRegelsetId();

    /**
     * Setzt die ID des Regelsets, das in der Lobby verwendet wird.
     *
     * @param regelsetId Die ID des Regelsets.
     */
    public void setRegelsetId(int regelsetId);
}