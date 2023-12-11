package com.example.koenigderschluecke.model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class KarteTest {

    private Karte karte;

    @Test
    public void testGetFarbe() {
        karte = new KarteImpl(RauschRitter.ACHT, Kartensymbol.HERZ);
        assertEquals(Kartensymbol.HERZ, karte.getSymbol());
    }

    @Test
    public void testGetRang() {
        karte = new KarteImpl(RauschRitter.ACHT, Kartensymbol.HERZ);
        assertEquals(RauschRitter.ACHT, karte.getWert());
    }

    @Test
    public void testToString() {
        karte = new KarteImpl(RauschRitter.ACHT, Kartensymbol.HERZ);
        System.out.println(karte);
    }
}