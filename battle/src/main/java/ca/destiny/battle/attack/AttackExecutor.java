package ca.destiny.battle.attack;

import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.other.RandomNumberGeneratorService;
import org.springframework.stereotype.Component;

@Component
public class AttackExecutor {

    private final RandomNumberGeneratorService randomNumberGeneratorService;

    public AttackExecutor(RandomNumberGeneratorService randomNumberGeneratorService) {
        this.randomNumberGeneratorService = randomNumberGeneratorService;
    }

    public AttackStatus execute(BattleFighterDto offensiveFighter, BattleFighterDto defensiveFighter) {
        return new AttackStatus();
    }
}
