package com.example.koenigderschluecke;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class SpielBeitreten extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spiel_beitreten); // Hier musst du das Layout für deine SpielBeitreten-Aktivität setzen

        // Finde den "Spiel beitreten"-Button in deinem Layout
        Button zurueckZumHauptmenueButton = findViewById(R.id.buttonZurueckZumHauptmenue);

        // Füge einen OnClickListener hinzu, um auf Klicks auf den Button zu reagieren
        zurueckZumHauptmenueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onZurueckZumHauptmenue(v);
            }
        });
    }

    // In der Methode, die aufgerufen wird, wenn der "Spiel beitreten"-Button geklickt wird
    public void onZurueckZumHauptmenue(View view) {
        // Erstelle einen Intent, um zur neuen Aktivität zu wechseln
        Intent intent = new Intent(this, MainActivity.class); // Ersetze "ZielAktivitat" durch den Namen deiner Zielaktivität

        // Starte die neue Aktivität
        startActivity(intent);
    }
}