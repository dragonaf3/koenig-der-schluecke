package com.example.koenigderschluecke.view.lobby;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.koenigderschluecke.R;
import com.example.koenigderschluecke.controller.LobbyController;
import com.example.koenigderschluecke.network.DeviceListAdapter;
import com.example.koenigderschluecke.network.WifiDirectConnector;
import com.example.koenigderschluecke.network.WifiDirectConnectorImpl;
import com.example.koenigderschluecke.network.WifiDirectListener;

import java.util.ArrayList;
import java.util.Collection;

public class SpielHostFragment extends Fragment implements WifiDirectListener {

    private WifiDirectConnector wifiDirectCommunication;
    private ArrayList<WifiP2pDevice> connectedDevices = new ArrayList<>();
    private DeviceListAdapter deviceListAdapter;
    private LobbyController lobbyController;

    public void setLobbyController(LobbyController lobbyController) {
        this.lobbyController = lobbyController;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        wifiDirectCommunication = new WifiDirectConnectorImpl();
        wifiDirectCommunication.initialize(context);
        wifiDirectCommunication.setListener(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Start peer discovery
        wifiDirectCommunication.discoverPeers();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spiel_host, container, false);

        EditText hostNameEditText = view.findViewById(R.id.hostNameEditText);
        ListView deviceListView = view.findViewById(R.id.deviceListView);
        Button startGameButton = view.findViewById(R.id.startGameButton);
        Button zurueckZumHauptmenueButton = view.findViewById(R.id.zurueckZumHauptmenueButton);

        deviceListAdapter = new DeviceListAdapter(getContext(), connectedDevices);
        deviceListView.setAdapter(deviceListAdapter);

        startGameButton.setOnClickListener(v -> {
            if (!connectedDevices.isEmpty()) {
                String hostName = hostNameEditText.getText().toString();
                if (!hostName.isEmpty()) {
                    // Set the host name
                    lobbyController.addSpieler(hostName);
                    ((LobbyActivity) getActivity()).starteHauptspiel();
                } else {
                    Toast.makeText(getContext(), "Bitte geben Sie einen Hostnamen ein", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getContext(), "Keine verbundenen Geräte", Toast.LENGTH_SHORT).show();
            }
        });

        zurueckZumHauptmenueButton.setOnClickListener(zurueckZumHauptmenueAktion -> {
            ((LobbyActivity) getActivity()).zurueckZumHauptmenue();
        });

        return view;
    }

    @Override
    public void onPeersAvailable(Collection<WifiP2pDevice> peerList) {
        connectedDevices.clear();
        connectedDevices.addAll(peerList);
        deviceListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onConnectionInfoAvailable(WifiP2pInfo info) {
        if (info.groupFormed && info.isGroupOwner) {
            sendDataToClients("Spiel gestartet");
        }
    }

    @Override
    public void onDataReceived(String data) {
        if (data.startsWith("PlayerName:")) {
            String playerName = data.substring("PlayerName:".length());
            lobbyController.addSpieler(playerName);
            Toast.makeText(getContext(), "Spieler verbunden: " + playerName, Toast.LENGTH_SHORT).show();
        } else {
            // Handle other received data
        }
    }

    private void sendDataToClients(String data) {
        wifiDirectCommunication.sendData(data);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        wifiDirectCommunication.cleanup();
    }
}
