package ca.destiny.battle.factory;

import ca.destiny.battle.model.BattleDto;
import ca.destiny.fighter.BattleFighterDto;
import org.apache.commons.lang3.NotImplementedException;

public abstract class BattleBuilder {

    public static BattleBuilder initWith(BattleType battleType) {
        if (battleType == BattleType.DUEL_SINGLE_CELL) {
            return new DuelSingleCellBattleBuilder();
        }
        throw new NotImplementedException();
    }

    public abstract BattleBuilder addFighters(BattleFighterDto... battleFighterDto);

    public abstract BattleDto build();

}
