package com.example.koenigderschluecke.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.koenigderschluecke.R;
import com.example.koenigderschluecke.controller.PersistenzController;
import com.example.koenigderschluecke.controller.PersistenzControllerImpl;

public class StatistikActivity extends AppCompatActivity {
    private PersistenzController persistenzController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistik);

        persistenzController = new PersistenzControllerImpl(this);

        //Erstellung der Elemente der Activity
        TextView statistikAnzahlGesamtSpiele = findViewById(R.id.textViewStatistikAnzahlGesamtSpiele);
        TextView anzahlGesamtKarten = findViewById(R.id.textViewStatistikAnzahlGesamtSpiele);
        Button statistikLoeschen = findViewById(R.id.buttonStatistikLoeschen);
        Button zurueckZumHauptmenueButton = findViewById(R.id.buttonZurueckZumHauptmenueStatistikSeite);

        statistikAnzahlGesamtSpiele.setText(persistenzController.ladeSpielendeStatistik());

        zurueckZumHauptmenueButton.setOnClickListener(v -> startActivity(new Intent(this, StartbildschirmActivity.class)));
        statistikLoeschen.setOnClickListener(statistikLoeschenAktion -> {
            persistenzController.resetStatistik();
            statistikAnzahlGesamtSpiele.setText(persistenzController.ladeSpielendeStatistik());
        });

        //TODO: Persistenz hier einfügen
    }
}
