package com.example.koenigderschluecke.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Die Klasse RauschRitterTest testet die Klasse RauschRitter.
 */
class RauschRitterTest {

    @Test
    public void testBeschreibung() {
        assertEquals("Schlücke in Höhe der Karte verteilen.", RauschRitter.ZWEI.getBeschreibung());
        assertEquals("Schlücke in Höhe der Karte verteilen.", RauschRitter.DREI.getBeschreibung());
        assertEquals("Schlücke in Höhe der Karte verteilen.", RauschRitter.VIER.getBeschreibung());
        assertEquals("Schlücke in Höhe der Karte verteilen.", RauschRitter.FUENF.getBeschreibung());
        assertEquals("Der linke Sitznachbar von dir muss trinken.", RauschRitter.SECHS.getBeschreibung());
        assertEquals("Der rechte Sitznachbar von dir muss trinken.", RauschRitter.SIEBEN.getBeschreibung());
        assertEquals("Alle Männer und nichtbinäre Personen trinken.", RauschRitter.ACHT.getBeschreibung());
        assertEquals("Alle Frauen und nichtbinäre Personen trinken.", RauschRitter.NEUN.getBeschreibung());
        assertEquals("Alle müssen trinken.", RauschRitter.ZEHN.getBeschreibung());
        assertEquals("Du darfst eine Regel aufstellen, die für den Rest des Spiels befolgt werden muss. Wird die Regel nicht beachtet, muss derjenige einen Schluck trinken.", RauschRitter.BUBE.getBeschreibung());
        assertEquals("Du bist der Questionmaster, bis die nächste Dame gezogen wird. Jeder, der dir eine Frage beantwortet, muss trinken.", RauschRitter.DAME.getBeschreibung());
        assertEquals("Fülle ein beliebiges Getränk in das Königsglass. Wenn der letzte König gezogen wird, muss das Glas ausgetrunken werden.", RauschRitter.KOENIG.getBeschreibung());
        assertEquals("Wasserfall! Du fängst an zu trinken und im Uhrzeigersinn setzt jeder Spielende nacheinander zum Trinken an. Setzt du ab, darf im Uhrzeigersinn auch nacheinander abgesetzt werden.", RauschRitter.ASS.getBeschreibung());
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