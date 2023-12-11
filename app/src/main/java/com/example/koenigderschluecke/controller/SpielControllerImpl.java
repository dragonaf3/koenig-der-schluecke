package com.example.koenigderschluecke.controller;

import com.example.koenigderschluecke.exceptions.KartenstapelLeerException;
import com.example.koenigderschluecke.model.Karte;
import com.example.koenigderschluecke.model.Kartenwert;
import com.example.koenigderschluecke.model.Spiel;
import com.example.koenigderschluecke.model.SpielSingleton;

import java.util.List;

/**
 * Die Klasse SpielControllerImpl implementiert das Interface SpielController.
 * Sie verwaltet das Spiel und bietet Methoden zur Steuerung des Spiels an.
 */
public class SpielControllerImpl implements SpielController {

    // Das aktuelle Spiel, das von dieser Klasse verwaltet wird.
    private final Spiel spiel;

    /**
     * Der Konstruktor der Klasse SpielControllerImpl.
     * Er initialisiert das Spiel mit einer neuen Instanz von SpielSingelton.
     */
    public SpielControllerImpl() {
        this.spiel = SpielSingleton.getSpielInstance();
    }

    @Override
    public boolean spielIstBeendet() {
        if (spiel.getGezogeneKoenige() == 4) {
            return true;
        }

        if (spiel.getKartenstapel().size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Karte> getKartenstapel() {
        return spiel.getKartenstapel();
    }

    @Override
    public int getGezogeneKoenige() {
        return spiel.getGezogeneKoenige();
    }

    @Override
    public void karteZiehen() {

        if (!spiel.getKartenstapel().isEmpty()) {
            Karte karte = spiel.getKartenstapel().remove(0);

            if (karte.getWert() == Kartenwert.KOENIG) {
                spiel.setGezogeneKoenige(spiel.getGezogeneKoenige() + 1);
            }
            spiel.setAktuelleKarte(karte);

        } else {
            //Nichts tun
        }
    }

    @Override
    public String getNameAktuellerSpieler() {
        return spiel.getSpielerListe().get(spiel.getAktuellerSpielerIndex()).getName();
    }

    @Override
    public Karte getAktuelleKarte() {
        return spiel.getAktuelleKarte();
    }

    //TODO: Regel Mechanik muss noch implementiert werden!
    @Override
    public String getRegelAktuelleKarte() {
        return "Regel";
    }

    @Override
    public void naechsteRunde() {
        if (spiel.getSpielerListe().isEmpty()) {
            throw new IllegalStateException("Es sind keine Spieler*innen im Spiel.");
        }

        //Durch die Verwendung des modulo-Operators wird sichergestellt,
        //dass die Spielerreihenfolge zyklisch ist,
        //also nach dem letzten Spieler wieder beim ersten Spieler fortgesetzt wird.
        spiel.setAktuellerSpielerIndex((spiel.getAktuellerSpielerIndex() + 1) % spiel.getSpielerListe().size());
    }
}
