package com.example.koenigderschluecke.network;

import com.example.koenigderschluecke.model.Spiel;
import com.example.koenigderschluecke.model.SpielSingleton;
import com.example.koenigderschluecke.model.Spieler;

/**
 * Diese Klasse implementiert das Interface BluetoothConnector.
 */
public class BluetoothConnectorImpl implements BluetoothConnector {
    private final Spiel spiel;

    public BluetoothConnectorImpl() throws Exception {
        this.spiel = SpielSingleton.getInstanceOhneErstellen();
    }

    @Override
    public void addSpieler(Spieler spieler) {
        spiel.getSpielerListe().add(spieler);
    }

    @Override
    public void entferneSpieler(Spieler spieler) {
        spiel.getSpielerListe().remove(spieler);
    }
}
