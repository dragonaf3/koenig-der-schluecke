package com.example.koenigderschluecke.model;

public class KarteImpl implements Karte {
    private final RauschRitter wert;
    private final Kartensymbol symbol;

    public KarteImpl(RauschRitter wert, Kartensymbol symbol) {
        this.wert = wert;
        this.symbol = symbol;
    }
    @Override
    public RauschRitter getWert() {
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
