package controllers;

import model.Game;

import java.io.Serializable;
import java.util.ArrayList;

public class GameController implements Serializable {
    private ArrayList<Game> games;

    public GameController(ArrayList<Game> games) {
        this.games = games;
    }

    public GameController() {
        this.games = new ArrayList<>();
    }

    public void addGame(Game game) {
        this.games.add(game);
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }
}
