package com.example.koenigderschluecke.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import android.content.Context;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.FileNotFoundException;

/**
 * Diese Klasse testet die Implementierung des PersistenzControllers.
 */
class PersistenzControllerImplTest {

    // Mock-Objekt für den Kontext
    @Mock
    private Context mockContext;

    // Instanz des zu testenden PersistenzControllers
    private PersistenzControllerImpl persistenzController;

    /**
     * Diese Methode wird vor jedem Test ausgeführt und initialisiert die Testumgebung.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        persistenzController = new PersistenzControllerImpl(mockContext);
    }

    /**
     * Dieser Test überprüft das Speichern und Laden der Statistik.
     *
     * @throws FileNotFoundException wenn die Datei nicht gefunden wird
     */
    @Test
    void testSpeichereUndLadeStatistik() throws FileNotFoundException {

        persistenzController.speichereStatistik(5);
        persistenzController.ladeStatistik();
        assertEquals(5, persistenzController.getAnzahlGezogeneKarten());
        assertEquals(1, persistenzController.getAnzahlGespielteSpiele());

        verify(mockContext).openFileOutput(PersistenzControllerImpl.DATEINAME, Context.MODE_PRIVATE);
        verify(mockContext, times(2)).openFileInput(PersistenzControllerImpl.DATEINAME);
    }

    /**
     * Dieser Test überprüft das Laden der Statistik am Ende des Spiels.
     *
     * @throws FileNotFoundException wenn die Datei nicht gefunden wird
     */
    @Test
    void testLadeSpielendeStatistik() throws FileNotFoundException {

        persistenzController.ladeStatistik();
        assertEquals(0, persistenzController.getAnzahlGezogeneKarten());
        assertEquals(0, persistenzController.getAnzahlGespielteSpiele());
        verify(mockContext, times(2)).openFileInput(PersistenzControllerImpl.DATEINAME);
    }

    /**
     * Dieser Test überprüft das Zurücksetzen der Statistik.
     *
     * @throws FileNotFoundException wenn die Datei nicht gefunden wird
     */
    @Test
    void testResetStatistik() throws FileNotFoundException {

        persistenzController.speichereStatistik(5);
        persistenzController.resetStatistik();
        persistenzController.ladeStatistik();
        assertEquals(0, persistenzController.getAnzahlGezogeneKarten());
        assertEquals(0, persistenzController.getAnzahlGespielteSpiele());
        verify(mockContext, times(2)).openFileOutput(PersistenzControllerImpl.DATEINAME, Context.MODE_PRIVATE);
        verify(mockContext, times(2)).openFileInput(PersistenzControllerImpl.DATEINAME);
    }

}