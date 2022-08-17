package ca.destiny.battle.visitor.action;

import ca.destiny.battle.action.AttackAction;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.injury.InjuryService;
import ca.destiny.other.RandomNumberGeneratorService;

public class NormalAttackAction extends AttackAction {
    public NormalAttackAction(RandomNumberGeneratorService randomNumberGeneratorService,
                              InjuryService injuryService,
                              BattleFighterDto activeFighter,
                              BattleFighterDto inactiveFighter) {
        super(randomNumberGeneratorService, injuryService, activeFighter, inactiveFighter);
    }

    @Override
    protected int applyAccuracyBonus(int hitPercentage) {
        return hitPercentage;
    }

    @Override
    protected int applyDamageBonus(int damage) {
        return damage;
    }

}
