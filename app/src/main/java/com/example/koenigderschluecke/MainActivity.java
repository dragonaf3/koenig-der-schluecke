package com.example.koenigderschluecke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.koenigderschluecke.spiel.Hauptspiel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startbildschirm);

        // Finde den "Spiel beitreten"-Button in deinem Layout
        Button neuesSpielButton = findViewById(R.id.buttonNeuesSpiel);
        Button spielBeitretenButton = findViewById(R.id.buttonSpielBeitreten);
        ImageButton statistikButton = findViewById(R.id.buttonStatistik);
        ImageButton einstellungenButton = findViewById(R.id.buttonEinstellungen);
        Button beendenButton = findViewById(R.id.buttonBeenden);

        neuesSpielButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNeuesSpielButtonClick(v);
            }
        });

        // Füge einen OnClickListener hinzu, um auf Klicks auf den Button zu reagieren
        spielBeitretenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSpielBeitretenButtonClick(v);
            }
        });

        statistikButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStatistikButtonClick(v);
            }
        });

        einstellungenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEinstellungenButtonClick(v);
            }
        });

        beendenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBeendenButtonClick(v);
            }
        });
    }

    private void onNeuesSpielButtonClick(View v) {
        Intent intent = new Intent(this, Hauptspiel.class);

        startActivity(intent);
    }

    // In der Methode, die aufgerufen wird, wenn der "Spiel beitreten"-Button geklickt wird
    private void onSpielBeitretenButtonClick(View view) {
        // Erstelle einen Intent, um zur neuen Aktivität zu wechseln
        Intent intent = new Intent(this, SpielBeitreten.class); // Ersetze "ZielAktivitat" durch den Namen deiner Zielaktivität

        // Starte die neue Aktivität
        startActivity(intent);
    }

    private void onStatistikButtonClick(View view) {
        Intent intent = new Intent(this, Statistik.class);
        startActivity(intent);
    }

    private void onEinstellungenButtonClick(View view) {
        Intent intent = new Intent(this, Einstellungen.class);
        startActivity(intent);
    }

    private void onBeendenButtonClick(View view) {
        finish();

        finishAffinity();
    }

}