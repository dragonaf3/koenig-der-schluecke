package com.example.koenigderschluecke.view.lobby;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.koenigderschluecke.R;
import com.example.koenigderschluecke.controller.LobbyController;

public class SingleplayerFragment extends Fragment {

    private LobbyController lobbyController;

    public void setLobbyController(LobbyController lobbyController) {
        this.lobbyController = lobbyController;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_singleplayer, container, false);

        Button zurueckZumHauptmenueButton = view.findViewById(R.id.zurueckZumHauptmenueButton);
        EditText nameEditText = view.findViewById(R.id.nameEditText);
        Button playerAddButton = view.findViewById(R.id.playerAddButton);
        ListView namesListView = view.findViewById(R.id.namesListView);




        zurueckZumHauptmenueButton.setOnClickListener(zurueckZumHauptmenueAktion -> {
            ((LobbyActivity) getActivity()).zurueckZumHauptmenue();
        });

        return view;
    }
}
