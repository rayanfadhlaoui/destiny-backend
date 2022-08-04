package ca.destiny.battle.model;


import ca.destiny.fighter.BattleFighterDto;

import java.util.ArrayList;
import java.util.List;

public class Summary {

    private boolean isOver = false;
    private final List<BattleFighterDto> winners = new ArrayList<>();
    private int totalTurn = 0;

    public boolean isOver() {
        return isOver;
    }

    public void isOver(boolean isOver) {
        this.isOver = isOver;
    }

    public List<BattleFighterDto> getWinners() {
        return winners;
    }

    public void addWinners(BattleFighterDto winner) {
        winners.add(winner);
    }

    public int getTotalTurn() {
        return totalTurn;
    }

    public void setTotalTurn(int totalTurn) {
        this.totalTurn = totalTurn;
    }

    public void incrementTotalTurn() {
        totalTurn++;
    }
}
