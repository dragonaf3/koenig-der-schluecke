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

        spielController = new SpielControllerImpl();
        bluetoothConnector = new BluetoothConnectorImpl();

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

    public void updateView() {

    }

    private void zurueckZumHauptmenue() {
        startActivity(new Intent(this, StartbildschirmActivity.class));
    }

}
