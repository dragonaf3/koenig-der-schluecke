package com.example.koenigderschluecke.spiel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class KarteTest {

    private Karte karte;

    @Test
    public void testGetFarbe() {
        karte = new Karte(FarbeDerKarte.HERZ, RangDerKarte.ACHT);
        assertEquals(FarbeDerKarte.HERZ, karte.getFarbe());
    }

    @Test
    public void testGetRang() {
        karte = new Karte(FarbeDerKarte.HERZ, RangDerKarte.ACHT);
        assertEquals(RangDerKarte.ACHT, karte.getRang());
    }

    @Test
    public void testToString() {
        karte = new Karte(FarbeDerKarte.HERZ, RangDerKarte.ACHT);
        System.out.println(karte);
    }
}