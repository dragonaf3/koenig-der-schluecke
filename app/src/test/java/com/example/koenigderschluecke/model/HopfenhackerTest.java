package com.example.koenigderschluecke.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Die Klasse HopfenhackerTest testet die Klasse Hopfenhacker.
 */
class HopfenhackerTest {

    @Test
    void getBeschreibungGibtRichtigeBeschreibungZurueck() {
        assertEquals("Trinke einen Schluck.", Hopfenhacker.EINS.getBeschreibung());
        assertEquals("Trinke zwei Schlücke.", Hopfenhacker.ZWEI.getBeschreibung());
        assertEquals("Trinke drei Schlücke.", Hopfenhacker.DREI.getBeschreibung());
        assertEquals("Verteile vier Schlücke.", Hopfenhacker.VIER.getBeschreibung());
        assertEquals("Wähle einen Trinkpartner, ihr trinkt beide fünf Schlücke.", Hopfenhacker.FUENF.getBeschreibung());
        assertEquals("Starte einen Reimrunde. Jeder Spielende muss ein Reimwort sagen. Derjenige, der keinen Reim findet oder bereits gesagte Wörter wiederholt, trinkt sechs Schlücke.", Hopfenhacker.SECHS.getBeschreibung());
        assertEquals("Lege deinen Zeigefinger auf deine Nase. Derjenige, der es dir als letztes nachmacht, muss trinken.", Hopfenhacker.SIEBEN.getBeschreibung());
        assertEquals("Alle Männer und nichtbinäre Personen trinken.", Hopfenhacker.ACHT.getBeschreibung());
        assertEquals("Alle Frauen und nichtbinäre Personen trinken.", Hopfenhacker.NEUN.getBeschreibung());
        assertEquals("Alle müssen trinken.", Hopfenhacker.ZEHN.getBeschreibung());
        assertEquals("Du darfst eine Regel aufstellen, die für den Rest des Spiels befolgt werden muss. Wird die Regel nicht beachtet, muss derjenige einen Schluck trinken.", Hopfenhacker.BUBE.getBeschreibung());
        assertEquals("Du bist der Questionmaster, bis die nächste Dame gezogen wird. Jeder, der dir eine Frage beantwortet, muss trinken.", Hopfenhacker.DAME.getBeschreibung());
        assertEquals("Du bist der König des Spiels. Bestimme eine Person, die immer trinken muss, wenn du trinkst.", Hopfenhacker.KOENIG.getBeschreibung());
        assertEquals("Wasserfall! Du fängst an zu trinken und im Uhrzeigersinn setzt jeder Spielende nacheinander zum Trinken an. Setzt du ab, darf im Uhrzeigersinn auch nacheinander abgesetzt werden.", Hopfenhacker.ASS.getBeschreibung());
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