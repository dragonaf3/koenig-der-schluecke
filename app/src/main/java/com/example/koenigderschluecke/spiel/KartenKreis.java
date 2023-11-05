package com.example.koenigderschluecke.spiel;

import java.util.ArrayList;

public class KartenKreis {
    private ArrayList<Karte> kartenkreis;

    public KartenKreis() {
        this.kartenkreis = new ArrayList<>();
    }

    public ArrayList<Karte> getKartenkreis() {
        return kartenkreis;
    }

    public Karte karteZiehen() {
        int randomIndex = (int) (Math.random() * kartenkreis.size());
        return kartenkreis.remove(randomIndex);
    }

    public void kartenkreisBefuellen() {
        for (FarbeDerKarte farbeDerKarte : FarbeDerKarte.values()) {
            for (RangDerKarte rangDerKarte : RangDerKarte.values()) {
                Karte karte = new Karte(farbeDerKarte, rangDerKarte);
                kartenkreis.add(karte);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Karte karte : kartenkreis) {
            sb.append(karte.toString()).append("\n");
        }
        return sb.toString();
    }
}
