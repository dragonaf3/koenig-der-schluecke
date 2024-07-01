package com.example.koenigderschluecke.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Die Klasse KuebelKoenigTest testet die Klasse KuebelKoenig.
 */
class KuebelKoenigTest {

    @Test
    public void testGetBeschreibung() {
        assertEquals("Trinke einen Schluck.", KuebelKoenig.EINS.getBeschreibung());
        assertEquals("Verteile zwei Schlücke.", KuebelKoenig.ZWEI.getBeschreibung());
        assertEquals("Trinke drei Schlücke.", KuebelKoenig.DREI.getBeschreibung());
        assertEquals("Alle Spielenden trinken vier Schlücke.", KuebelKoenig.VIER.getBeschreibung());
        assertEquals("Der Spielende links von dir trinkt fünf Schlücke.", KuebelKoenig.FUENF.getBeschreibung());
        assertEquals("Wähle einen Trinkpartner, ihr trinkt beide sechs Schlücke.", KuebelKoenig.SECHS.getBeschreibung());
        assertEquals("Der Spielende rechts von dir trinkt sieben Schlücke.", KuebelKoenig.SIEBEN.getBeschreibung());
        assertEquals("Mache eine Regel. Jeder, der dagegen verstößt, trinkt acht Schlücke.", KuebelKoenig.ACHT.getBeschreibung());
        assertEquals("Hebe eine Hand und fordere einen anderen Spieler auf, dir ein High-Five zu geben. Alle, die sich verspäten oder keinen Partner finden, trinken neun Schlücke.", KuebelKoenig.NEUN.getBeschreibung());
        assertEquals("Alle Spielenden müssen aufstehen und zehn Schlücke trinken.", KuebelKoenig.ZEHN.getBeschreibung());
        assertEquals("Alle Männer und nichtbinäre Personen trinken einen Schluck.", KuebelKoenig.BUBE.getBeschreibung());
        assertEquals("Alle Frauen und nichtbinäre Personen trinken einen Schluck.", KuebelKoenig.DAME.getBeschreibung());
        assertEquals("Du bist der KübelKönig. Bestimme einen Spieler, der immer trinken muss, wenn du trinkst.", KuebelKoenig.KOENIG.getBeschreibung());
        assertEquals("Starte einen Kübelrunde! Alle Spieler müssen nacheinander ein Getränk in den Gemeinschaftskübel schütten. Der Spieler, der den Kübel überlaufen lässt, muss ihn austrinken.", KuebelKoenig.ASS.getBeschreibung());
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