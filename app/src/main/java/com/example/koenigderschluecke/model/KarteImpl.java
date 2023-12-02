package com.example.koenigderschluecke.model;

public class KarteImpl implements Karte {
    private final Kartenwert wert;
    private final Kartensymbol symbol;

    public KarteImpl(Kartenwert wert, Kartensymbol symbol) {
        this.wert = wert;
        this.symbol = symbol;
    }
    @Override
    public Kartenwert getWert() {
        return wert;
    }

    @Override
    public Kartensymbol getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return wert + " von " + symbol;
    }
}
