package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable{
    String name;
    ArrayList<Game> games;
    boolean isSelected;

    public Player(String name) {
        this.name = name;
        this.games = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void addGame(Game game){
        this.games.add(game);
    }

    public int getWins(){
        int i=0;
        for (Game g:this.getGames()) {
            if (g.result== Game.Result.WIN)
                i++;
        }
        return i;
    }

    public int getTies(){
        int i=0;
        for (Game g:this.getGames()) {
            if (g.result== Game.Result.TIE)
                i++;
        }
        return i;
    }

    public int getLosses(){
        int i=0;
        for (Game g:this.getGames()) {
            if (g.result== Game.Result.LOSS)
                i++;
        }
        return i;
    }

    public float getWinLossRatio(){
        int wins = this.getWins();
        int losses = this.getLosses();
        int total = wins + losses;
        return (float) wins/total;
    }

    public float getWinLossRatioIncludeTies(){
        int wins = this.getWins();
        int ties = this.getTies()/2;
        return (float) (wins+ties*0.5/this.games.size());
    }
}
