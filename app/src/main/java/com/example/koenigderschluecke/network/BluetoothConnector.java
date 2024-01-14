package com.example.koenigderschluecke.network;

//TODO: Alles Englische weg, BluetoothConnector und Impl noch coden. Discovery und Dateiaustausch ist erstmal egal

import android.bluetooth.BluetoothDevice;
import android.content.Context;

import com.example.koenigderschluecke.model.Spieler;

import java.util.Set;

/**
 * Dieses Interface definiert die Methoden, die ein BluetoothConnector implementieren muss.
 */
public interface BluetoothConnector {

    void bluetoothAktivierung();

    Set<BluetoothDevice> getBluetoothDevices();
}
