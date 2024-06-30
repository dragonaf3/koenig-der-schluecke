package com.example.koenigderschluecke.view;

import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pInfo;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.koenigderschluecke.R;
import com.example.koenigderschluecke.network.WifiDirectCommunication;
import com.example.koenigderschluecke.network.WifiDirectCommunicationImpl;
import com.example.koenigderschluecke.network.WifiDirectListener;

import java.util.ArrayList;
import java.util.Collection;

public class SpielBeitretenActivity extends AppCompatActivity implements WifiDirectListener {

    private WifiDirectCommunication wifiDirectCommunication;
    private LinearLayout linearLayout;
    private ArrayList<WifiP2pDevice> availableDevices = new ArrayList<>();
    private EditText playerNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spiel_beitreten);

        linearLayout = findViewById(R.id.linear_layout);
        playerNameEditText = findViewById(R.id.playerNameEditText);

        wifiDirectCommunication = new WifiDirectCommunicationImpl();
        wifiDirectCommunication.initialize(this);
        wifiDirectCommunication.setListener(this);
        wifiDirectCommunication.discoverPeers();

        Button zurueckZumHauptmenueButton = findViewById(R.id.zurueckZumHauptmenueSpielBeitretenButton);
        zurueckZumHauptmenueButton.setOnClickListener(v -> finish());
    }

    @Override
    public void onPeersAvailable(Collection<WifiP2pDevice> peerList) {
        availableDevices.clear();
        availableDevices.addAll(peerList);
        displayAvailableDevices();
    }

    @Override
    public void onConnectionInfoAvailable(WifiP2pInfo info) {
        if (info.groupFormed && !info.isGroupOwner) {
            Toast.makeText(this, "Mit dem Host verbunden", Toast.LENGTH_SHORT).show();
            sendDataToHost("PlayerName:" + playerNameEditText.getText().toString());
        }
    }

    @Override
    public void onDataReceived(String data) {
        //TODO: Implementieren
    }

    private void displayAvailableDevices() {
        linearLayout.removeAllViews();
        for (WifiP2pDevice device : availableDevices) {
            TextView deviceView = new TextView(this);
            deviceView.setText(device.deviceName);
            deviceView.setPadding(16, 16, 16, 16);
            deviceView.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            deviceView.setOnClickListener(v -> connectToDevice(device));
            linearLayout.addView(deviceView);
        }
    }

    private void connectToDevice(WifiP2pDevice device) {
        wifiDirectCommunication.connectToPeer(device);
    }

    private void sendDataToHost(String data) {
        wifiDirectCommunication.sendData(data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        wifiDirectCommunication.cleanup();
    }
}
