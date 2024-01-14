package com.example.koenigderschluecke.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

class SpielSingletonTest {
    private List<Spieler> spielerListe;
    private KarteImpl testKarte;

    @BeforeEach
    void setUp() {
        spielerListe = Arrays.asList(new SpielerImpl("Max"), new SpielerImpl("Eva"));
        testKarte = new KarteImpl(RauschRitter.ASS, Kartensymbol.HERZ); //RauschRitter ist getestet
        // Löschen der Singleton-Instanz vor jedem Test
        SpielSingleton.deleteInstance();
    }

    @AfterEach
    void tearDown() {
        // Löschen der Singleton-Instanz nach jedem Test
        SpielSingleton.deleteInstance();
    }

    @Test
    void testGetSpielInstanceCreatesNewInstance() {
        Spiel spiel = SpielSingleton.getSpielInstance("RauschRitter", spielerListe);
        assertNotNull(spiel);
        // Teste, ob die Spielerliste korrekt initialisiert wurde
        assertEquals(2, spiel.getSpielerListe().size());
        assertEquals("Max", spiel.getSpielerListe().get(0).getName());
        assertEquals("Eva", spiel.getSpielerListe().get(1).getName());
    }

    @Test
    void testGetInstanceOhneErstellenWithoutInstance() {
        assertThrows(Exception.class, () -> {
            SpielSingleton.getInstanceOhneErstellen();
        });
        // TODO: Nach der Verbesserung der Exception anpassen
    }

    @Test
    void testGetInstanceOhneErstellenWithExistingInstance() throws Exception {
        Spiel spiel = SpielSingleton.getSpielInstance("RauschRitter", spielerListe);
        assertNotNull(SpielSingleton.getInstanceOhneErstellen());
        assertEquals(spiel, SpielSingleton.getInstanceOhneErstellen());
    }

    @Test
    void testDeleteInstance() throws Exception {
        SpielSingleton.getSpielInstance("RauschRitter", spielerListe);
        assertNotNull(SpielSingleton.getInstanceOhneErstellen());
        SpielSingleton.deleteInstance();
        assertThrows(Exception.class, () -> {
            SpielSingleton.getInstanceOhneErstellen();
        });
    }

    @Test
    void testSetAndGetAktuelleKarte() {
        Spiel spiel = SpielSingleton.getSpielInstance("RauschRitter", spielerListe);
        spiel.setAktuelleKarte(testKarte);
        assertEquals(testKarte, spiel.getAktuelleKarte());
    }

    @Test
    void testSetAndGetAnzahlGezogenerKarten() {
        Spiel spiel = SpielSingleton.getSpielInstance("RauschRitter", spielerListe);
        spiel.setAnzahlGezogenerKarten(5);
        assertEquals(5, spiel.getAnzahlGezogenerKarten());
    }

    @Test
    void testSetAndGetGezogeneKoenige() {
        Spiel spiel = SpielSingleton.getSpielInstance("RauschRitter", spielerListe);
        spiel.setGezogeneKoenige(2);
        assertEquals(2, spiel.getGezogeneKoenige());
    }

    @Test
    void testSetAndGetAktuellerSpielerIndex() {
        Spiel spiel = SpielSingleton.getSpielInstance("RauschRitter", spielerListe);
        spiel.setAktuellerSpielerIndex(1);
        assertEquals(1, spiel.getAktuellerSpielerIndex());
    }

    @Test
    void testInitialisiereKartenstapelRauschRitter() {
        Spiel spiel = SpielSingleton.getSpielInstance("RauschRitter", spielerListe);
        spiel.initialisiereKartenstapelMitBestimmtenRegelSet("RauschRitter");
        List<Karte> kartenstapel = spiel.getKartenstapel();
        assertNotNull(kartenstapel);
        assertFalse(kartenstapel.isEmpty());
        // Überprüfen, ob die korrekte Anzahl von Karten im Stapel ist
        assertEquals(RauschRitter.values().length * Kartensymbol.values().length, kartenstapel.size());

        //Überprüfen, ob alle Karten im Stapel sind
        EnumSet<RauschRitter> erwarteteRauschRitterWerte = EnumSet.allOf(RauschRitter.class);
        EnumSet<Kartensymbol> erwarteteKartensymbole = EnumSet.allOf(Kartensymbol.class);

        for (Karte karte : kartenstapel) {
            assertTrue(erwarteteRauschRitterWerte.contains(karte.getWert()));
            assertTrue(erwarteteKartensymbole.contains(karte.getSymbol()));
        }
    }

    @Test
    void testInitialisiereKartenstapelHopfenhacker() {
        Spiel spiel = SpielSingleton.getSpielInstance("Hopfenhacker", spielerListe);
        spiel.initialisiereKartenstapelMitBestimmtenRegelSet("Hopfenhacker");
        List<Karte> kartenstapel = spiel.getKartenstapel();
        assertNotNull(kartenstapel);
        assertFalse(kartenstapel.isEmpty());
        assertEquals(Hopfenhacker.values().length * Kartensymbol.values().length, kartenstapel.size());

        //Überprüfen, ob alle Karten im Stapel sind
        EnumSet<Hopfenhacker> erwarteteRauschRitterWerte = EnumSet.allOf(Hopfenhacker.class);
        EnumSet<Kartensymbol> erwarteteKartensymbole = EnumSet.allOf(Kartensymbol.class);

        for (Karte karte : kartenstapel) {
            assertTrue(erwarteteRauschRitterWerte.contains(karte.getWert()));
            assertTrue(erwarteteKartensymbole.contains(karte.getSymbol()));
        }
    }

    @Test
    void testInitialisiereKartenstapelKuebelKoenig() {
        Spiel spiel = SpielSingleton.getSpielInstance("KuebelKoenig", spielerListe);
        spiel.initialisiereKartenstapelMitBestimmtenRegelSet("KuebelKoenig");
        List<Karte> kartenstapel = spiel.getKartenstapel();
        assertNotNull(kartenstapel);
        assertFalse(kartenstapel.isEmpty());
        assertEquals(KuebelKoenig.values().length * Kartensymbol.values().length, kartenstapel.size());

        //Überprüfen, ob alle Karten im Stapel sind
        EnumSet<KuebelKoenig> erwarteteRauschRitterWerte = EnumSet.allOf(KuebelKoenig.class);
        EnumSet<Kartensymbol> erwarteteKartensymbole = EnumSet.allOf(Kartensymbol.class);

        for (Karte karte : kartenstapel) {
            assertTrue(erwarteteRauschRitterWerte.contains(karte.getWert()));
            assertTrue(erwarteteKartensymbole.contains(karte.getSymbol()));
        }
    }

    @Test
    void testInitialisiereKartenstapelMitUnbekanntemRegelSet() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Spiel spiel = SpielSingleton.getSpielInstance("KuebelKoenig", spielerListe);
            spiel.initialisiereKartenstapelMitBestimmtenRegelSet("UnbekanntesRegelSet");
        });
        assertEquals("Regelset nicht gefunden.", exception.getMessage());
    }
}