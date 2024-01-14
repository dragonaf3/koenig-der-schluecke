package com.example.koenigderschluecke.controller;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Implementierung des PersistenzControllers.
 * Diese Klasse ist verantwortlich für das Laden und Speichern von Spielstatistiken.
 */
public class PersistenzControllerImpl implements PersistenzController {
    public static final String DATEINAME = "spielStatistik.txt";
    private Context context;
    private int anzahlGezogeneKarten;
    private int anzahlGespielteSpiele;

    /**
     * Konstruktor für PersistenzControllerImpl.
     *
     * @param context Kontext der Anwendung.
     */
    public PersistenzControllerImpl(Context context) {
        this.context = context;
        ladeStatistik();
    }



    /**
     * Gibt die Anzahl der gezogenen Karten zurück. Dient zum testen.
     *
     * @return Anzahl der gezogenen Karten.
     */
    int getAnzahlGezogeneKarten() {
        return anzahlGezogeneKarten;
    }

    /**
     * Gibt die Anzahl der gespielten Spiele zurück. Dient zum testen.
     *
     * @return Anzahl der gespielten Spiele.
     */
    int getAnzahlGespielteSpiele() {
        return anzahlGespielteSpiele;
    }

    /**
     * Speichert die Statistik.
     *
     * @param anzahlGezogeneKartenImAktuellenSpiel Anzahl der im aktuellen Spiel gezogenen Karten.
     */
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

    /**
     * Lädt die Statistik.
     */
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

    /**
     * Lädt die Statistik am Spielende.
     *
     * @return Anzahl der gespielten Spiele als String.
     */
    @Override
    public String ladeSpielendeStatistik() {
        return Integer.toString(anzahlGespielteSpiele);
    }

    /**
     * Setzt die Statistik zurück.
     */
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