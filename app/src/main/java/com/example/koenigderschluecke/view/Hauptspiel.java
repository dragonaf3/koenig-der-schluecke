package com.example.koenigderschluecke.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.koenigderschluecke.R;

//TODO: Fehlt vieles
public class Hauptspiel extends AppCompatActivity {

    private TextView gezogeneKarteTextView;
    private TextView kartenImStapel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hauptspiel);

        gezogeneKarteTextView = findViewById(R.id.gezogeneKarte);
        kartenImStapel = findViewById(R.id.kartenImStapel);

        Button karteZiehenButton = findViewById(R.id.buttonKarteZiehen);

        karteZiehenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Muss imp werden
            }
        });
    }

}
