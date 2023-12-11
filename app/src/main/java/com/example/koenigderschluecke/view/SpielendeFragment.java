package com.example.koenigderschluecke.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.koenigderschluecke.R;
import com.example.koenigderschluecke.controller.SpielController;

public class SpielendeFragment extends Fragment {
    private SpielController spielController;

    public void setSpielController(SpielController spielController) {
        this.spielController = spielController;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spielende, container, false);

        TextView anzahlBeendeteSpieleGesamtTextView = view.findViewById(R.id.textViewAnzahlBeendeteSpieleGesamt);
        TextView nameSpielerKoenigGezogenTextView = view.findViewById(R.id.textViewNameSpielerKoenigGezogen);
        TextView anzahlGezogenerKartenTextView = view.findViewById(R.id.textViewAnzahlGezogenerKarten);

        Button zurueckZumHauptmenueButton = view.findViewById(R.id.buttonZurueckZumHauptmenueSpielendeFragmentSeite);

        //TODO: Persi Controller
        anzahlBeendeteSpieleGesamtTextView.setText("TODO");
        nameSpielerKoenigGezogenTextView.setText(spielController.getNameAktuellerSpieler());
        //TODO: Direkt zu einem String returnen?
        anzahlGezogenerKartenTextView.setText(Integer.toString(spielController.getAnzahlGezogenerKarten()));

        zurueckZumHauptmenueButton.setOnClickListener(zurueckZumHauptmenueAktion -> {
            ((HauptspielActivity) getActivity()).zurueckZumHauptmenue();
        });

        return view;
    }
}
