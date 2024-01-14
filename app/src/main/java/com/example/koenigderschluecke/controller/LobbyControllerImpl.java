package com.example.koenigderschluecke.controller;

import com.example.koenigderschluecke.model.Lobby;
import com.example.koenigderschluecke.model.LobbyImpl;
import com.example.koenigderschluecke.model.SpielSingleton;
import com.example.koenigderschluecke.model.Spieler;

import java.util.List;

public class LobbyControllerImpl implements LobbyController {

    private Lobby lobby;

    public LobbyControllerImpl() {
        this.lobby = new LobbyImpl();
    }

    @Override
    public void starteSpiel() throws IllegalArgumentException {
        if (lobby.getAnzahlSpieler() < 2) {
            throw new IllegalArgumentException("Zu wenig Spieler*innen");
        }
        SpielSingleton.getSpielInstance(getAktuellesRegelset(), getSpielerListe());
    }

    @Override
    public void beendeLobby() {
        lobby = null;
    }

    @Override
    public void addSpieler(String spielerName) throws IllegalArgumentException {
        lobby.addSpieler(spielerName);
    }

    @Override
    public void removeSpieler(String name) throws IllegalArgumentException {
        lobby.removeSpieler(name);
    }

    @Override
    public List<Spieler> getSpielerListe() {
        return lobby.getSpielerListe();
    }

    @Override
    public void waehleRegelset(int regelsetId) {
        lobby.setRegelsetId(regelsetId);
    }

    @Override
    public String getAktuellesRegelset() throws IllegalArgumentException {
        //TODO: Fabrik besser!
        int idRegelset = lobby.getRegelsetId();

        switch (idRegelset) {
            case 0 -> {
                return "Hopfenhacker";
            }
            case 1 -> {
                return "KuebelKoenig";
            }
            case 2 -> {
                return "RauschRitter";
            }
            default -> throw new IllegalArgumentException(); //TODO: Verbessern
        }
    }

}
