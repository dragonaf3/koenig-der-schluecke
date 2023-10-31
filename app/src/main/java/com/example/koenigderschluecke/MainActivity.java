package com.example.koenigderschluecke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startbildschirm);

        // Finde den "Spiel beitreten"-Button in deinem Layout
        Button spielBeitretenButton = findViewById(R.id.buttonSpielBeitreten);
        ImageButton statistikButton = findViewById(R.id.buttonStatistik);
        Button beendenButton = findViewById(R.id.buttonBeenden);

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

        beendenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBeendenButtonClick(v);
            }
        });
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

    private void onBeendenButtonClick(View view) {
        finish();

        finishAffinity();
    }

}