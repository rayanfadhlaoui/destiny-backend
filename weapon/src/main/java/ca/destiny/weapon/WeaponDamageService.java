package ca.destiny.weapon;

import ca.destiny.fighter.BattleInformation;
import ca.destiny.fighter.equipment.weapon.WeaponDto;
import ca.destiny.other.Range;
import org.springframework.stereotype.Component;

@Component
public class WeaponDamageService {

    public Range getRange(WeaponDto weapon, BattleInformation battleInformation) {
        return getRange(weapon,
                battleInformation.getDexterity(),
                battleInformation.getSpeed(),
                battleInformation.getStrength());
    }

    private Range getRange(WeaponDto weapon, int dexterity, int speed, int strength) {
        var abilityWeight = weapon.getAbilityWeight();
        var abilityBonus = weapon.getAbilityBonus();
        int dexterityWeight = abilityWeight.getDexterity() * (dexterity + abilityBonus.getDexterity());
        int speedWeight = abilityWeight.getSpeed() * (speed + abilityBonus.getSpeed());
        double strengthWeight = (abilityWeight.getStrength() * 1.1) * (strength + abilityBonus.getStrength());

        double value = (dexterityWeight + speedWeight + strengthWeight) / 110;

        Double minimum = weapon.getMinimumDamage() + ((value * weapon.getMinimumDamage()) / 25);
        Double maximum = weapon.getMaximumDamage() + ((value * weapon.getMaximumDamage()) / 25);

        return new Range(minimum.intValue(), maximum.intValue());
    }
}
