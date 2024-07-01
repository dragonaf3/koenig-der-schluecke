package com.example.koenigderschluecke.network;

import static android.provider.Telephony.Carriers.PORT;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class WifiDirectCommunicationImpl implements WifiDirectCommunication {
    private Context context;
    private WifiP2pManager manager;
    private WifiP2pManager.Channel channel;
    private WifiDirectListener listener;
    private BroadcastReceiver receiver;

    @Override
    public void initialize(Context context) {
        this.context = context;
        manager = (WifiP2pManager) context.getSystemService(Context.WIFI_P2P_SERVICE);
        channel = manager.initialize(context, context.getMainLooper(), null);
        registerReceiver();
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);
        receiver = new WiFiDirectBroadcastReceiver(manager, channel, listener);
        context.registerReceiver(receiver, intentFilter);
    }

    @SuppressLint("MissingPermission")
    @Override
    public void discoverPeers() {
        manager.discoverPeers(channel, new WifiP2pManager.ActionListener() {
            @Override
            public void onSuccess() {
                // Discovery started successfully
            }

            @Override
            public void onFailure(int reasonCode) {
                // Handle failure
            }
        });
    }

    @SuppressLint("MissingPermission")
    @Override
    public void connectToPeer(WifiP2pDevice device) {
        WifiP2pConfig config = new WifiP2pConfig();
        config.deviceAddress = device.deviceAddress;
        manager.connect(channel, config, new WifiP2pManager.ActionListener() {
            @Override
            public void onSuccess() {
                // Connection successful
            }

            @Override
            public void onFailure(int reason) {
                // Handle failure
            }
        });
    }

@Override
public void sendData(String data) {
    new Thread(() -> {
        try {
            Socket socket = new Socket();
            socket.bind(null);
            socket.connect((new InetSocketAddress("IP_ADDRESS", Integer.parseInt(PORT))), 5000);

            OutputStream stream = socket.getOutputStream();
            stream.write(data.getBytes());

            stream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }).start();
}

    @Override
    public void setListener(WifiDirectListener listener) {
        this.listener = listener;
    }

    @Override
    // Make sure to unregister the receiver when it's no longer needed
    public void cleanup() {
        if (receiver != null) {
            context.unregisterReceiver(receiver);
        }
    }
}
