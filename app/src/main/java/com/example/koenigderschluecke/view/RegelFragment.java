package com.example.koenigderschluecke.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.koenigderschluecke.R;
import com.example.koenigderschluecke.controller.SpielController;

public class RegelFragment extends Fragment {
    private SpielController spielController;

    public void setSpielController(SpielController spielController) {
        this.spielController = spielController;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_regel, container, false);

        TextView aktuellerSpielerTextView = view.findViewById(R.id.aktuellerSpieler);
        TextView regelZurKarteTextView = view.findViewById(R.id.regelZurKarte);
        ImageView karteImageView = view.findViewById(R.id.imageViewKartenbild);
        Button naechsteRundeButton = view.findViewById(R.id.buttonNaechsteRunde);

        aktuellerSpielerTextView.setText(spielController.getNameAktuellerSpieler());
        karteImageView.setImageBitmap(setzeKartenbild());
        regelZurKarteTextView.setText(spielController.getRegelAktuelleKarte());

        naechsteRundeButton.setOnClickListener(nächsteRundeAktion -> {
            spielController.naechsteRunde();
            //TODO: Fragment wechseln Listener?
        });

        return view;
    }

    private Bitmap setzeKartenbild() {
        switch (spielController.getAktuelleKarte()) {
            case "herzzwei" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.herz2);
            }
            case "herzdrei" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.herzdrei);
            }
            case "herzvier" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.herzvier);
            }
        }
    }
}
