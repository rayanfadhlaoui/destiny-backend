package ca.destiny.battle.factory;

import ca.destiny.battle.model.BattleDto;
import ca.destiny.battle.model.DuelSingleCellBattleDto;
import ca.destiny.battle.model.Summary;
import ca.destiny.fighter.BattleFighterDto;

import java.util.Stack;

public class DuelSingleCellBattleBuilder extends BattleBuilder {

    private BattleFighterDto battleFighterDto1;
    private BattleFighterDto battleFighterDto2;
    private final InitiativeService initiativeService;

    DuelSingleCellBattleBuilder() {
        initiativeService = new InitiativeService();
    }

    @Override
    public BattleBuilder addFighters(BattleFighterDto... battleFighterDto) {
        if (battleFighterDto.length > 2) {
            throw new IllegalArgumentException("Too many fighters");
        }

        battleFighterDto1 = battleFighterDto[0];
        if (battleFighterDto.length == 2) {
            battleFighterDto2 = battleFighterDto[1];
        }
        return this;
    }

    @Override
    public BattleDto build() {
        if (battleFighterDto1 == null || battleFighterDto2 == null) {
            throw new IllegalArgumentException("Should have two fighters");
        }
        Stack<BattleFighterDto> battleOrder = initiativeService.getOrder(battleFighterDto1, battleFighterDto2);

        DuelSingleCellBattleDto duelSingleCellBattleDto = new DuelSingleCellBattleDto();
        duelSingleCellBattleDto.setActiveFighter(battleOrder.pop());
        duelSingleCellBattleDto.setInactiveFighter(battleOrder.pop());
        duelSingleCellBattleDto.setSummary(new Summary());
        return duelSingleCellBattleDto;
    }

}
