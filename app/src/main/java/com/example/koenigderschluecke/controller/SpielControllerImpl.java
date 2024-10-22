package com.example.koenigderschluecke.controller;

import com.example.koenigderschluecke.model.Hopfenhacker;
import com.example.koenigderschluecke.model.Karte;
import com.example.koenigderschluecke.model.KuebelKoenig;
import com.example.koenigderschluecke.model.RauschRitter;
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
     * Er initialisiert das Spiel mit einer Instanz des SpielSingleton, welche zuvor vom LobbyController erstellt wurde.
     */
    public SpielControllerImpl() throws Exception {
        this.spiel = SpielSingleton.getInstanceOhneErstellen();
        //TODO: Exception Handling
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
            spiel.setAnzahlGezogenerKarten(spiel.getAnzahlGezogenerKarten() + 1);

            //TODO: ändern
            if (karte.getWert() == Hopfenhacker.KOENIG || karte.getWert() == RauschRitter.KOENIG || karte.getWert() == KuebelKoenig.KOENIG) {
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
    public String getAktuelleKarte() {
        return spiel.getAktuelleKarte().getSymbol().toString().toLowerCase() + spiel.getAktuelleKarte().getWert().toString().toLowerCase();
    }

    @Override
    public String getRegelAktuelleKarte() {
        return spiel.getAktuelleKarte().getRegel();
    }

    @Override
    public void naechsteRunde() throws IllegalArgumentException {
        if (spiel.getSpielerListe().isEmpty()) {
            throw new IllegalStateException("Es sind keine Spieler*innen im Spiel.");
        }

        if (!spielIstBeendet()) {
            //Durch die Verwendung des modulo-Operators wird sichergestellt,
            //dass die Spielerreihenfolge zyklisch ist,
            //also nach dem letzten Spieler wieder beim ersten Spieler fortgesetzt wird.
            spiel.setAktuellerSpielerIndex((spiel.getAktuellerSpielerIndex() + 1) % spiel.getSpielerListe().size());
        }

        //tu nichts
    }

    @Override
    public int getAnzahlGezogenerKarten() {
        return spiel.getAnzahlGezogenerKarten();
    }

    @Override
    public void beendeSpiel() {
        SpielSingleton.deleteInstance();
    }
}
