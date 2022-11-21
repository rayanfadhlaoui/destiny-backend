package ca.destiny.battle2;

import ca.destiny.battle2.factory.dice.AccuracyDices;
import ca.destiny.battle2.factory.dice.DamageDices;
import ca.destiny.battle2.factory.dice.DiceFactory;
import ca.destiny.other.RandomNumberGeneratorService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class DiceFactoryTest {
    private final DiceFactory diceFactory = new DiceFactory(mock(RandomNumberGeneratorService.class));

    @Test
    void getAccuracyDices() {
        assertForDamage(3, 3, 1, true);
        assertForDamage(3, 2, 2, true);
        assertForDamage(2, 3, 2, false);
        assertForDamage(1, 9, 5, false);
    }

    @Test
    void getDamageDices() {
        assertForDamage(3, 3, 1, true);
        assertForDamage(3, 2, 2, true);
        assertForDamage(2, 3, 2, false);
        assertForDamage(1, 9, 5, false);
    }

    private void assertForDamage(int strength, int defense, int expectedDices, boolean isPositive) {
        var dices = diceFactory.getDamageDices(strength, defense);
        assertThat(dices).isInstanceOf(DamageDices.class);
        assertThat(dices.getNumberOfDice()).isEqualTo(expectedDices);
        assertThat(dices.isPositive()).isEqualTo(isPositive);
    }

    private void assertForAccuracy(int dexterity, int dodge, int expectedDices, boolean isPositive) {
        var dices = diceFactory.getAccuracyDices(dexterity, dodge);
        assertThat(dices).isInstanceOf(AccuracyDices.class);
        assertThat(dices.getNumberOfDice()).isEqualTo(expectedDices);
        assertThat(dices.isPositive()).isEqualTo(isPositive);
    }

}