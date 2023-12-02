package com.example.koenigderschluecke.model;

import org.junit.Test;

public class KartenKreisTest {

    @Test
    public void karteZiehen() {
        KartenKreis kartenKreis = new KartenKreis();
        kartenKreis.kartenkreisBefuellen();

        System.out.println(kartenKreis.getKartenkreis().size());
        System.out.println(kartenKreis.karteZiehen());
        System.out.println(kartenKreis.getKartenkreis().size());

    }

    @Test
    public void kartenkreisBefuellen() {
        KartenKreis kartenKreis = new KartenKreis();
        kartenKreis.kartenkreisBefuellen();

        System.out.println(kartenKreis);
    }
}