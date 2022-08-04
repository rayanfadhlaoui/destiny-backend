package ca.destiny.battle.action;

public class DefenseService {

    public int getDamageReduction(Integer defense) {
        return computeDamageReduction(0, new Range(0, 1), defense);
    }

    private int computeDamageReduction(int currentValue, Range points, Integer target) {
        int newValue = currentValue + 10;
        if (newValue >= target) {
            return (target - currentValue) * points.getRight();
        }

        return computeDamageReduction(newValue, getPoints(points), target) + (10 * points.getRight());
    }

    private Range getPoints(Range range) {
        Range result;
        if (range.getRight() == 1) {
            result = new Range(range.getRight(), 5);
        } else if (range.getRight() == 5) {
            result = new Range(range.getRight(), 10);
        } else if (range.getRight() == 10) {
            result = new Range(range.getRight(), 20);
        } else {
            result = new Range(range.getRight(), range.getRight() + range.getLeft());
        }
        return result;
    }
}
