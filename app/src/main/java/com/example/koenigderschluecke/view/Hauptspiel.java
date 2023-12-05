package com.example.koenigderschluecke.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.koenigderschluecke.R;
import com.example.koenigderschluecke.controller.SpielController;
import com.example.koenigderschluecke.controller.SpielControllerImpl;
import com.example.koenigderschluecke.controller.KartenstapelLeerException;
import com.example.koenigderschluecke.model.Spiel;
import com.example.koenigderschluecke.model.SpielSingleton;
import com.example.koenigderschluecke.network.BluetoothConnector;
import com.example.koenigderschluecke.network.BluetoothConnectorImpl;

//TODO: Fehlt vieles
public class Hauptspiel extends AppCompatActivity {

    private TextView gezogeneKarteTextView;
    private TextView kartenImStapelTextView;
    private Spiel spiel;
    private SpielController spielController;
    private BluetoothConnector bluetoothConnector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hauptspiel);

        spiel = SpielSingleton.getSpielInstance();
        spielController = new SpielControllerImpl(spiel);
        bluetoothConnector = new BluetoothConnectorImpl(spiel);

        gezogeneKarteTextView = findViewById(R.id.gezogeneKarte);
        kartenImStapelTextView = findViewById(R.id.kartenImStapel);

        Button karteZiehenButton = findViewById(R.id.buttonKarteZiehen);

        karteZiehenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    gezogeneKarteTextView.setText(spielController.karteZiehen());
                } catch (KartenstapelLeerException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

}
