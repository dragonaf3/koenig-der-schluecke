package com.example.koenigderschluecke.controller;

import com.example.koenigderschluecke.model.Karte;
import com.example.koenigderschluecke.model.Kartenwert;
import com.example.koenigderschluecke.model.Spiel;
import com.example.koenigderschluecke.model.SpielSingleton;

/**
 * Die Klasse SpielControllerImpl implementiert das Interface SpielController.
 * Sie verwaltet das Spiel und bietet Methoden zur Steuerung des Spiels an.
 */
public class SpielControllerImpl implements SpielController {

    // Das aktuelle Spiel, das von dieser Klasse verwaltet wird.
    private final Spiel spiel;

    /**
     * Der Konstruktor der Klasse SpielControllerImpl.
     * Er initialisiert das Spiel mit einer neuen Instanz von SpielImpl.
     */
    public SpielControllerImpl(Spiel spiel) {
        this.spiel = spiel;
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
    public String naechsteRunde() {
        if (spiel.getSpielerListe().isEmpty()) {
            throw new IllegalStateException("Es sind keine Spieler*innen im Spiel.");
        }

        //Durch die Verwendung des modulo-Operators wird sichergestellt,
        //dass die Spielerreihenfolge zyklisch ist,
        //also nach dem letzten Spieler wieder beim ersten Spieler fortgesetzt wird.
        spiel.setAktuellerSpielerIndex((spiel.getAktuellerSpielerIndex() + 1) % spiel.getSpielerListe().size());
        return String.valueOf(spiel.getAktuellerSpielerIndex());
    }

    @Override
    public String karteZiehen() throws KartenstapelLeerException {

        if (!spiel.getKartenstapel().isEmpty()) {
            Karte karte = spiel.getKartenstapel().remove(0);

            if (karte.getWert() == Kartenwert.KOENIG) {
                spiel.setGezogeneKoenige(spiel.getGezogeneKoenige() + 1);
            }
            return karte.toString();

        } else {
            throw new KartenstapelLeerException();
        }
    }
}
