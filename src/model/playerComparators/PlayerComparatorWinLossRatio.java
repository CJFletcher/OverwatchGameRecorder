package model.playerComparators;

import model.Player;

import java.util.Comparator;

public class PlayerComparatorWinLossRatio implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        return Float.compare(p1.getWinLossRatio(), p2.getWinLossRatio());
    }
}
