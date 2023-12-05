package com.example.koenigderschluecke.controller;

import com.example.koenigderschluecke.model.Spiel;
import com.example.koenigderschluecke.model.SpielImpl;
import com.example.koenigderschluecke.model.Spieler;

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
    public SpielControllerImpl() {
        this.spiel = new SpielImpl();
    }

    @Override
    public void starteSpiel() {

    }

    @Override
    public void beendeSpiel() {

    }

    @Override
    public void addSpieler(Spieler spieler) {
        spiel.getSpielerListe().add(spieler);
    }

    @Override
    public void entferneSpieler(Spieler spieler) {
        spiel.getSpielerListe().remove(spieler);
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

    @Override
    public String karteZiehen() throws KartenstapelLeerException {

        if (!spiel.getKartenstapel().isEmpty()) {
            return spiel.getKartenstapel().remove(0).toString(); // Entfernt und gibt die oberste Karte zurück
        } else {
            throw new KartenstapelLeerException();
        }

    }
}
