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

//TODO: Fehlt vieles
public class Hauptspiel extends AppCompatActivity {

    private TextView gezogeneKarteTextView;
    private TextView kartenImStapelView;
    private SpielController spielController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hauptspiel);

        spielController = new SpielControllerImpl();

        gezogeneKarteTextView = findViewById(R.id.gezogeneKarte);
        kartenImStapelView = findViewById(R.id.kartenImStapel);

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
