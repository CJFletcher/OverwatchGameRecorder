package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Game implements Serializable {
    LocalDateTime date;
    ArrayList<Player> players;
    Result result;

    public enum Result implements Serializable {
        WIN,TIE,LOSS
    }

    public Game(ArrayList<Player> players, Result gameResult) {
        this.date = LocalDateTime.now();
        this.players = players;
        this.result = gameResult;
        addGameToPlayers();
    }

    public void addGameToPlayers(){
        for (Player p:this.players) {
            p.addGame(this);
        }
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Enum<Result> getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
