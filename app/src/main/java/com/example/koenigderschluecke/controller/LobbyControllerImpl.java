package com.example.koenigderschluecke.controller;

import java.util.List;

//TODO: Implementieren, Lobby sollte das SpielSingleton erstellen. Dem SpielController sollte das Singleton dann übergeben werden!

public class LobbyControllerImpl implements LobbyController {
    @Override
    public void setAnzahlSpieler(int anzahlSpieler) {

    }

    @Override
    public int getAnzahlSpieler() {
        return 0;
    }

    @Override
    public void addSpieler(String spielerName) {

    }

    @Override
    public void removeSpieler(String spielerName) {

    }

    @Override
    public List<String> getSpielerListe() {
        return null;
    }

    @Override
    public void waehleRegelset(int regelsetId) {

    }

    @Override
    public int getAktuellesRegelset() {
        return 0;
    }

    @Override
    public void starteSpiel() {

    }

    @Override
    public void beendeLobby() {

    }
}
