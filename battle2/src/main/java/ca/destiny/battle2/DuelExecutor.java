package ca.destiny.battle2;

import ca.destiny.battle2.factory.dice.DamageResult;
import org.springframework.stereotype.Component;

@Component
public class DuelExecutor {

    private final AccuracyService accuracyService;
    private final DamageService damageService;
    private final InjuryService injuryService;

    public DuelExecutor(AccuracyService accuracyService,
                        DamageService damageService,
                        InjuryService injuryService) {
        this.accuracyService = accuracyService;
        this.damageService = damageService;
        this.injuryService = injuryService;
    }

    public void execute(Duel duel) {
        var accuracyResult = accuracyService.getAccuracyAction(duel.getAggressor(), duel.getDefender());
        switch (accuracyResult) {
            case COUNTERED:
                duel.flipFighter();
                execute(duel);
                break;
            case MISSED:
            case TOUCHABLE_MISS:
            case COUNTERABLE_MISSED:
                duel.flipFighter();
                break;
            case DODGABLE_TOUCH:
            case TOUCHED:
                executeDamage(duel);
                break;
            default:
                throw new IllegalArgumentException();
        }

    }

    private void executeDamage(Duel duel) {
        DamageResult damageAction = damageService.getDamageAction(duel.getAggressor(), duel.getDefender());
        switch (damageAction) {
            case COUNTERED:
                duel.flipFighter();
                execute(duel);
                break;
            case NO_DAMAGE:
            case BARELY_ENDURED:
            case COUNTERABLE:
                duel.flipFighter();
                break;
            case ENDURABLE_DAMAGE:
            case DAMAGED:
                applyDamage(duel);
                executeInjury(duel);
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void applyDamage(Duel duel) {
        duel.getDefender().getCharacteristics().decreaseVitality(1);
    }

    private void executeInjury(Duel duel) {
        injuryService.applyInjury(duel.getAggressor(), duel.getDefender());
        if (duel.getDefender().getCharacteristics().getVitality() <= 0) {
            duel.setOver(true);
        } else {
            duel.flipFighter();
        }
    }
}
