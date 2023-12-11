package com.example.koenigderschluecke.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.koenigderschluecke.controller.SpielController;
import com.example.koenigderschluecke.controller.SpielControllerImpl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SpielControllerTest {

    private SpielController spielController;

    @BeforeEach
    public void setUp() {
        spielController = new SpielControllerImpl("Hopfenhacker");
    }

    @Test
    void testGetAktuelleKarte() {
        spielController.karteZiehen();
        String real = spielController.getAktuelleKarte();

        assertEquals("Test", real);
    }
}
