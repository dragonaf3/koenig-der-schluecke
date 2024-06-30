package com.example.koenigderschluecke.network;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pDevice;

public interface WifiDirectCommunication {

    void initialize(Context context);

    void discoverPeers();

    void connectToPeer(WifiP2pDevice device);

    void sendData(String data);

    void setListener(WifiDirectListener listener);

    void cleanup();
}
