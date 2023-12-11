package com.example.koenigderschluecke.controller;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PersistenzControllerImpl implements PersistenzController {
    private Context context;
    private static final String DATEINAME = "spielStatistik.txt";
    private int anzahlGezogeneKarten;
    private int anzahlGespielteSpiele;

    public PersistenzControllerImpl(Context context) {
        this.context = context;
        ladeStatistik();
    }

    @Override
    public void speichereStatistik(int anzahlGezogeneKartenImAktuellenSpiel) {
        anzahlGezogeneKarten = anzahlGezogeneKarten + anzahlGezogeneKartenImAktuellenSpiel;
        anzahlGespielteSpiele++;

        try {
            FileOutputStream fileOutputStream = context.openFileOutput(DATEINAME, Context.MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(anzahlGezogeneKarten + "\n" + anzahlGespielteSpiele + "\n");
            outputStreamWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void ladeStatistik() {
        try {
            FileInputStream fileInputStream = context.openFileInput(DATEINAME);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String gezogeneKartenZeile = bufferedReader.readLine();
            String gespielteSpieleZeile = bufferedReader.readLine();

            if (gezogeneKartenZeile != null) {
                anzahlGezogeneKarten = Integer.parseInt(gezogeneKartenZeile);
            }
            if (gespielteSpieleZeile != null) {
                anzahlGespielteSpiele = Integer.parseInt(gespielteSpieleZeile);
            }

            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String ladeSpielendeStatistik() {
        return Integer.toString(anzahlGespielteSpiele);
    }

    @Override
    public void resetStatistik() {
        anzahlGezogeneKarten = 0;
        anzahlGespielteSpiele = 0;

        try {
            FileOutputStream fileOutputStream = context.openFileOutput(DATEINAME, Context.MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(anzahlGezogeneKarten + "\n" + anzahlGespielteSpiele + "\n");
            outputStreamWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
