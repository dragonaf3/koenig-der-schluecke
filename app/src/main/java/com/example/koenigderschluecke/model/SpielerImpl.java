package com.example.koenigderschluecke.model;

/**
 * Die SpielerImpl-Klasse implementiert das Spieler-Interface.
 * Sie definiert die Methoden, die ein Spieler implementieren muss.
 */
public class SpielerImpl implements Spieler {
    private String name;

    /**
     * Konstruktor für die SpielerImpl-Klasse.
     *
     * @param name Der Name des Spielers.
     */
    public SpielerImpl(String name) {
        this.name = name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}