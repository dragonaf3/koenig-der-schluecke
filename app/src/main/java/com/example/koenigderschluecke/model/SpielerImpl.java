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
     * @param name Der Name der Spieler*in.
     * @throws IllegalArgumentException Wenn der Name leer oder Null ist.
     */
    public SpielerImpl(String name) throws IllegalArgumentException {
        setName(name);
    }

    @Override
    public void setName(String name) throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name darf nicht leer oder null sein.");
        }

        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}