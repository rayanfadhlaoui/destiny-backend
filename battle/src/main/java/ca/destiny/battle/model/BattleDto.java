package ca.destiny.battle.model;

import ca.destiny.battle.visitor.BattleVisitor;
import ca.destiny.fighter.BattleFighterDto;

public interface BattleDto {

    BattleFighterDto getNextFighter();

    void visit(BattleVisitor battleVisitor);

    Summary getSummary();

    void incrementTurn();

}
