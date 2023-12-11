package com.example.koenigderschluecke.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.koenigderschluecke.R;
import com.example.koenigderschluecke.controller.SpielController;

public class KartenkreisFragment extends Fragment {
    private SpielController spielController;

    public void setSpielController(SpielController spielController) {
        this.spielController = spielController;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kartenkreis, container, false);

        TextView aktuellerSpielerTextView = view.findViewById(R.id.aktuellerSpieler);
        TextView gezogeneKoenigeTextView = view.findViewById(R.id.gezogeneKoenigeTextNumber);
        KartenStapelView kartenStapelView = view.findViewById(R.id.kartenStapelView);
        Button karteZiehenButton = view.findViewById(R.id.buttonKarteZiehen);

        aktuellerSpielerTextView.setText(spielController.getNameAktuellerSpieler());
        //TODO: Vielleicht als String returnen?
        gezogeneKoenigeTextView.setText(Integer.toString(spielController.getGezogeneKoenige()));
        kartenStapelView.setKartenStapel(spielController.getKartenstapel());

        karteZiehenButton.setOnClickListener(karteZiehenAktion -> {
            spielController.karteZiehen();
            //TODO: KartenkreisListener
        });

        return view;
    }
}

