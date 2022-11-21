package ca.destiny.evolution.v2.refresh;

import org.springframework.stereotype.Component;

@Component
public class CharacteristicsComputer {
    public int compute(int value) {
        int result = value;
        if (value > 100) {
            result = 100 + compute(value - 100, 2);
        }
        return result;
    }

    private int compute(int value, int delta) {
        int max = delta * 100;
        if (value < max) {
            return value / delta;
        }
        if (delta == 6) {
            return value / 6;
        } else {
            return 100 + compute(value - max, delta + 1);
        }
    }
}
