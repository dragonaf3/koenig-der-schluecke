package com.example.koenigderschluecke.view.spiel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.koenigderschluecke.R;
import com.example.koenigderschluecke.controller.PersistenzController;
import com.example.koenigderschluecke.controller.SpielController;
import com.example.koenigderschluecke.view.spiel.HauptspielActivity;

public class SpielendeFragment extends Fragment {
    private SpielController spielController;
    private PersistenzController persistenzController;

    public void setSpielController(SpielController spielController) {
        this.spielController = spielController;
    }

    public void setPersistenzController(PersistenzController persistenzController) {
        this.persistenzController = persistenzController;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spielende, container, false);

        TextView anzahlBeendeteSpieleGesamtTextView = view.findViewById(R.id.textViewAnzahlBeendeteSpieleGesamt);
        TextView nameSpielerKoenigGezogenTextView = view.findViewById(R.id.textViewNameSpielerKoenigGezogen);
        TextView anzahlGezogenerKartenTextView = view.findViewById(R.id.textViewAnzahlGezogenerKarten);

        Button zurueckZumHauptmenueButton = view.findViewById(R.id.buttonZurueckZumHauptmenueSpielendeFragmentSeite);

        persistenzController.speichereStatistik(spielController.getAnzahlGezogenerKarten());

        anzahlBeendeteSpieleGesamtTextView.setText(persistenzController.ladeSpielendeStatistik());
        nameSpielerKoenigGezogenTextView.setText(spielController.getNameAktuellerSpieler());
        //TODO: Direkt zu einem String returnen?
        anzahlGezogenerKartenTextView.setText(Integer.toString(spielController.getAnzahlGezogenerKarten()));

        zurueckZumHauptmenueButton.setOnClickListener(zurueckZumHauptmenueAktion -> {
            ((HauptspielActivity) getActivity()).zurueckZumHauptmenue();
        });

        return view;
    }
}
