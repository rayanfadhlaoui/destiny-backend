package ca.destiny.battle2.factory.dice;

import ca.destiny.other.RandomNumberGeneratorService;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Dices {

    protected double numberOfDice;
    protected boolean isPositive;
    protected RandomNumberGeneratorService randomNumberGeneratorService;
}
