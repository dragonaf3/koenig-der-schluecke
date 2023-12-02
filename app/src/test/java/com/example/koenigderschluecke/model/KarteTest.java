package com.example.koenigderschluecke.model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class KarteTest {

    private Karte karte;

    @Test
    public void testGetFarbe() {
        karte = new KarteImpl(Kartenwert.ACHT, Kartensymbol.HERZ);
        assertEquals(Kartensymbol.HERZ, karte.getSymbol());
    }

    @Test
    public void testGetRang() {
        karte = new KarteImpl(Kartenwert.ACHT, Kartensymbol.HERZ);
        assertEquals(Kartenwert.ACHT, karte.getWert());
    }

    @Test
    public void testToString() {
        karte = new KarteImpl(Kartenwert.ACHT, Kartensymbol.HERZ);
        System.out.println(karte);
    }
}