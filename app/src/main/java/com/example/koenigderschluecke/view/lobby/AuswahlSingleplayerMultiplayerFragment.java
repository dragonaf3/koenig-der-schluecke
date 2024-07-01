package com.example.koenigderschluecke.view.lobby;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.koenigderschluecke.R;

public class AuswahlSingleplayerMultiplayerFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_auswahl_singleplayer_multiplayer, container, false);

        Button singleplayerButton = view.findViewById(R.id.singleplayerButton);
        Button spielHostButton = view.findViewById(R.id.spielHostButton);
        Button spielBeitretenButton = view.findViewById(R.id.spielBeitretenButton);
        Button zurueckZumHauptmenueButton = view.findViewById(R.id.zurueckZumHauptmenueButton);

        singleplayerButton.setOnClickListener(singleplayerAktion -> {
            ((LobbyActivity) getActivity()).starteSingleplayer();
        });

        //TODO: spielHostButton und spielBeitretenButton
        spielHostButton.setOnClickListener(multiplayerAktion -> {
            ((LobbyActivity) getActivity()).starteSpielHost();
        });

        spielBeitretenButton.setOnClickListener(multiplayerAktion -> {
            ((LobbyActivity) getActivity()).starteSpielHost();
        });

        zurueckZumHauptmenueButton.setOnClickListener(zurueckZumHauptmenueAktion -> {
            ((LobbyActivity) getActivity()).zurueckZumHauptmenue();
        });

        return view;
    }
}
