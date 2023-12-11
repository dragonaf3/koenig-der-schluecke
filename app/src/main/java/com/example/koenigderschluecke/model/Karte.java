package com.example.koenigderschluecke.model;

//TODO: Regelsets?

/**
 * Dies ist eine Schnittstelle für eine Spielkarte.
 * Sie bietet Methoden zum Abrufen des Werts und des Symbols der Karte.
 */
public interface Karte {

    /**
     * Diese Methode wird verwendet, um den Wert der Karte zu erhalten.
     *
     * @return String Dies gibt den Wert der Karte zurück.
     */
    Enum getWert();

    /**
     * Diese Methode wird verwendet, um das Symbol der Karte zu erhalten.
     *
     * @return String Dies gibt das Symbol der Karte zurück.
     */
    Kartensymbol getSymbol();

    /**
     * Diese Methode wird verwendet, um die Regel der Karte zu erhalten.
     *
     * @return String Dies gibt die Regel der Karte zurück.
     */
    String getRegel();

}