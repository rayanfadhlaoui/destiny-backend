package ca.destiny.battle2;

import ca.destiny.battle2.factory.dice.AccuracyResult;
import ca.destiny.battle2.factory.dice.DiceFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccuracyService {

    private final DiceFactory diceFactory;
    private final AccuracyResultPicker accuracyResultPicker;

    public AccuracyService(DiceFactory diceFactory, AccuracyResultPicker accuracyResultPicker) {
        this.diceFactory = diceFactory;
        this.accuracyResultPicker = accuracyResultPicker;
    }

    public AccuracyResult getAccuracyAction(Fighter aggressor, Fighter defender) {
        int dexterity = aggressor.getCharacteristics().getDexterity();
        int dodge = defender.getCharacteristics().getDodge();
        var accuracyDices = diceFactory.getAccuracyDices(dexterity, dodge);
        List<AccuracyResult> results = accuracyDices.getResults();

        return accuracyResultPicker.pick(accuracyDices.isPositive(), results);
    }
}
