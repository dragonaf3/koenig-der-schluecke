package com.example.koenigderschluecke.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HopfenhackerTest {

    @Test
    void getBeschreibungGibtRichtigeBeschreibungZurueck() {
        assertEquals("Trinke einen Schluck.", Hopfenhacker.EINS.getBeschreibung());
        assertEquals("Trinke zwei Schlücke.", Hopfenhacker.ZWEI.getBeschreibung());
        //TODO: Alle Beschreibungen
    }

    @Test
    void getBeschreibungGibtNichtNullZurueck() {
        for (Hopfenhacker hopfenhacker : Hopfenhacker.values()) {
            assertNotNull(hopfenhacker.getBeschreibung());
        }
    }

    @Test
    void getBeschreibungGibtNichtLeerZurueck() {
        for (Hopfenhacker hopfenhacker : Hopfenhacker.values()) {
            assertNotEquals("", hopfenhacker.getBeschreibung());
        }
    }
}