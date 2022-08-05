package ca.destiny.battle.action;

public class HitService {

    public int hitPercentage(int dexterity, int dodge) {
        int diff = dexterity - dodge;
        int sign = diff < 0 ? -1 : 1;
        return 500 + computeDelta(diff, sign);
    }

    private int computeDelta(int diff, int sign) {
        if (diff >= 130 || diff <= -130) {
            return 400 * sign;
        }
        if (diff >= -50 && diff <= 50) {
            return diff * 5;
        } else if (diff >= -70 && diff <= 70) {
            int rest = diff - (50 * sign);
            return computeDelta(50*sign, sign) + rest * 3;
        } else if (diff >= -100 && diff <= 100) {
            int rest = diff - (70 * sign);
            return computeDelta(70*sign, sign) + rest * 2;
        } else {
            int rest = diff - (100 * sign);
            return computeDelta(100*sign, sign) + rest;
        }
    }

}
