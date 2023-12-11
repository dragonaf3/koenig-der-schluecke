package com.example.koenigderschluecke.model;

public enum Hopfenhacker {
    EINS("Trinke einen Schluck."),
    ZWEI("Trinke zwei Schlücke."),
    DREI("Trinke drei Schlücke."),
    VIER("Verteile vier Schlücke."),
    FUENF("Wähle einen Trinkpartner, ihr trinkt beide fünf Schlücke."),
    SECHS("Starte einen Reimrunde. Jeder Spielende muss ein Reimwort sagen. Derjenige, der keinen Reim findet oder bereits gesagte Wörter wiederholt, trinkt sechs Schlücke."),
    SIEBEN("Lege deinen Zeigefinger auf deine Nase. Derjenige, der es dir als letztes nachmacht, muss trinken."),
    ACHT("Alle Männer und nichtbinäre Personen trinken."),
    NEUN("Alle Frauen und nichtbinäre Personen trinken."),
    ZEHN("Alle müssen trinken."),
    BUBE("Du darfst eine Regel aufstellen, die für den Rest des Spiels befolgt werden muss. Wird die Regel nicht beachtet, muss derjenige einen Schluck trinken."),
    DAME("Du bist der Questionmaster, bis die nächste Dame gezogen wird. Jeder, der dir eine Frage beantwortet, muss trinken."),
    KOENIG("Du bist der König des Spiels. Bestimme eine Person, die immer trinken muss, wenn du trinkst."),
    ASS("Wasserfall! Du fängst an zu trinken und im Uhrzeigersinn setzt jeder Spielende nacheinander zum Trinken an. Setzt du ab, darf im Uhrzeigersinn auch nacheinander abgesetzt werden.");

    private final String beschreibung;

    Hopfenhacker(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getBeschreibung() {
        return beschreibung;
    }
}
