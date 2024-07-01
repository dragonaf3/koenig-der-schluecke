package com.example.koenigderschluecke.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.koenigderschluecke.R;
import com.example.koenigderschluecke.controller.PersistenzController;
import com.example.koenigderschluecke.controller.PersistenzControllerImpl;

/**
 * Diese Activity zeigt die Statistik an. Es kann jederzeit zum Hauptmenü gegangen werden.
 */
public class StatistikActivity extends Activity {
    private PersistenzController persistenzController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistik);

        persistenzController = new PersistenzControllerImpl(this);

        //Erstellung der Elemente der Activity
        TextView statistikAnzahlGesamtSpiele = findViewById(R.id.textViewStatistikAnzahlGesamtSpiele);
        TextView anzahlGesamtKarten = findViewById(R.id.textViewAnzahlGesamtKarten);
        Button statistikLoeschen = findViewById(R.id.buttonStatistikLoeschen);
        Button zurueckZumHauptmenueButton = findViewById(R.id.buttonZurueckZumHauptmenueStatistikSeite);

        statistikAnzahlGesamtSpiele.setText(persistenzController.ladeSpielendeStatistik());
        anzahlGesamtKarten.setText(persistenzController.ladeGezogeneKarten());

        zurueckZumHauptmenueButton.setOnClickListener(v -> startActivity(new Intent(this, StartbildschirmActivity.class)));

        statistikLoeschen.setOnClickListener(statistikLoeschenAktion -> {
            persistenzController.resetStatistik();
            statistikAnzahlGesamtSpiele.setText(persistenzController.ladeSpielendeStatistik());
            anzahlGesamtKarten.setText(persistenzController.ladeGezogeneKarten());
        });

        //TODO: Persistenz hier einfügen
    }

    /**
     * Dient ausschließlich Testzwecke!
     */
    void setStatistik() {
        TextView statistikAnzahlGesamtSpiele = findViewById(R.id.textViewStatistikAnzahlGesamtSpiele);
        statistikAnzahlGesamtSpiele.setText("5");
    }
}
