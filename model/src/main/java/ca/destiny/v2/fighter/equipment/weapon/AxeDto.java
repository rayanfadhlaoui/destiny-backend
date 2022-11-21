package ca.destiny.v2.fighter.equipment.weapon;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("AxeDto")
public class AxeDto extends WeaponDto {

    private final static AbilityWeight AXE_WEIGHT;

    static {
        AXE_WEIGHT = new AbilityWeight();
        AXE_WEIGHT.setStrength(70);
        AXE_WEIGHT.setDexterity(20);
        AXE_WEIGHT.setSpeed(10);
    }
    @Override
    public WeaponType getWeaponType() {
        return WeaponType.AXE;
    }

    @Override
    public AbilityWeight getAbilityWeight() {
        return AXE_WEIGHT;
    }
}
