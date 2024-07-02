package com.example.koenigderschluecke.network;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pDevice;

/**
 * Dieses Interface definiert die Methoden, die ein WifiDirectConnector implementieren muss.
 * Ein WifiDirectConnector ist verantwortlich für die Verwaltung der WiFi Direct Kommunikation.
 */
public interface WifiDirectConnector {

    /**
     * Initialisiert den WiFi Direct Connector mit dem gegebenen Kontext.
     *
     * @param context Der Anwendungskontext, der für die Initialisierung verwendet wird.
     */
    void initialize(Context context);

    /**
     * Startet die Suche nach anderen WiFi Direct Geräten in der Nähe.
     */
    void discoverPeers();

    /**
     * Verbindet sich mit einem angegebenen WiFi Direct Gerät.
     *
     * @param device Das WiFi Direct Gerät, mit dem die Verbindung hergestellt werden soll.
     */
    void connectToPeer(WifiP2pDevice device);

    /**
     * Sendet Daten an das verbundene WiFi Direct Gerät.
     *
     * @param data Die zu sendenden Daten als String.
     */
    void sendData(String data);

    /**
     * Setzt einen Listener für WiFi Direct Ereignisse.
     *
     * @param listener Der Listener für WiFi Direct Ereignisse.
     */
    void setListener(WifiDirectListener listener);

    /**
     * Räumt Ressourcen auf und beendet alle WiFi Direct Verbindungen.
     */
    void cleanup();
}
