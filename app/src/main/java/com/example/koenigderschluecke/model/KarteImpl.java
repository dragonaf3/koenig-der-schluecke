package com.example.koenigderschluecke.model;

public class KarteImpl implements Karte {
    private final Enum wert;
    private final Kartensymbol symbol;

    public KarteImpl(Enum wert, Kartensymbol symbol) {
        this.wert = wert;
        this.symbol = symbol;
    }
    @Override
    public Enum getWert() {
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
