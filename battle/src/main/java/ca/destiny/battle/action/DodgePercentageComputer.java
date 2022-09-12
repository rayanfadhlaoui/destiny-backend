package ca.destiny.battle.action;

public class DodgePercentageComputer {

    public int compute(int value) {
        int result = 0;
        if (value < 0 && value > -100) {
            return 100 - Math.abs(value);
        } else if (value >= 0) {
            result = computePositive(value) + 100;
        }
        return result;
    }

    private int computePositive(int value) {
        if (value >= 250) {
            return 300;
        }
        return (int) (value * 1.2);
    }
}
