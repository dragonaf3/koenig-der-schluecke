package com.example.koenigderschluecke.view.lobby;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.example.koenigderschluecke.R;
import com.example.koenigderschluecke.controller.LobbyController;
import com.example.koenigderschluecke.controller.LobbyControllerImpl;
import com.example.koenigderschluecke.view.StartbildschirmActivity;
import com.example.koenigderschluecke.view.spiel.HauptspielActivity;

//TODO: Implementieren

public class LobbyActivity extends FragmentActivity {
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
                .replace(R.id.fragment_container, singleplayerFragment)
                .commit();
    }

    public void starteSpielHost() {
        SpielHostFragment spielHostFragment = new SpielHostFragment();
        spielHostFragment.setLobbyController(this.lobbyController);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, spielHostFragment)
                .commit();
    }

    public void starteSpielBeitreten() {
        SpielBeitretenFragment spielBeitretenFragment = new SpielBeitretenFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, spielBeitretenFragment)
                .commit();
    }

    public void starteHauptspiel() {
        try {
            lobbyController.starteSpiel();
            startActivity(new Intent(this, HauptspielActivity.class));
        } catch (IllegalArgumentException exception) {
            Toast.makeText(this, "Zu wenige Spieler*innen", Toast.LENGTH_LONG).show();
        }
        //TODO: Hardcoded, ändern!
    }

    public void zurueckZumHauptmenue() {
        lobbyController.beendeLobby();
        startActivity(new Intent(this, StartbildschirmActivity.class));
    }
}
