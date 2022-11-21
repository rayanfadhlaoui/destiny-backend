package ca.destiny.battle2;

import ca.destiny.battle2.factory.dice.AccuracyResult;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static ca.destiny.battle2.factory.dice.AccuracyResult.*;
import static org.assertj.core.api.Assertions.assertThat;

class AccuracyResultPickerTest {


    private final AccuracyResultPicker accuracyResultPicker = new AccuracyResultPicker();

    @Test
    void pickOnlyOptionFromWorstToBest_WithoutSkills() {
        List<AccuracyResult> accuracyResults = new ArrayList<>();
        accuracyResults.add(COUNTERED);
        assertResults(accuracyResults, COUNTERED, COUNTERED);
        accuracyResults.add(COUNTERABLE_MISSED);
        assertResults(accuracyResults, COUNTERABLE_MISSED, COUNTERED);
        accuracyResults.add(MISSED);
        assertResults(accuracyResults, MISSED, COUNTERED);
        accuracyResults.add(TOUCHABLE_MISS);
        assertResults(accuracyResults, TOUCHABLE_MISS, COUNTERED);
        accuracyResults.add(DODGABLE_TOUCH);
        assertResults(accuracyResults, DODGABLE_TOUCH, COUNTERED);
        accuracyResults.add(TOUCHED);
        assertResults(accuracyResults, TOUCHED, COUNTERED);
    }

    @Test
    void pickOnlyOptionFromBestToWorst_WithoutSkills() {
        List<AccuracyResult> accuracyResults = new ArrayList<>();
        accuracyResults.add(TOUCHED);
        assertResults(accuracyResults, TOUCHED, TOUCHED);
        accuracyResults.add(DODGABLE_TOUCH);
        assertResults(accuracyResults, TOUCHED, DODGABLE_TOUCH);
        accuracyResults.add(TOUCHABLE_MISS);
        assertResults(accuracyResults, TOUCHED, TOUCHABLE_MISS);
        accuracyResults.add(MISSED);
        assertResults(accuracyResults, TOUCHED, MISSED);
        accuracyResults.add(COUNTERABLE_MISSED);
        assertResults(accuracyResults, TOUCHED, COUNTERABLE_MISSED);
        accuracyResults.add(COUNTERED);
        assertResults(accuracyResults, TOUCHED, COUNTERED);
    }

    private void assertResults(List<AccuracyResult> accuracyResults, AccuracyResult bestResult, AccuracyResult worstResult) {
        AccuracyResult positiveResult = accuracyResultPicker.pick(true, accuracyResults);
        AccuracyResult negativeResult = accuracyResultPicker.pick(false, accuracyResults);
        assertThat(positiveResult).isEqualTo(bestResult);
        assertThat(negativeResult).isEqualTo(worstResult);
    }
}