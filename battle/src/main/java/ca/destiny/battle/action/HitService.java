package ca.destiny.battle.action;

import java.util.HashMap;
import java.util.Map;

public class HitService {

    private final static Map<Integer, Integer> percentageByValue = new HashMap<>();

    static {
        percentageByValue.put(-20, 0);
        percentageByValue.put(-19, 2);
        percentageByValue.put(-18, 4);
        percentageByValue.put(-17, 6);
        percentageByValue.put(-16, 8);
        percentageByValue.put(-15, 10);
        percentageByValue.put(-14, 13);
        percentageByValue.put(-13, 16);
        percentageByValue.put(-12, 19);
        percentageByValue.put(-11, 22);
        percentageByValue.put(-10, 25);
        percentageByValue.put(-9, 29);
        percentageByValue.put(-8, 33);
        percentageByValue.put(-7, 37);
        percentageByValue.put(-6, 41);
        percentageByValue.put(-5, 46);
        percentageByValue.put(-4, 50);
        percentageByValue.put(-3, 53);
        percentageByValue.put(-2, 59);
        percentageByValue.put(-1, 64);
        percentageByValue.put(0, 65);
        percentageByValue.put(1, 67);
        percentageByValue.put(2, 69);
        percentageByValue.put(3, 71);
        percentageByValue.put(4, 73);
        percentageByValue.put(5, 75);
        percentageByValue.put(6, 77);
        percentageByValue.put(7, 79);
        percentageByValue.put(8, 81);
        percentageByValue.put(9, 83);
        percentageByValue.put(10, 85);
        percentageByValue.put(11, 87);
        percentageByValue.put(12, 89);
        percentageByValue.put(13, 91);
        percentageByValue.put(14, 92);
        percentageByValue.put(15, 93);
        percentageByValue.put(16, 94);
        percentageByValue.put(17, 96);
        percentageByValue.put(18, 98);
        percentageByValue.put(19, 99);
        percentageByValue.put(20, 100);
    }


    public int hitPercentage(int dexterity, int dodge) {
        int diff = dexterity - dodge;
        if (diff < -20) {
            return 0;
        } else if (diff > 20) {
            return 100;
        }
        return percentageByValue.get(diff);
    }

}
