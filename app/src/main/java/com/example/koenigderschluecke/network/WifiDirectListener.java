package com.example.koenigderschluecke.network;

import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pInfo;

import java.util.Collection;

public interface WifiDirectListener {

    void onPeersAvailable(Collection<WifiP2pDevice> peerList);

    void onConnectionInfoAvailable(WifiP2pInfo info);

    void onDataReceived(String data);
}
