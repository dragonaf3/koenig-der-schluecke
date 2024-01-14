package com.example.koenigderschluecke.view.spiel;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.example.koenigderschluecke.R;
import com.example.koenigderschluecke.controller.PersistenzController;
import com.example.koenigderschluecke.controller.PersistenzControllerImpl;
import com.example.koenigderschluecke.controller.SpielController;
import com.example.koenigderschluecke.controller.SpielControllerImpl;
import com.example.koenigderschluecke.model.SpielSingleton;
import com.example.koenigderschluecke.model.Spieler;
import com.example.koenigderschluecke.model.SpielerImpl;
import com.example.koenigderschluecke.view.StartbildschirmActivity;

import java.util.ArrayList;
import java.util.List;

//TODO: Fehlt vieles
public class HauptspielActivity extends FragmentActivity {
    private SpielController spielController;
    private PersistenzController persistenzController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hauptspiel);

        persistenzController = new PersistenzControllerImpl(this);

        try {
            spielController = new SpielControllerImpl();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (savedInstanceState == null) {
            KartenkreisFragment fragment = new KartenkreisFragment();
            fragment.setSpielController(spielController);

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }

    }

    public void naechsteRunde() {
        if (spielController.spielIstBeendet()) {
            wechselZuSpielendeFragment();
        } else {
            wechselZuKartenkreisFragment();
        }
    }

    public void karteGezogen() {
        wechselZuRegelFragment();
    }

    private void wechselZuKartenkreisFragment() {
        KartenkreisFragment kartenkreisFragment = new KartenkreisFragment();
        kartenkreisFragment.setSpielController(spielController);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, kartenkreisFragment)
                .commit();

    }

    public void zurueckZumHauptmenue() {
        spielController.beendeSpiel();

        startActivity(new Intent(this, StartbildschirmActivity.class));
    }

    private void wechselZuSpielendeFragment() {
        SpielendeFragment spielendeFragment = new SpielendeFragment();
        spielendeFragment.setSpielController(spielController);
        spielendeFragment.setPersistenzController(persistenzController);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, spielendeFragment)
                .commit();

    }

    private void wechselZuRegelFragment() {
        RegelFragment regelFragment = new RegelFragment();
        regelFragment.setSpielController(spielController);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, regelFragment)
                .commit();
    }

}
