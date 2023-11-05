package com.example.koenigderschluecke.spiel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.koenigderschluecke.R;

public class Hauptspiel extends AppCompatActivity {

    private KartenKreis kartenKreis;
    private TextView gezogeneKarteTextView;
    private TextView kartenImStapel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hauptspiel);

        kartenKreis = new KartenKreis();
        kartenKreis.kartenkreisBefuellen();

        gezogeneKarteTextView = findViewById(R.id.gezogeneKarte);
        kartenImStapel = findViewById(R.id.kartenImStapel);

        Button karteZiehenButton = findViewById(R.id.buttonKarteZiehen);

        kartenImStapel.setText(String.valueOf(kartenKreis.getKartenkreis().size()));

        karteZiehenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onKarteZiehen(v);
            }
        });
    }

    private void onKarteZiehen(View view) {
        String karte = String.valueOf(kartenKreis.karteZiehen());

        gezogeneKarteTextView.setText(karte);
        kartenImStapel.setText(String.valueOf(kartenKreis.getKartenkreis().size()));
    }
}
