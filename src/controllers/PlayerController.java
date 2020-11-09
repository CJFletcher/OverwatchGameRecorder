package controllers;

import model.Player;
import model.playerComparators.PlayerComparatorTotalWins;
import model.playerComparators.PlayerComparatorWinLossRatio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class PlayerController implements Serializable {
    private ArrayList<Player> players;

    public PlayerController(ArrayList<Player> players) {
        this.players = players;
    }

    public PlayerController() {
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void sortByWinRatio() {
        Collections.sort(this.getPlayers(),new PlayerComparatorWinLossRatio());
    }

    public void sortByTotalWins() {
        Collections.sort(this.getPlayers(),new PlayerComparatorTotalWins());
    }

}
