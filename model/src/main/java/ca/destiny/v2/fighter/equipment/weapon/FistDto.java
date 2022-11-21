package ca.destiny.v2.fighter.equipment.weapon;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("FistDto")
public class FistDto extends WeaponDto {

    private final static AbilityWeight FIST_WEIGHT;

    static {
        FIST_WEIGHT = new AbilityWeight();
        FIST_WEIGHT.setStrength(30);
        FIST_WEIGHT.setDexterity(10);
        FIST_WEIGHT.setSpeed(60);
    }

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.FIST;
    }

    @Override
    public AbilityWeight getAbilityWeight() {
        return FIST_WEIGHT;
    }
}
