package ca.destiny.battle.action;

import ca.destiny.fighter.BattleInformation;
import ca.destiny.fighter.equipment.weapon.WeaponDto;

public class WeaponDamageService {
    public Range getRange(WeaponDto weapon, BattleInformation battleInformation) {

        var abilityWeight = weapon.getAbilityWeight();
        int dexterityWeight = abilityWeight.getDexterity() * battleInformation.getDexterity();
        int speedWeight = abilityWeight.getSpeed() * battleInformation.getSpeed();
        int strengthWeight = abilityWeight.getStrength() * battleInformation.getStrength();

        int value = (dexterityWeight + speedWeight + strengthWeight) / 100;

        int minimum = weapon.getMinimumDamage() + ((value * weapon.getMinimumDamage()) / 25);
        int maximum = weapon.getMaximumDamage() + ((value * weapon.getMaximumDamage()) / 25);

        return new Range(minimum, maximum);
    }
}
