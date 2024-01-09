package com.example.koenigderschluecke.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpielerImplTest {
    private SpielerImpl spieler;

    @BeforeEach
    public void setUp() {
        spieler = new SpielerImpl("Testspieler");
    }

    @Test
    public void setName_aendertDenNamen_desSpielers() {
        spieler.setName("NeuerName");
        assertEquals("NeuerName", spieler.getName());
    }

    @Test
    public void getName_liefertDenNamen_desSpielers() {
        assertEquals("Testspieler", spieler.getName());
    }

    @Test
    public void setName_mitLeeremNamen_setztDenNamenAufLeer() {
        spieler.setName("");
        assertEquals("", spieler.getName());
    }

    @Test
    public void setName_mitNull_setztDenNamenAufNull() {
        spieler.setName(null);
        assertEquals(null, spieler.getName());
    }
}