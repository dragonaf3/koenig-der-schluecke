package com.example.koenigderschluecke.view.lobby;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.koenigderschluecke.R;
import com.example.koenigderschluecke.controller.LobbyController;
import com.example.koenigderschluecke.controller.LobbyControllerImpl;
import com.example.koenigderschluecke.view.StartbildschirmActivity;

//TODO: Implementieren

public class LobbyActivity extends AppCompatActivity {
    private LobbyController lobbyController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        lobbyController = new LobbyControllerImpl();

        if (savedInstanceState == null) {
            AuswahlSingleplayerMultiplayerFragment fragment = new AuswahlSingleplayerMultiplayerFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }

    public void starteSingleplayer() {
        SingleplayerFragment singleplayerFragment = new SingleplayerFragment();
        singleplayerFragment.setLobbyController(this.lobbyController);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, singleplayerFragment)
                .commit();
    }

    public void starteMultiplayer() {
        //TODO: Implementieren
    }

    public void zurueckZumHauptmenue() {
        lobbyController.beendeLobby();
        startActivity(new Intent(this, StartbildschirmActivity.class));
    }
}
