package ca.destiny.battle2;

import ca.destiny.battle2.factory.dice.AccuracyResult;
import ca.destiny.battle2.factory.dice.DamageResult;
import ca.destiny.battle2.factory.dice.DiceFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamageService {
    private final DiceFactory diceFactory;
    private final DamageResultPicker damageResultPicker;

    public DamageService(DiceFactory diceFactory,
                         DamageResultPicker damageResultPicker) {
        this.diceFactory = diceFactory;
        this.damageResultPicker = damageResultPicker;
    }
    public DamageResult getDamageAction(Fighter aggressor, Fighter defender) {
        int strength = aggressor.getCharacteristics().getStrength();
        int defense = defender.getCharacteristics().getDefense();
        var damageDices = diceFactory.getDamageDices(strength, defense);
        List<DamageResult> results = damageDices.getResults();
        return damageResultPicker.pick(damageDices.isPositive(), results);
    }


}
