package com.example.koenigderschluecke.model;

public enum KuebelKoenig implements RegelBeschreiber {
    EINS("Trinke einen Schluck."),
    ZWEI("Verteile zwei Schlücke."),
    DREI("Trinke drei Schlücke."),
    VIER("Alle Spielenden trinken vier Schlücke."),
    FUENF("Der Spielende links von dir trinkt fünf Schlücke."),
    SECHS("Wähle einen Trinkpartner, ihr trinkt beide sechs Schlücke."),
    SIEBEN("Der Spielende rechts von dir trinkt sieben Schlücke."),
    ACHT("Mache eine Regel. Jeder, der dagegen verstößt, trinkt acht Schlücke."),
    NEUN("Hebe eine Hand und fordere einen anderen Spieler auf, dir ein High-Five zu geben. Alle, die sich verspäten oder keinen Partner finden, trinken neun Schlücke."),
    ZEHN("Alle Spielenden müssen aufstehen und zehn Schlücke trinken."),
    BUBE("Alle Männer und nichtbinäre Personen trinken einen Schluck."),
    DAME("Alle Frauen und nichtbinäre Personen trinken einen Schluck."),
    KOENIG("Du bist der KübelKönig. Bestimme einen Spieler, der immer trinken muss, wenn du trinkst."),
    ASS("Starte einen Kübelrunde! Alle Spieler müssen nacheinander ein Getränk in den Gemeinschaftskübel schütten. Der Spieler, der den Kübel überlaufen lässt, muss ihn austrinken.");

    private final String beschreibung;

    KuebelKoenig(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    @Override
    public String getBeschreibung() {
        return beschreibung;
    }
}
