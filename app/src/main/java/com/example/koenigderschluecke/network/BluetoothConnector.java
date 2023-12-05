package com.example.koenigderschluecke.network;

//TODO: Diese Interface und alles drum herum muss noch konzipiert werden. Es dient erstmal nur als vorläufiger Spieler*innen Connector

import com.example.koenigderschluecke.model.Spieler;

/**
 * Dieses Interface definiert die Methoden, die ein BluetoothConnector implementieren muss.
 */
public interface BluetoothConnector {

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
}
