package com.example.koenigderschluecke.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.koenigderschluecke.model.Karte;
import com.example.koenigderschluecke.model.Kartensymbol;
import com.example.koenigderschluecke.model.KuebelKoenig;
import com.example.koenigderschluecke.model.RauschRitter;
import com.example.koenigderschluecke.model.Spiel;
import com.example.koenigderschluecke.model.SpielSingleton;
import com.example.koenigderschluecke.model.Spieler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse testet die SpielControllerImpl Klasse.
 */
class SpielControllerImplTest {

    @Mock
    private Spiel spielMock;
    @Mock
    private Karte karte;
    @Mock
    private Spieler spieler;
    private SpielController spielController;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        SpielSingleton.setInstance(spielMock); // Setzen der Singleton-Instanz auf das Mock-Objekt, die set Methode sollte nach dem testen entfernt werden!
        spielController = new SpielControllerImpl();
    }

    @Test
    void testSpielIstBeendet() {
        when(spielMock.getGezogeneKoenige()).thenReturn(4);
        assertTrue(spielController.spielIstBeendet());

        when(spielMock.getGezogeneKoenige()).thenReturn(3);
        when(spielMock.getKartenstapel()).thenReturn(new ArrayList<>());
        assertTrue(spielController.spielIstBeendet());

        when(spielMock.getGezogeneKoenige()).thenReturn(2);
        List<Karte> stapel = new ArrayList<>();
        stapel.add(mock(Karte.class));
        when(spielMock.getKartenstapel()).thenReturn(stapel);
        assertFalse(spielController.spielIstBeendet());
    }

    @Test
    void testGetKartenstapel() {
        spielController.getKartenstapel();
        when(spielMock.getKartenstapel()).thenReturn(new ArrayList<>());
        verify(spielMock).getKartenstapel();
    }

    @Test
    void testGetGezogeneKoenige() {
        spielController.getGezogeneKoenige();
        when(spielMock.getGezogeneKoenige()).thenReturn(5);
        verify(spielMock).getGezogeneKoenige();
    }

    @Test
    void testKarteZiehen() {
        List<Karte> stapel = new ArrayList<>();
        Karte karteMock = mock(Karte.class);
        stapel.add(karteMock);
        when(spielMock.getKartenstapel()).thenReturn(stapel);
        when(karteMock.getWert()).thenReturn(KuebelKoenig.KOENIG);

        spielController.karteZiehen();

        verify(spielMock).setAnzahlGezogenerKarten(anyInt());
        verify(spielMock).setAktuelleKarte(karteMock);
        verify(spielMock).setGezogeneKoenige(anyInt());
    }

    @Test
    void testGetNameAktuellerSpieler() {
        when(spieler.getName()).thenReturn("Max");

        List<Spieler> spielerList = new ArrayList<>();
        spielerList.add(spieler);

        when(spielMock.getSpielerListe()).thenReturn(spielerList);
        when(spielMock.getAktuellerSpielerIndex()).thenReturn(0);

        spielController.getNameAktuellerSpieler();

        verify(spielMock).getSpielerListe();
        verify(spielMock).getAktuellerSpielerIndex();
        verify(spieler).getName();
    }

    @Test
    void testGetAktuelleKarte() {
        when(spielMock.getAktuelleKarte()).thenReturn(karte);
        when(karte.getSymbol()).thenReturn(Kartensymbol.HERZ);
        when(karte.getWert()).thenReturn(RauschRitter.KOENIG);

        assertEquals("herzkoenig", spielController.getAktuelleKarte());

        verify(spielMock, times(2)).getAktuelleKarte();
        verify(karte).getSymbol();
        verify(karte).getWert();
    }

    @Test
    void testGetRegelAktuelleKarte() {
        when(spielMock.getAktuelleKarte()).thenReturn(karte);
        when(karte.getRegel()).thenReturn("Regel");

        assertEquals("Regel", spielController.getRegelAktuelleKarte());

        verify(spielMock).getAktuelleKarte();
        verify(karte).getRegel();
    }

    @Test
    void testNaechsteRundeWennNichtBeendet() {
        when(spielMock.getGezogeneKoenige()).thenReturn(2);
        List<Karte> stapel = new ArrayList<>();
        stapel.add(mock(Karte.class));
        when(spielMock.getKartenstapel()).thenReturn(stapel);

        List<Spieler> spielerList = new ArrayList<>();
        spielerList.add(spieler);

        when(spielMock.getSpielerListe()).thenReturn(spielerList);
        when(spielMock.getAktuellerSpielerIndex()).thenReturn(0);

        spielController.naechsteRunde();

        verify(spielMock, times(2)).getSpielerListe();
        verify(spielMock, times(1)).getAktuellerSpielerIndex();
        verify(spielMock).setAktuellerSpielerIndex(anyInt());
    }

    @Test
    void testNaechsteRundeWennBeendet() {
        List<Spieler> spielerList = new ArrayList<>();
        spielerList.add(spieler);
        when(spielMock.getSpielerListe()).thenReturn(spielerList);
        when(spielMock.getAktuellerSpielerIndex()).thenReturn(0);
        when(spielMock.getGezogeneKoenige()).thenReturn(4);

        spielController.naechsteRunde();

        verify(spielMock).getSpielerListe();
        assertTrue(spielController.spielIstBeendet());
    }

    @Test
    void testNaechsteRundeMitLeererSpielerliste() {
        when(spielMock.getSpielerListe()).thenReturn(new ArrayList<>());

        assertThrows(IllegalStateException.class, () -> spielController.naechsteRunde());
    }

    @Test
    void testGetAnzahlGezogenerKarten() {
        when(spielMock.getAnzahlGezogenerKarten()).thenReturn(5);
        assertEquals(5, spielController.getAnzahlGezogenerKarten());

        verify(spielMock).getAnzahlGezogenerKarten();
    }

    @Test
    void testBeendeSpiel() {
        spielController.beendeSpiel();
        assertNull(SpielSingleton.getInstance());

    }
}
