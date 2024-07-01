package com.example.koenigderschluecke.model;

/**
 * Das Spieler-Interface definiert die Methoden, die ein Spieler implementieren muss.
 */
public interface Spieler {

    /**
     * Setzt den Namen des Spielers.
     *
     * @param name Der Name des Spielers.
     * @throws IllegalArgumentException Wenn der Name leer oder Null ist.
     */
    void setName(String name) throws IllegalArgumentException;

    /**
     * Gibt den Namen des Spielers zurück.
     *
     * @return Der Name des Spielers.
     */
    String getName();

}