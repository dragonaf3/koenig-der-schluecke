package com.example.koenigderschluecke.network;

import java.io.IOException;
import java.util.List;

/**
 * Dieses Interface definiert die Methoden, die ein BluetoothConnector implementieren muss.
 * Ein BluetoothConnector ist verantwortlich für die Verwaltung der Bluetooth-Kommunikation.
 */
public interface BluetoothConnector {

    /**
     * Initialisiert den Bluetooth-Adapter und stellt sicher, dass Bluetooth aktiviert ist.
     * @throws IOException wenn ein Fehler beim Initialisieren des Adapters auftritt.
     */
    void initialize() throws IOException;

    /**
     * Startet die Suche nach anderen Bluetooth-Geräten.
     * @throws IOException wenn ein Fehler bei der Gerätesuche auftritt.
     */
    void startDiscovery() throws IOException;

    /**
     * Stoppt die Suche nach anderen Bluetooth-Geräten.
     * @throws IOException wenn ein Fehler beim Stoppen der Gerätesuche auftritt.
     */
    void stopDiscovery() throws IOException;

    /**
     * Verbindet sich mit einem anderen Bluetooth-Gerät anhand der MAC-Adresse.
     * @param macAddress Die MAC-Adresse des Zielgeräts.
     * @throws IOException wenn ein Fehler beim Verbindungsaufbau auftritt.
     */
    void connect(String macAddress) throws IOException;

    /**
     * Trennt die aktuelle Bluetooth-Verbindung.
     * @throws IOException wenn ein Fehler beim Trennen der Verbindung auftritt.
     */
    void disconnect() throws IOException;

    /**
     * Sendet Daten an das verbundene Bluetooth-Gerät.
     * @param data Die zu sendenden Daten.
     * @throws IOException wenn ein Fehler beim Senden der Daten auftritt.
     */
    void sendData(byte[] data) throws IOException;

    /**
     * Empfängt Daten vom verbundenen Bluetooth-Gerät.
     * @return Die empfangenen Daten.
     * @throws IOException wenn ein Fehler beim Empfangen der Daten auftritt.
     */
    byte[] receiveData() throws IOException;

    /**
     * Gibt eine Liste der gefundenen Bluetooth-Geräte zurück.
     * @return Eine Liste der gefundenen Bluetooth-Geräte.
     */
    List<String> getDiscoveredDevices();

    /**
     * Setzt einen Listener für Bluetooth-Ereignisse.
     * @param listener Der Listener für Bluetooth-Ereignisse.
     */
    void setBluetoothEventListener(BluetoothEventListener listener);

    /**
     * Schnittstelle für Bluetooth-Ereignis-Listener.
     */
    interface BluetoothEventListener {
        /**
         * Wird aufgerufen, wenn ein neues Bluetooth-Gerät gefunden wird.
         * @param deviceName Der Name des gefundenen Geräts.
         * @param deviceAddress Die MAC-Adresse des gefundenen Geräts.
         */
        void onDeviceFound(String deviceName, String deviceAddress);

        /**
         * Wird aufgerufen, wenn die Verbindung erfolgreich hergestellt wurde.
         */
        void onConnected();

        /**
         * Wird aufgerufen, wenn die Verbindung getrennt wurde.
         */
        void onDisconnected();

        /**
         * Wird aufgerufen, wenn Daten empfangen wurden.
         * @param data Die empfangenen Daten.
         */
        void onDataReceived(byte[] data);
    }
}
