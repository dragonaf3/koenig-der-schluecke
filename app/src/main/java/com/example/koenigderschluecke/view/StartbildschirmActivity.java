package com.example.koenigderschluecke.view;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;


import android.Manifest;
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

        //Permission Setzen hier, geht sonst nicht??
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.BLUETOOTH_CONNECT}, 2);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);

        //Erstellung der Elemente der Activity
        Button neuesSpielButton = findViewById(R.id.buttonNeuesSpiel);
        Button spielBeitretenButton = findViewById(R.id.buttonSpielBeitreten);
        ImageButton statistikButton = findViewById(R.id.buttonStatistik);
        ImageButton einstellungenButton = findViewById(R.id.buttonEinstellungen);
        Button beendenButton = findViewById(R.id.buttonBeenden);

        //Definieren der OnClickListener
        neuesSpielButton.setOnClickListener(v -> startActivity(new Intent(this, LobbyActivity.class)));
        //TODO: Ändern!
        spielBeitretenButton.setOnClickListener(v -> startActivity(new Intent(this, RuleSetActivity.class)));
        statistikButton.setOnClickListener(v -> startActivity(new Intent(this, StatistikActivity.class)));
        einstellungenButton.setOnClickListener(v -> startActivity(new Intent(this, EinstellungenActivity.class)));
        beendenButton.setOnClickListener(v -> {
            finish();
            finishAffinity();
        });
    }
}