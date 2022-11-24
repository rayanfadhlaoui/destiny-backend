package ca.destiny.battle2;

import ca.destiny.battle2.factory.dice.DiceFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitiativeService {

    private final DiceFactory diceFactory;
    private final InitiativeResultPicker initiativeResultPicker;

    public InitiativeService(DiceFactory diceFactory, InitiativeResultPicker initiativeResultPicker) {
        this.diceFactory = diceFactory;
        this.initiativeResultPicker = initiativeResultPicker;
    }

    public int compare(int initiative, int initiative2) {
        var initiativeDices1 = diceFactory.getInitiativeDice(initiative, initiative2);
        var initiativeDices2 = diceFactory.getInitiativeDice(initiative2, initiative);
        List<Integer> results = initiativeDices1.getResults();
        List<Integer> results2 = initiativeDices2.getResults();

        int first = initiativeResultPicker.pick(initiativeDices1.isPositive(), results);
        int second = initiativeResultPicker.pick(initiativeDices2.isPositive(), results2);
        return first - second;
    }
}
