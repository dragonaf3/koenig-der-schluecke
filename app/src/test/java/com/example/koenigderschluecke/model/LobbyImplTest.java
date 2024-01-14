package com.example.koenigderschluecke.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Testklasse für LobbyImpl. Da SpielerImpl nur ein einfacher Datencontainer ist und direkt in LobbyImpl instanziert wird,
 * wird auf ein mock verzichtet.
 */
public class LobbyImplTest {

    private LobbyImpl lobby;

    @BeforeEach
    public void setUp() {
        lobby = new LobbyImpl();
    }

    @Test
    public void testAddSpieler() {
        // Spieler zur Lobby hinzufügen
        lobby.addSpieler("Max");

        // Prüfen, ob die Anzahl der Spieler korrekt erhöht wurde
        assertEquals(1, lobby.getAnzahlSpieler());

        // Prüfen, ob der Spieler korrekt zur Liste hinzugefügt wurde
        List<Spieler> spielerList = lobby.getSpielerListe();
        assertNotNull(spielerList);
        assertEquals("Max", spielerList.get(0).getName());
    }

    @Test
    public void testAddOneMoreSpieler() {
        lobby.addSpieler("Max");
        lobby.addSpieler("Eva");

        assertEquals(2, lobby.getAnzahlSpieler());

        List<Spieler> spielerList = lobby.getSpielerListe();
        assertNotNull(spielerList);
        assertEquals("Max", spielerList.get(0).getName());
        assertEquals("Eva", spielerList.get(1).getName());
    }

    @Test
    public void testAddSpielerExceptions() {
        // Null-Name
        assertThrows(IllegalArgumentException.class, () -> {
            lobby.addSpieler(null);
        }, "Name darf nicht leer oder null sein.");

        // Leerer Name
        assertThrows(IllegalArgumentException.class, () -> {
            lobby.addSpieler("");
        }, "Name darf nicht leer oder null sein.");

        // Name bereits vergeben
        lobby.addSpieler("Max");
        assertThrows(IllegalArgumentException.class, () -> {
            lobby.addSpieler("Max");
        }, "Name ist bereits vergeben.");
    }

    @Test
    public void testRemoveSpieler() {
        lobby.addSpieler("Max");
        lobby.removeSpieler("Max");

        assertEquals(0, lobby.getAnzahlSpieler());
    }

    @Test
    public void testRemoveOnlyOneSpieler() {
        lobby.addSpieler("Max");
        lobby.addSpieler("Eva");
        lobby.removeSpieler("Max");

        assertEquals(1, lobby.getAnzahlSpieler());

        List<Spieler> spielerList = lobby.getSpielerListe();
        assertNotNull(spielerList);
        assertEquals("Eva", spielerList.get(0).getName());
    }

    @Test
    public void testRemoveSpielerExceptions() {
        // Null-Name
        IllegalArgumentException nullNameException = assertThrows(IllegalArgumentException.class, () -> {
            lobby.removeSpieler(null);
        });
        assertEquals("Name darf nicht leer oder null sein.", nullNameException.getMessage());

        // Leerer Name
        IllegalArgumentException emptyNameException = assertThrows(IllegalArgumentException.class, () -> {
            lobby.removeSpieler("");
        });
        assertEquals("Name darf nicht leer oder null sein.", emptyNameException.getMessage());

        // Name nicht in der Lobby
        IllegalArgumentException nameNotInLobbyException = assertThrows(IllegalArgumentException.class, () -> {
            lobby.removeSpieler("Max");
        });
        assertEquals("Name ist nicht in der Lobby.", nameNotInLobbyException.getMessage());
    }

    @Test
    public void testSetAndGetRegelsetId() {
        int regelsetId = 5;
        lobby.setRegelsetId(regelsetId);
        assertEquals(regelsetId, lobby.getRegelsetId());
    }
}