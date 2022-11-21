package ca.destiny.v2.fighter.equipment.weapon;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("DaggerDto")
public class DaggerDto extends WeaponDto {

    private final static AbilityWeight DAGGER_WEIGHT;

    static {
        DAGGER_WEIGHT = new AbilityWeight();
        DAGGER_WEIGHT.setStrength(10);
        DAGGER_WEIGHT.setDexterity(65);
        DAGGER_WEIGHT.setSpeed(30);
    }

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.DAGGER;
    }

    @Override
    public AbilityWeight getAbilityWeight() {
        return DAGGER_WEIGHT;
    }
}
