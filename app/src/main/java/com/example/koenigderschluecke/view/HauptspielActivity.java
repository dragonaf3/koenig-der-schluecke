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

    private TextView gezogeneKarteTextView;
    private TextView aktuellerSpielerTextView;
    private SpielController spielController;
    private BluetoothConnector bluetoothConnector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hauptspiel);

        spielController = new SpielControllerImpl();
        bluetoothConnector = new BluetoothConnectorImpl();

        gezogeneKarteTextView = findViewById(R.id.gezogeneKarte);
        aktuellerSpielerTextView = findViewById(R.id.aktuellerSpieler);

        Button karteZiehenButton = findViewById(R.id.buttonKarteZiehen);

        //Nur Testzweck erstmal
        bluetoothConnector.addSpieler(new SpielerImpl("Alex"));
        bluetoothConnector.addSpieler(new SpielerImpl("Eva"));

        karteZiehenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (spielController.spielIstBeendet()) {
                        zurueckZumHauptmenue();
                    }
                    gezogeneKarteTextView.setText(spielController.karteZiehen());
                    aktuellerSpielerTextView.setText(spielController.naechsteRunde());
                } catch (KartenstapelLeerException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void updateView() {

    }

    private void zurueckZumHauptmenue() {
        startActivity(new Intent(this, StartbildschirmActivity.class));
    }

}
