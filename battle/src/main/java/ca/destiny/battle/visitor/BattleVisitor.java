package ca.destiny.battle.visitor;


import ca.destiny.battle.model.DuelSingleCellBattleDto;

public interface BattleVisitor {

    void visit(DuelSingleCellBattleDto duelSingleCellBattleDto);
}
