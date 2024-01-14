package com.example.koenigderschluecke.model;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Die Klasse KarteImplTest testet die Klasse KarteImpl. Abhängigkeiten werden gemockt und es wird eine TestEnum Klasse erstellt,
 * welche das RegelBeschreiber interface implementiert, um dieses zu testen.
 */
@ExtendWith(MockitoExtension.class)
class KarteImplTest {

    @Mock
    private Enum mockWert;

    @Mock
    private Kartensymbol mockSymbol;

    @Test
    void testGetWert() {
        KarteImpl karte = new KarteImpl(mockWert, mockSymbol);
        assertEquals(mockWert, karte.getWert(), "getWert sollte den gemockten Wert zurückgeben");
    }

    @Test
    void testGetSymbol() {
        KarteImpl karte = new KarteImpl(mockWert, mockSymbol);
        assertEquals(mockSymbol, karte.getSymbol(), "getSymbol sollte das gemockte Symbol zurückgeben");
    }

    @Test
    void testGetRegel() {
        KarteImpl karte = new KarteImpl(TestKartenwert.BEISPIEL, mockSymbol);
        String expectedRegel = "Testbeschreibung";
        assertEquals(expectedRegel, karte.getRegel(), "getRegel sollte die gemockte Regelbeschreibung zurückgeben");

    }

    @Test
    void testToString() {
        when(mockWert.toString()).thenReturn("Wert");
        when(mockSymbol.toString()).thenReturn("Symbol");

        KarteImpl karte = new KarteImpl(mockWert, mockSymbol);
        String expectedString = "Wert von Symbol";
        assertEquals(expectedString, karte.toString(), "toString sollte die korrekte String-Repräsentation zurückgeben");
    }

    // Test-Enum, das das RegelBeschreiber-Interface implementiert
    private enum TestKartenwert implements RegelBeschreiber {
        BEISPIEL {
            @Override
            public String getBeschreibung() {
                return "Testbeschreibung";
            }
        };
    }
}