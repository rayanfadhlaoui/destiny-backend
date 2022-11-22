package ca.destiny.battle2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Characteristics {
    private int dexterity;
    private int dodge;
    private int strength;
    private int defense;
    private int resistance;
    private int initiative;
    private int vitalityInitial;
    private int vitality;

    public void resetVitality() {
        vitality = vitalityInitial;
    }

    public void decreaseVitality(int value) {
        this.vitality -= value;
    }

}
