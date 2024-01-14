package com.example.koenigderschluecke.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.koenigderschluecke.model.Lobby;
import com.example.koenigderschluecke.model.SpielSingleton;
import com.example.koenigderschluecke.model.Spieler;
import com.example.koenigderschluecke.model.SpielerImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse testet die Funktionen des LobbyControllers. Lobby und SpielSingelton werden gemockt, da diese eine Abhängigkeit darstellen.
 */
class LobbyControllerImplTest {

    @Mock
    private Lobby lobby; // Mock-Objekt für die Lobby

    @Mock
    SpielSingleton spielSingleton; // Mock-Objekt für das SpielSingleton

    private LobbyControllerImpl lobbyController; // Instanz des zu testenden LobbyControllers

    /**
     * Diese Methode wird vor jedem Test ausgeführt und initialisiert die Testumgebung.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        lobbyController = new LobbyControllerImpl();
        lobbyController.setLobby(lobby); // Setzen des Mock-Objekts
    }

    /**
     * Testet die Erstellung einer Lobby.
     */
    @Test
    void testLobbyErstellung() {
        lobbyController = new LobbyControllerImpl();
        assertEquals(lobbyController.getLobby().getAnzahlSpieler(), 0);
    }

    /**
     * Testet das Hinzufügen eines Spielers zur Lobby.
     */
    @Test
    void testAddSpieler() {
        String spielerName = "Max";
        lobbyController.addSpieler(spielerName);
        verify(lobby).addSpieler(spielerName);
    }

    /**
     * Testet das Entfernen eines Spielers aus der Lobby.
     */
    @Test
    void testRemoveSpieler() {
        String spielerName = "Max";
        lobbyController.addSpieler(spielerName);
        lobbyController.removeSpieler(spielerName);
        verify(lobby).removeSpieler(spielerName);
    }

    /**
     * Testet das Abrufen der Spielerliste.
     */
    @Test
    void testGetSpielerListe() {
        lobbyController.getSpielerListe();
        verify(lobby).getSpielerListe();
    }

    /**
     * Testet die Auswahl eines Regelsets.
     */
    @Test
    void testWaeheleRegelset() {
        int regelsetId = 0;
        lobbyController.waehleRegelset(regelsetId);
        verify(lobby).setRegelsetId(regelsetId);
    }

    /**
     * Testet das Abrufen des aktuellen Regelsets.
     */
    @Test
    void getAktuellesRegelset() {
        when(lobby.getRegelsetId()).thenReturn(0);
        assertEquals(lobbyController.getAktuellesRegelset(), "Hopfenhacker");

        verify(lobby).getRegelsetId();
    }

    /**
     * Testet das Starten eines Spiels mit weniger als zwei Spielern.
     */
    @Test
    void testStarteSpielMitWenigerAlsZweiSpielern() {
        when(lobby.getAnzahlSpieler()).thenReturn(1);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            lobbyController.starteSpiel();
        });

        String expectedMessage = "Zu wenig Spieler*innen";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
        verify(lobby).getAnzahlSpieler();
    }

    /**
     * Testet das Starten eines Spiels mit genügend Spielern.
     */
    @Test
    void testStarteSpielMitGenugSpielern() {
        List<Spieler> spielerList = new ArrayList<>();
        spielerList.add(new SpielerImpl("Max"));
        spielerList.add(new SpielerImpl("Eva"));

        when(lobby.getAnzahlSpieler()).thenReturn(2);
        when(lobby.getSpielerListe()).thenReturn(spielerList);
        when(lobby.getRegelsetId()).thenReturn(0);

        lobbyController.starteSpiel();

        verify(lobby).getSpielerListe();
        verify(lobby).getRegelsetId();
        //Mocken geht nicht, Lösung?
//        verify(spielSingleton).getSpielInstance("RauschRitter",spielerList);
    }

    /**
     * Testet das Beenden einer Lobby.
     */
    @Test
    void testBeendeLobby() {
        lobbyController.beendeLobby();
        assertNull(lobbyController.getLobby());
    }
}