package ca.destiny.battle2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Characteristics {
    private final int dexterity;
    private final int dodge;
    private final int strength;
    private final int defense;
    private final int resistance;
    private final int vitalityInitial;
    private int vitality;

    public void resetVitality() {
        vitality = vitalityInitial;
    }

    public void decreaseVitality(int value) {
        this.vitality -= value;
    }
}
