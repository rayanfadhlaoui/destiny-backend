package ca.destiny.battle.duel;

import ca.destiny.battle.BattleExecutor;
import ca.destiny.battle.model.BattleDto;
import ca.destiny.other.RandomNumberGeneratorService;
import org.springframework.stereotype.Component;

@Component
public class TurnBasedBattleExecutor extends BattleExecutor {

    private final RandomNumberGeneratorService randomNumberGeneratorService;

    public TurnBasedBattleExecutor(RandomNumberGeneratorService randomNumberGeneratorService) {
        super(null);
        this.randomNumberGeneratorService = randomNumberGeneratorService;
    }

    @Override
    public BattleDto customExecute(BattleDto battleDto) {
//        FighterDto activeFighter = battleDto.getActiveFighter();
//        FighterDto inactiveFighter = battleDto.getInactiveFighter();
        return battleDto;
    }
}
