package ca.destiny.battle2.factory.dice;

import java.util.Arrays;

public enum DamageResult {

    COUNTERED(1), //Can be countered
    COUNTERABLE(2), // Can touch if accurate
    NO_DAMAGE(3),
    BARELY_ENDURED(4),
    ENDURABLE_DAMAGE(5), // Can be endured
    DAMAGED(6);

    private final int value;

    DamageResult(int value) {
        this.value = value;
    }

    public static DamageResult forValue(int value) {
        return Arrays.stream(DamageResult.values())
                .filter(p -> p.value == value)
                .findFirst()
                .orElseThrow();
    }

    public int getValue() {
        return value;
    }
}
