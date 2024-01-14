package com.example.koenigderschluecke.model;

/**
 * Die Klasse KarteImpl implementiert die Schnittstelle Karte.
 * Sie repräsentiert eine Spielkarte mit einem bestimmten Wert und Symbol.
 */
public class KarteImpl implements Karte {
    // Der Wert der Karte als Enum
    private final Enum wert;
    // Das Symbol der Karte als Kartensymbol
    private final Kartensymbol symbol;

    /**
     * Konstruktor für die Klasse KarteImpl.
     *
     * @param wert   Der Wert der Karte als Enum.
     * @param symbol Das Symbol der Karte als Kartensymbol.
     */
    public KarteImpl(Enum wert, Kartensymbol symbol) {
        this.wert = wert;
        this.symbol = symbol;
    }

    /**
     * Gibt den Wert der Karte zurück.
     *
     * @return Der Wert der Karte als Enum.
     */
    @Override
    public Enum getWert() {
        return wert;
    }

    /**
     * Gibt das Symbol der Karte zurück.
     *
     * @return Das Symbol der Karte als Kartensymbol.
     */
    @Override
    public Kartensymbol getSymbol() {
        return symbol;
    }

    /**
     * Gibt die Regel der Karte zurück.
     *
     * @return Die Regel der Karte als String.
     */
    @Override
    public String getRegel() {
        return ((RegelBeschreiber) wert).getBeschreibung();
    }

    /**
     * Gibt eine String-Repräsentation der Karte zurück.
     *
     * @return Eine String-Repräsentation der Karte.
     */
    @Override
    public String toString() {
        return wert + " von " + symbol;
    }
}