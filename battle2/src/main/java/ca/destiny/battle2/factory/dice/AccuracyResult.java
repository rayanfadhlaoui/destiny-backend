package ca.destiny.battle2.factory.dice;

import java.util.Arrays;

public enum AccuracyResult {
    COUNTERED(1), //Can be countered
    COUNTERABLE_MISSED(2), // Can touch if accurate
    MISSED(3),
    TOUCHABLE_MISS(4),
    DODGABLE_TOUCH(5), // Can be dodged
    TOUCHED(6);

    private final int value;

    AccuracyResult(int value) {
        this.value = value;
    }

    public static AccuracyResult forValue(int value) {
        return Arrays.stream(AccuracyResult.values())
                .filter(p -> p.value == value)
                .findFirst()
                .orElseThrow();
    }

    public int getValue() {
        return value;
    }
}
