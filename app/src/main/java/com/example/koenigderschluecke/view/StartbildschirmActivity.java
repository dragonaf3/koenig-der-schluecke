package com.example.koenigderschluecke.view;

import androidx.annotation.RequiresApi;


import android.app.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.koenigderschluecke.R;
import com.example.koenigderschluecke.view.lobby.LobbyActivity;
import com.example.koenigderschluecke.view.regelsets.RuleSetActivity;

public class StartbildschirmActivity extends Activity {

    @RequiresApi(api = Build.VERSION_CODES.S)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startbildschirm);

        //Erstellung der Elemente der Activity
        Button neuesSpielButton = findViewById(R.id.buttonNeuesSpiel);
        Button regelSetButton = findViewById(R.id.buttonEigeneRegeln);
        ImageButton statistikButton = findViewById(R.id.buttonStatistik);
        ImageButton einstellungenButton = findViewById(R.id.buttonEinstellungen);
        Button beendenButton = findViewById(R.id.buttonBeenden);

        //Definieren der OnClickListener
        neuesSpielButton.setOnClickListener(v -> startActivity(new Intent(this, LobbyActivity.class)));
        //TODO: Ändern!
        regelSetButton.setOnClickListener(v -> startActivity(new Intent(this, RuleSetActivity.class)));
        statistikButton.setOnClickListener(v -> startActivity(new Intent(this, StatistikActivity.class)));
        einstellungenButton.setOnClickListener(v -> startActivity(new Intent(this, EinstellungenActivity.class)));
        beendenButton.setOnClickListener(v -> {
            finish();
            finishAffinity();
        });
    }
}