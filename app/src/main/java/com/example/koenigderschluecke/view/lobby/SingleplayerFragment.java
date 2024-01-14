package com.example.koenigderschluecke.view.lobby;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.koenigderschluecke.R;
import com.example.koenigderschluecke.controller.LobbyController;

import java.util.ArrayList;

public class SingleplayerFragment extends Fragment {

    private LobbyController lobbyController;

    public void setLobbyController(LobbyController lobbyController) {
        this.lobbyController = lobbyController;
    }

    //TODO: Regelset?

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_singleplayer, container, false);

        Button zurueckZumHauptmenueButton = view.findViewById(R.id.zurueckZumHauptmenueButton);
        EditText nameEditText = view.findViewById(R.id.nameEditText);
        Button playerAddButton = view.findViewById(R.id.playerAddButton);
        ListView namesListView = view.findViewById(R.id.namesListView);
        Button startGameButton = view.findViewById(R.id.startGameButton);

        ArrayList<String> namesList = new ArrayList<>();
        ArrayAdapter<String> namesAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, namesList);
        namesListView.setAdapter(namesAdapter);

        startGameButton.setOnClickListener(starteHauptspielAktion -> {
            ((LobbyActivity) getActivity()).starteHauptspiel();
        });

        playerAddButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString();
            if (!name.isEmpty()) {
                namesList.add(name);
                namesAdapter.notifyDataSetChanged();
                nameEditText.setText("");

                try {
                    lobbyController.addSpieler(name);
                } catch (IllegalArgumentException e) {
                    Toast.makeText(getActivity(), "Name darf nicht leer oder bereits vorhanden sein!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        namesListView.setOnItemClickListener((parent, itemView, position, id) -> {
            String removedName = namesList.get(position);
            namesList.remove(position);
            namesAdapter.notifyDataSetChanged();

            lobbyController.removeSpieler(removedName);
        });

        zurueckZumHauptmenueButton.setOnClickListener(zurueckZumHauptmenueAktion -> {
            ((LobbyActivity) getActivity()).zurueckZumHauptmenue();
        });

        return view;
    }
}
