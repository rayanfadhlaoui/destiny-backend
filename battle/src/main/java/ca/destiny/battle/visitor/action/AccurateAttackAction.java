package ca.destiny.battle.visitor.action;

import ca.destiny.battle.action.AttackAction;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.injury.InjuryService;
import ca.destiny.other.RandomNumberGeneratorService;

public class AccurateAttackAction extends AttackAction {
    public AccurateAttackAction(RandomNumberGeneratorService randomNumberGeneratorService,
                                InjuryService injuryService,
                                BattleFighterDto activeFighter,
                                BattleFighterDto inactiveFighter) {
        super(randomNumberGeneratorService, injuryService, activeFighter, inactiveFighter);
    }

    @Override
    protected int applyAccuracyBonus(int hitPercentage) {
        return Double.valueOf(hitPercentage * 1.3).intValue();
    }

    @Override
    protected int applyDamageBonus(int damage) {
        int newDamage = Double.valueOf(damage * 0.7).intValue();
        return Math.max(newDamage, 1);
    }

}
