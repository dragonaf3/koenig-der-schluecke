package com.example.koenigderschluecke.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.koenigderschluecke.R;
import com.example.koenigderschluecke.controller.SpielController;
import com.example.koenigderschluecke.controller.SpielControllerImpl;
import com.example.koenigderschluecke.exceptions.KartenstapelLeerException;
import com.example.koenigderschluecke.model.Spiel;
import com.example.koenigderschluecke.model.SpielerImpl;
import com.example.koenigderschluecke.network.BluetoothConnector;
import com.example.koenigderschluecke.network.BluetoothConnectorImpl;

//TODO: Fehlt vieles
public class HauptspielActivity extends AppCompatActivity {
    private SpielController spielController;
    private BluetoothConnector bluetoothConnector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hauptspiel);

        //Test Regelset
        spielController = new SpielControllerImpl("RauschRitter");
        try {
            bluetoothConnector = new BluetoothConnectorImpl();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //Testzwecke
        bluetoothConnector.addSpieler(new SpielerImpl("Alex"));
        bluetoothConnector.addSpieler(new SpielerImpl("Eva"));
        //Testzwecke

        if (savedInstanceState == null) {
            KartenkreisFragment fragment = new KartenkreisFragment();
            fragment.setSpielController(spielController);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }

    }

    public void naechsteRunde() {
        if (spielController.spielIstBeendet()) {
            wechselZuSpielendeFragment();
        } else {
            wechselZuKartenkreisFragment();
        }
    }

    public void karteGezogen() {
        wechselZuRegelFragment();
    }

    private void wechselZuKartenkreisFragment() {
        KartenkreisFragment kartenkreisFragment = new KartenkreisFragment();
        kartenkreisFragment.setSpielController(spielController);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, kartenkreisFragment)
                .commit();

    }

    private void wechselZuSpielendeFragment() {
        //TODO: SpielendeFragment fehlt

    }

    private void wechselZuRegelFragment() {
        RegelFragment regelFragment = new RegelFragment();
        regelFragment.setSpielController(spielController);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, regelFragment)
                .commit();
    }

    private void zurueckZumHauptmenue() {
        startActivity(new Intent(this, StartbildschirmActivity.class));
    }

}
