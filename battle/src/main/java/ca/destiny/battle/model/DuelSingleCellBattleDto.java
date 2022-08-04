package ca.destiny.battle.model;

import ca.destiny.battle.visitor.BattleVisitor;
import ca.destiny.fighter.BattleFighterDto;

public class DuelSingleCellBattleDto implements BattleDto {

    private BattleFighterDto activeFighter;
    private BattleFighterDto inactiveFighter;
    private Summary summary;

    public BattleFighterDto getActiveFighter() {
        return activeFighter;
    }

    public void setActiveFighter(BattleFighterDto activeFighter) {
        this.activeFighter = activeFighter;
    }

    public BattleFighterDto getInactiveFighter() {
        return inactiveFighter;
    }

    public void setInactiveFighter(BattleFighterDto inactiveFighter) {
        this.inactiveFighter = inactiveFighter;
    }

    @Override
    public BattleFighterDto getNextFighter() {
        return activeFighter;
    }

    @Override
    public void visit(BattleVisitor battleVisitor) {
        battleVisitor.visit(this);
    }

    @Override
    public Summary getSummary() {
        return summary;
    }

    @Override
    public void incrementTurn() {
        BattleFighterDto previousActiveFighter = this.activeFighter;
        this.activeFighter = inactiveFighter;
        this.inactiveFighter = previousActiveFighter;
        summary.incrementTotalTurn();
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

}
