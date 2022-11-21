package ca.destiny.battle2;

import ca.destiny.battle2.factory.dice.DamageResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DamageResultPicker {

    public DamageResult pick(boolean positive, List<DamageResult> results) {
        DamageResult result;
        if (positive) {
            result = pickPositive(results);
        } else {
            result = pickNegative(results);
        }

        return result;
    }
    private DamageResult pickNegative(List<DamageResult> results) {
        DamageResult worstResult = null;
        for (DamageResult damageResult : results) {
            if (damageResult == DamageResult.COUNTERED) {
                worstResult = DamageResult.COUNTERED;
                break;
            }
            worstResult = getWorst(worstResult, damageResult);
        }
        return worstResult;
    }

    private DamageResult pickPositive(List<DamageResult> results) {
        DamageResult bestOption = null;
        for (DamageResult damageResult : results) {
            if (damageResult == DamageResult.DAMAGED) {
                bestOption = DamageResult.DAMAGED;
                break;
            }
            bestOption = getBest(bestOption, damageResult);
        }
        return bestOption;
    }

    private DamageResult getBest(DamageResult current, DamageResult other) {
        DamageResult best;
        if (current == null) {
            best = other;
        } else {
            if (current.getValue() > other.getValue()) {
                best = current;
            } else {
                best = other;
            }
        }
        return best;
    }

    private DamageResult getWorst(DamageResult current, DamageResult other) {
        DamageResult worst;
        if (current == null) {
            worst = other;
        } else {
            if (current.getValue() < other.getValue()) {
                worst = current;
            } else {
                worst = other;
            }
        }
        return worst;
    }

}
