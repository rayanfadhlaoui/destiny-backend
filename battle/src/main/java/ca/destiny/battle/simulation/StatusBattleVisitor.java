package ca.destiny.battle.simulation;

import ca.destiny.battle.model.DuelSingleCellBattleDto;
import ca.destiny.battle.model.Summary;
import ca.destiny.battle.visitor.BattleVisitor;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.BattleInformation;

public class StatusBattleVisitor implements BattleVisitor {
    @Override
    public void visit(DuelSingleCellBattleDto duelSingleCellBattleDto) {
        if (!isAlive(duelSingleCellBattleDto.getInactiveFighter())) {
            Summary summary = duelSingleCellBattleDto.getSummary();
            summary.addWinners(duelSingleCellBattleDto.getActiveFighter());
            summary.isOver(true);
        }
    }

    private boolean isAlive(BattleFighterDto fighter) {
        BattleInformation battleInformation = fighter.getBattleInformation();
        return battleInformation.getVitality() > 0;
    }
}
