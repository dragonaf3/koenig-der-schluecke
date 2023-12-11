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
                return BitmapFactory.decodeResource(getResources(), R.drawable.herzzwei);
            }
            case "herzdrei" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.herzdrei);
            }
            case "herzvier" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.herzvier);
            }
            case "herzfuenf" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.herzfuenf);
            }
            case "herzsechs" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.herzsechs);
            }
            case "herzsieben" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.herzsieben);
            }
            case "herzacht" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.herzacht);
            }
            case "herzneun" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.herzneun);
            }
            case "herzzehn" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.herzzehn);
            }
            case "herzbube" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.herzbube);
            }
            case "herzdame" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.herzdame);
            }
            case "herzkoenig" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.herzkoenig);
            }
            case "herzass" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.herzass);
            }
            case "karozwei" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.karozwei);
            }
            case "karodrei" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.karodrei);
            }
            case "karovier" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.karovier);
            }
            case "karofuenf" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.karofuenf);
            }
            case "karosechs" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.karosechs);
            }
            case "karosieben" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.karosieben);
            }
            case "karoacht" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.karoacht);
            }
            case "karoneun" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.karoneun);
            }
            case "karozehn" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.karozehn);
            }
            case "karobube" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.karobube);
            }
            case "karodame" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.karodame);
            }
            case "karokoenig" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.karokoenig);
            }
            case "karoass" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.karoass);
            }
            case "pikzwei" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.pikzwei);
            }
            case "pikdrei" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.pikdrei);
            }
            case "pikvier" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.pikvier);
            }
            case "pikfuenf" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.pikfuenf);
            }
            case "piksechs" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.piksechs);
            }
            case "piksieben" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.piksieben);
            }
            case "pikacht" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.pikacht);
            }
            case "pikneun" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.pikneun);
            }
            case "pikzehn" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.pikzehn);
            }
            case "pikbube" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.pikbube);
            }
            case "pikdame" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.pikdame);
            }
            case "pikkoenig" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.pikkoenig);
            }
            case "pikass" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.pikass);
            }
            case "kreuzzwei" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.kreuzzwei);
            }
            case "kreuzdrei" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.kreuzdrei);
            }
            case "kreuzvier" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.kreuzvier);
            }
            case "kreuzfuenf" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.kreuzfuenf);
            }
            case "kreuzsechs" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.kreuzsechs);
            }
            case "kreuzsieben" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.kreuzsieben);
            }
            case "kreuzacht" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.kreuzacht);
            }
            case "kreuzneun" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.kreuzneun);
            }
            case "kreuzzehn" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.kreuzzehn);
            }
            case "kreuzbube" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.kreuzbube);
            }
            case "kreuzdame" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.kreuzdame);
            }
            case "kreuzkoenig" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.kreuzkoenig);
            }
            case "kreuzass" -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.kreuzass);
            }
            default -> {
                return BitmapFactory.decodeResource(getResources(), R.drawable.karterueckseite);
            }

        }
    }
}
