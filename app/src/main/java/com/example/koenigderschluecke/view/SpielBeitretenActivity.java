package com.example.koenigderschluecke.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.koenigderschluecke.R;
import com.example.koenigderschluecke.network.BluetoothConnector;
import com.example.koenigderschluecke.network.BluetoothConnectorImpl;

//TODO: Controller Auslagerung
public class SpielBeitretenActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.S)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spiel_beitreten);

        BluetoothConnector bluetoothConnector = new BluetoothConnectorImpl(this);
        bluetoothConnector.bluetoothAktivierung();

        Button zurueckZumHauptmenueSpielBeitretenButton = findViewById(R.id.zurueckZumHauptmenueSpielBeitretenButton);

        zurueckZumHauptmenueSpielBeitretenButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, StartbildschirmActivity.class);
            startActivity(intent);
        });
    }

}