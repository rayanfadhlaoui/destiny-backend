package ca.destiny.weapon.behavior;

import ca.destiny.fighter.CharacteristicsDto;
import ca.destiny.fighter.equipment.weapon.WeaponDto;
import ca.destiny.weapon.WeaponDamageService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OptimalWeaponFinder {

    private final WeaponDamageService weaponDamageService;

    public OptimalWeaponFinder(WeaponDamageService weaponDamageService) {
        this.weaponDamageService = weaponDamageService;
    }

    public WeaponDto findOptimal(List<WeaponDto> weapons, CharacteristicsDto characteristicsDto) {
        return weapons.stream()
                .min((o1, o2) -> {
                    Integer average1 = getAverageDamage(o1, characteristicsDto);
                    Integer average2 = getAverageDamage(o2, characteristicsDto);
                    return average2.compareTo(average1);
                })
                .orElseThrow(IllegalArgumentException::new);
    }

    private Integer getAverageDamage(WeaponDto weaponDto, CharacteristicsDto characteristicsDto) {
        var range = weaponDamageService.getRange(weaponDto, characteristicsDto);
        return (range.getLeft() + range.getRight()) / 2;
    }
}
