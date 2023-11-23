package com.example.koenigderschluecke.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.koenigderschluecke.R;

public class Startbildschirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startbildschirm);

        //Erstellung der Elemente der Activity
        Button neuesSpielButton = findViewById(R.id.buttonNeuesSpiel);
        Button spielBeitretenButton = findViewById(R.id.buttonSpielBeitreten);
        ImageButton statistikButton = findViewById(R.id.buttonStatistik);
        ImageButton einstellungenButton = findViewById(R.id.buttonEinstellungen);
        Button beendenButton = findViewById(R.id.buttonBeenden);

        //Definieren der OnClickListener
        neuesSpielButton.setOnClickListener(v -> startActivity(new Intent(this, Hauptspiel.class)));
        spielBeitretenButton.setOnClickListener(v -> startActivity(new Intent(this, SpielBeitreten.class)));
        statistikButton.setOnClickListener(v -> startActivity(new Intent(this, Statistik.class)));
        einstellungenButton.setOnClickListener(v -> startActivity(new Intent(this, Einstellungen.class)));
        beendenButton.setOnClickListener(v -> {
            finish();
            finishAffinity();
        });
    }
}