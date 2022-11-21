package ca.destiny.v2.fighter.equipment.weapon;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("SwordDto")
public class SwordDto extends WeaponDto {

    private final static AbilityWeight SWORD_WEIGHT;

    static {
        SWORD_WEIGHT = new AbilityWeight();
        SWORD_WEIGHT.setStrength(40);
        SWORD_WEIGHT.setDexterity(40);
        SWORD_WEIGHT.setSpeed(20);
    }

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.SWORD;
    }

    @Override
    public AbilityWeight getAbilityWeight() {
        return SWORD_WEIGHT;
    }
}
