package ca.destiny.weapon.behavior;

import ca.destiny.fighter.BattleInformation;
import ca.destiny.fighter.equipment.weapon.WeaponDto;
import ca.destiny.weapon.WeaponDamageService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OptimalWeaponFinder {

    private final WeaponDamageService weaponDamageService;

    public OptimalWeaponFinder(WeaponDamageService weaponDamageService) {
        this.weaponDamageService = weaponDamageService;
    }

    public Optional<WeaponDto> findOptimal(List<WeaponDto> weapons, BattleInformation battleInformation) {
        return weapons.stream()
                .filter(w -> w.getStaminaNeeded() <= battleInformation.getStamina() / 3)
                .filter(w -> w.getMinimumDexterity() <= battleInformation.getDexterity())
                .min((o1, o2) -> {
                    Integer average1 = getAverageDamage(o1, battleInformation);
                    Integer average2 = getAverageDamage(o2, battleInformation);
                    return average2.compareTo(average1);
                });
    }

    private Integer getAverageDamage(WeaponDto weaponDto, BattleInformation battleInformation) {
        var range = weaponDamageService.getRange(weaponDto, battleInformation);
        return (range.getLeft() + range.getRight()) / 2;
    }
}
