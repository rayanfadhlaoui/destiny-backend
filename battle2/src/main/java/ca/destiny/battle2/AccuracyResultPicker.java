package ca.destiny.battle2;

import ca.destiny.battle2.factory.dice.AccuracyResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccuracyResultPicker {
    public AccuracyResult pick(boolean positive, List<AccuracyResult> results) {
        AccuracyResult result;
        if (positive) {
            result = pickPositive(results);
        } else {
            result = pickNegative(results);
        }

        return result;
    }

    private AccuracyResult pickNegative(List<AccuracyResult> results) {
        AccuracyResult worstResult = null;
        for (AccuracyResult accuracyResult : results) {
            if (accuracyResult == AccuracyResult.COUNTERED) {
                worstResult = AccuracyResult.COUNTERED;
                break;
            }
            worstResult = getWorst(worstResult, accuracyResult);
        }
        return worstResult;
    }


    private AccuracyResult pickPositive(List<AccuracyResult> results) {
        AccuracyResult bestOption = null;
        for (AccuracyResult accuracyResult : results) {
            if (accuracyResult == AccuracyResult.TOUCHED) {
                bestOption = AccuracyResult.TOUCHED;
                break;
            }
            bestOption = getBest(bestOption, accuracyResult);
        }
        return bestOption;
    }

    private AccuracyResult getBest(AccuracyResult current, AccuracyResult other) {
        AccuracyResult best;
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

    private AccuracyResult getWorst(AccuracyResult current, AccuracyResult other) {
        AccuracyResult worst;
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
