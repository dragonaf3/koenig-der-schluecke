package com.example.koenigderschluecke.model;

/**
 * Das Spieler-Interface definiert die Methoden, die ein Spieler implementieren muss.
 */
public interface Spieler {

    /**
     * Setzt den Namen des Spielers.
     *
     * @param name Der Name des Spielers.
     */
    void setName(String name);

    /**
     * Gibt den Namen des Spielers zurück.
     *
     * @return Der Name des Spielers.
     */
    String getName();

}