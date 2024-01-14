package com.example.koenigderschluecke.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class SpielerImplTest {

    @Test
    void setNameWithValidName() {
        SpielerImpl spieler = new SpielerImpl("Testspieler");
        spieler.setName("NeuerName");
        assertEquals("NeuerName", spieler.getName());
    }

    @Test
    void setNameWithNull() {
        SpielerImpl spieler = new SpielerImpl("Testspieler");
        assertThrows(IllegalArgumentException.class, () -> spieler.setName(null));
    }

    @Test
    void setNameWithEmptyString() {
        SpielerImpl spieler = new SpielerImpl("Testspieler");
        assertThrows(IllegalArgumentException.class, () -> spieler.setName(""));
    }

    @Test
    void constructorWithValidName() {
        SpielerImpl spieler = new SpielerImpl("Testspieler");
        assertEquals("Testspieler", spieler.getName());
    }

    @Test
    void constructorWithNull() {
        assertThrows(IllegalArgumentException.class, () -> new SpielerImpl(null));
    }

    @Test
    void constructorWithEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> new SpielerImpl(""));
    }
}