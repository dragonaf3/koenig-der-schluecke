package com.example.koenigderschluecke.model;

import org.junit.Test;

public class KarteTest {

    private Karte karte;

    @Test
    public void testGetFarbe() {
        karte = new Karte(Kartensymbol.HERZ, Kartenwert.ACHT);
        assertEquals(Kartensymbol.HERZ, karte.getFarbe());
    }

    @Test
    public void testGetRang() {
        karte = new Karte(Kartensymbol.HERZ, Kartenwert.ACHT);
        assertEquals(Kartenwert.ACHT, karte.getRang());
    }

    @Test
    public void testToString() {
        karte = new Karte(Kartensymbol.HERZ, Kartenwert.ACHT);
        System.out.println(karte);
    }
}