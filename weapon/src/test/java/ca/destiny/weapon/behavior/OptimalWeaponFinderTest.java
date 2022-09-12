package ca.destiny.weapon.behavior;

import ca.destiny.fighter.BattleInformation;
import ca.destiny.fighter.equipment.weapon.*;
import ca.destiny.weapon.WeaponDamageService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class OptimalWeaponFinderTest {

    private final OptimalWeaponFinder optimalWeaponFinder = new OptimalWeaponFinder(new WeaponDamageService());

    @Test
    void findOptimal_WithSameDamage() {
        List<WeaponDto> weapons = Arrays.asList(createAxe(), createDagger(), createSword());

        WeaponDto optimal = optimalWeaponFinder.findOptimal(weapons, createBattleInformation()).get();
        assertThat(optimal).isInstanceOf(DaggerDto.class);
    }

    private BattleInformation createBattleInformation() {
        BattleInformation battleInformation = new BattleInformation();
        battleInformation.setDexterity(100);
        battleInformation.setStrength(50);
        battleInformation.setSpeed(50);
        return battleInformation;
    }

    private WeaponDto createSword() {
        WeaponDto weaponDto = new SwordDto();
        weaponDto.setPenetration(10);
        weaponDto.setName("Steel sword");
        weaponDto.setMinimumDamage(10);
        weaponDto.setMaximumDamage(20);
        return weaponDto;
    }

    private WeaponDto createAxe() {
        WeaponDto weaponDto = new AxeDto();
        weaponDto.setPenetration(10);

        weaponDto.setName("Steel Axe");
        weaponDto.setMinimumDamage(10);
        weaponDto.setMaximumDamage(20);
        return weaponDto;
    }

    private WeaponDto createDagger() {
        WeaponDto weaponDto = new DaggerDto();
        weaponDto.setPenetration(10);
        weaponDto.setName("Steel Dagger");
        weaponDto.setMinimumDamage(10);
        weaponDto.setMaximumDamage(20);
        return weaponDto;
    }

}