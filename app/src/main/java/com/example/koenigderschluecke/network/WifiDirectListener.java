package com.example.koenigderschluecke.network;

import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pInfo;

import java.util.Collection;

/**
 * Dieses Interface definiert die Ereignisse, die bei der WiFi Direct Kommunikation auftreten können.
 * Ein WifiDirectListener verarbeitet diese Ereignisse.
 */
public interface WifiDirectListener {

    /**
     * Wird aufgerufen, wenn eine Liste der verfügbaren WiFi Direct Geräte bereitsteht.
     *
     * @param peerList Die Liste der gefundenen WiFi Direct Geräte.
     */
    void onPeersAvailable(Collection<WifiP2pDevice> peerList);

    /**
     * Wird aufgerufen, wenn Informationen über die WiFi Direct Verbindung verfügbar sind.
     *
     * @param info Informationen über die aktuelle WiFi Direct Verbindung.
     */
    void onConnectionInfoAvailable(WifiP2pInfo info);

    /**
     * Wird aufgerufen, wenn Daten von einem verbundenen WiFi Direct Gerät empfangen werden.
     *
     * @param data Die empfangenen Daten als String.
     */
    void onDataReceived(String data);
}
