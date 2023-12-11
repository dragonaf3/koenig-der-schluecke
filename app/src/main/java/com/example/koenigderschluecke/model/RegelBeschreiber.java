package com.example.koenigderschluecke.model;

/**
 * Das Interface RegelBeschreiber wird von allen Enums implementiert, die eine Regel besitzen müssen.
 */
public interface RegelBeschreiber {

    /**
     * Diese Methode liefert die Beschreibung der Regel zurück.
     *
     * @return Die Beschreibung der Regel.
     */
    String getBeschreibung();
}
