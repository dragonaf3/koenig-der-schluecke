package com.example.koenigderschluecke.model;

/**
 * Enum für die Karten des Regelsets RauschRitter.
 * Jede Karte besitzt eine Beschreibung, die im Spiel angezeigt wird.
 * Die Beschreibung wird über die Methode getBeschreibung() abgerufen.
 */
public enum RauschRitter implements RegelBeschreiber {
    ZWEI("Schlücke in Höhe der Karte verteilen."),
    DREI("Schlücke in Höhe der Karte verteilen."),
    VIER("Schlücke in Höhe der Karte verteilen."),
    FUENF("Schlücke in Höhe der Karte verteilen."),
    SECHS("Der linke Sitznachbar von dir muss trinken."),
    SIEBEN("Der rechte Sitznachbar von dir muss trinken."),
    ACHT("Alle Männer und nichtbinäre Personen trinken."),
    NEUN("Alle Frauen und nichtbinäre Personen trinken."),
    ZEHN("Alle müssen trinken."),
    BUBE("Du darfst eine Regel aufstellen, die für den Rest des Spiels befolgt werden muss. Wird die Regel nicht beachtet, muss derjenige einen Schluck trinken."),
    DAME("Du bist der Questionmaster, bis die nächste Dame gezogen wird. Jeder, der dir eine Frage beantwortet, muss trinken."),
    KOENIG("Fülle ein beliebiges Getränk in das Königsglass. Wenn der letzte König gezogen wird, muss das Glas ausgetrunken werden."),
    ASS("Wasserfall! Du fängst an zu trinken und im Uhrzeigersinn setzt jeder Spielende nacheinander zum Trinken an. Setzt du ab, darf im Uhrzeigersinn auch nacheinander abgesetzt werden.");

    private final String beschreibung;

    /**
     * Der Konstruktor des Enums.
     *
     * @param beschreibung Entsprechende Regel der Karte
     */
    RauschRitter(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    @Override
    public String getBeschreibung() {
        return beschreibung;
    }
}
