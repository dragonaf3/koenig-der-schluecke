package com.example.koenigderschluecke.network;

//TODO: Diese Interface und alles drum herum muss noch konzipiert werden. Es dient erstmal nur als vorläufiger Spieler*innen Connector

import android.content.Context;

import com.example.koenigderschluecke.model.Spieler;

/**
 * Dieses Interface definiert die Methoden, die ein BluetoothConnector implementieren muss.
 */
public interface BluetoothConnector {

    void bluetoothAktivierung();
}
