package com.example.koenigderschluecke.view.lobby;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_singleplayer, container, false);

        Button zurueckZumHauptmenueButton = view.findViewById(R.id.zurueckZumHauptmenueButton);
        EditText nameEditText = view.findViewById(R.id.nameEditText);
        Button playerAddButton = view.findViewById(R.id.playerAddButton);
        ListView namesListView = view.findViewById(R.id.namesListView);
        Button startGameButton = view.findViewById(R.id.startGameButton);
        Spinner rulesetSpinner = view.findViewById(R.id.ruleSetSpinner);
        String[] items = new String[]{"Hopfenhacker", "Kübel-König", "Rausch-Ritter"};

        ArrayList<String> namesList = new ArrayList<>();
        ArrayAdapter<String> namesAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, namesList);
        namesListView.setAdapter(namesAdapter);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);
        rulesetSpinner.setAdapter(adapter);

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

        rulesetSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedItem = parentView.getItemAtPosition(position).toString();
                lobbyController.waehleRegelset(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });


        zurueckZumHauptmenueButton.setOnClickListener(zurueckZumHauptmenueAktion -> {
            ((LobbyActivity) getActivity()).zurueckZumHauptmenue();
        });

        return view;
    }
}
