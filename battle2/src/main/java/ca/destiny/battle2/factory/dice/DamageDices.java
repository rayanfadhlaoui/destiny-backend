package ca.destiny.battle2.factory.dice;

import ca.destiny.battle2.Action;
import ca.destiny.other.RandomNumberGeneratorService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DamageDices extends Dices{
    public DamageDices(double numberOfDice, boolean isPositive, RandomNumberGeneratorService randomNumberGeneratorService) {
        super(numberOfDice, isPositive, randomNumberGeneratorService);
    }

    public List<DamageResult> getResults() {
        return IntStream.range(0, (int) numberOfDice)
                .map(i -> randomNumberGeneratorService.getRandomNumberInts(1, 6))
                .boxed()
                .map(DamageResult::forValue)
                .collect(Collectors.toList());
    }
}
